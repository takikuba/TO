import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.DefaultMenuLayout;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

public class Client extends JFrame {
    private InputStream input;
    private OutputStream out;

    private Socket socket;
    private ChainElement chain;

    private JTextArea textArea = new JTextArea(10,18);
    private JTextField textField = new JTextField();
    private JButton buttonDisconnect = new JButton("Disconnect");
    private JButton buttonFile = new JButton("File");
    private byte[] nameB;

    public static final byte TYPE_TEXT = 1;
    public static final byte TYPE_IMG = 2;
    public static final byte TYPE_SOUND = 3;

    public static void main(String[] args) {
        new Client();
    }

    public Client(){
        setTitle("Client:");
        setSize(315, 200);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel con = new JPanel();
        con.setLayout(new BorderLayout());

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());

        textArea.setEditable(false);
        JScrollPane pane = new JScrollPane(textArea);
        content.add(pane, BorderLayout.CENTER);

        textField.addActionListener( (e)->{
            sendText(textField.getText());
            textField.setText("");
        });
        content.add(textField, BorderLayout.PAGE_END);

        JPanel content2 = new JPanel();
        content2.setLayout(new BoxLayout(content2, BoxLayout.PAGE_AXIS));
        content2.add(buttonDisconnect);
        buttonDisconnect.addActionListener((e)->{
            System.exit(0);
        });
        content2.add(buttonFile);
        buttonFile.addActionListener((e)->{
            getFile();
        });

        con.add(content, BorderLayout.LINE_START);
        con.add(content2, BorderLayout.LINE_END);

        getContentPane().add(con);

        chain = new TextElement(textArea, new ImageElement(textArea, new SoundElement(textArea, null)));
//        String host = getHost(); // LOGOWANIE DO SERVERA
//        int address = getServerAddress(); // LOGOWANIE DO SERVERA

        try{
            socket = new Socket("localhost", 9999);
//            socket = new Socket(host, address); // LOGOWANIE DO SERVERA
            input = socket.getInputStream();
            out = socket.getOutputStream();
            nameB = (getClientName()).getBytes();
            out.write(nameB);
            out.write('\n');
            byte b = (byte) input.read();
            if(b == 0){
                JOptionPane.showMessageDialog(null, "Imie zajete!", "Error!", JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }
            setTitle("Client: " + new String(nameB));
            new Thread(this::startListen).start();

        } catch (UnknownHostException e){
            System.out.println("Nieznany host!");
        } catch (IOException e){
            System.out.println("Bład we/wy!");
        }

        setVisible(true);
    }

    private String getClientName() {
        return JOptionPane.showInputDialog(this, "ChooseName:", "Name",
                JOptionPane.PLAIN_MESSAGE);
    }

    private int getServerAddress() {
        return Integer.parseInt(JOptionPane.showInputDialog(this, "Type server address:", "ServerAddress",
                JOptionPane.PLAIN_MESSAGE));
    }

    private String getHost() {
        return JOptionPane.showInputDialog(this, "Type host name:", "Host",
                JOptionPane.PLAIN_MESSAGE);
    }

    private void sendText(String text){
         byte[] strB = text.getBytes();
         sendBytes(strB, TYPE_TEXT);
    }
    private void sendImage(File file){
        try {
            BufferedImage image = ImageIO.read(file);
            ByteArrayOutputStream byos = new ByteArrayOutputStream();
            if( image != null){
                ImageIO.write(image, "bmp", byos);
                sendBytes(byos.toByteArray(), TYPE_IMG);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void sendSound(File file){
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            sendBytes(fileInputStream.readAllBytes(), TYPE_SOUND);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void sendBytes(byte[] a, byte t){
        int size = a.length;
        byte[] sB = ByteBuffer.allocate(4).putInt(size).array();
        try {
            out.write(t);
            out.write(ByteBuffer.allocate(4).putInt(nameB.length).array());
            out.write(nameB);
            out.write(sB);
            out.write(a);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void getFile(){
        JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
        chooser.setFileFilter(new FileNameExtensionFilter("BMP&WAV", "bmp", "wav"));
        int reval = chooser.showOpenDialog(this);
        if(reval == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
//            System.out.println("You chose to open this file: " + file.getName());
            switch (file.getName().substring(file.getName().lastIndexOf("."))) {
                case (".bmp") -> sendImage(file);
                case (".wav") -> sendSound(file);
                default -> System.out.println("Zly format!");
            }
        }
    }

    private void startListen(){
        try{
            while(socket.isConnected()){
                byte msgType = (byte) input.read();
                byte[] sizeN = new byte[4];
                input.read(sizeN, 0, 4);
                int sN = ByteBuffer.wrap(sizeN).asIntBuffer().get();
                byte[] name = new byte[sN];
                input.read(name, 0, sN);

                byte[] sizeM = new byte[4];
                input.read(sizeM, 0, 4);
                int sM = ByteBuffer.wrap(sizeM).asIntBuffer().get();

                byte[] message = new byte[sM];
                int offset = 0;
                while(offset < sM){
                    offset += input.read(message, offset, sM-offset);
                }

                String nick = new String(name);

                chain.handleRequest(msgType, nick, message);

            }
        }catch (IOException e){
            JOptionPane.showMessageDialog(null, "Server closed!", "Error", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
    }

}

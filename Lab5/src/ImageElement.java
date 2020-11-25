import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ImageElement extends ChainElement {

    public ImageElement(JTextArea text, ChainElement next){
        super(text, next);
    }
    @Override
    boolean checkDataType(int type) {
        return type == Client.TYPE_IMG;
    }

    @Override
    void handleConcreteRequest(byte type, String nick, byte[] array) {
        ByteArrayInputStream in = new ByteArrayInputStream(array);
        try {
            BufferedImage image = ImageIO.read(in);
            JFrame frame = new JFrame(nick + " send photo!");
            JLabel label = new JLabel(new ImageIcon(image));
            frame.getContentPane().add(label);
            frame.pack();
            frame.setVisible(true);
            getTextArea().append(nick + " SEND PHOTO!\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Server {
    private List<ServerThread> threads = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();
    private List<String> names = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.startServer();
    }

    public void startServer(){
        try (ServerSocket serverSocket = new ServerSocket(9999)){
            while(true) {
                Socket socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket);
                threads.add(serverThread);
                serverThread.start();
            }
        } catch ( IOException e) {
            System.out.println("Port in use: " + e.getMessage());
        }
    }

    private boolean checkName(String name){
        if(names.contains(name)){
            return false;
        }
        names.add(name);
        return true;
    }

    private void notifyObservers(byte[] buffor, int len){
        for(Observer observer: observers){
            observer.notify(buffor, len);
        }
    }

    public void sendMessage(byte[] buffor, int len){
        notifyObservers(buffor, len);
    }

    private void addObserver(Observer observer){
        observers.add(observer);
    }
    private void rmObserver(Observer observer){
        observers.remove(observer);
    }
    private void rmName(String name){
        names.remove(name);
    }
    private void serverMessage(String str){
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte t = 1; // typ
        byte[] a = str.getBytes(); //Wiadomosc str
        int size = a.length; // Rozniar int
        byte[] sB = ByteBuffer.allocate(4).putInt(size).array(); //Rozmiar wiadomosco
        byte[] nameB = "SERVER".getBytes(); // Nazwa Servera
        try {
            buffer.write(t);
            buffer.write(ByteBuffer.allocate(4).putInt(nameB.length).array());
            buffer.write(nameB);
            buffer.write(sB);
            buffer.write(a);
            sendMessage(buffer.toByteArray(), buffer.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ServerThread extends Thread implements Observer{

        private final Socket socket;
        private InputStream input;
        private OutputStream output;
        private String name;

        public ServerThread(Socket socket) throws IOException {
            this.socket = socket;
            input = socket.getInputStream();
            output = socket.getOutputStream();
            addObserver(this);
        }

        public void run(){
            System.out.println("Server running...");

            byte[] buffor = new byte[2048];

            try {
                if(!readNameFromSocket()) return;
                while(true){
                    int len = input.read(buffor, 0, buffor.length);
                    if(len <= 0){
                        close();
                        return;
                    }
                    sendMessage(buffor, len);
                }
            } catch (IOException e) {
                e.printStackTrace();
                close();
            }

        }

        private boolean readNameFromSocket(){
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String nick = reader.readLine();
                if(!checkName(nick)){
                    output.write(0);
                    close();
                    return false;
                } else {
                    output.write(1);
                    this.name = nick;
                    System.out.println(name + " has joined.");
                    serverMessage(name + " HAS JOINED.");
                }
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }

        public void close() {
            try {
                rmName(name);
                rmObserver(this);
                System.out.println(name + " living!");
                serverMessage(name + " HAS LEFT!");
                socket.close();
            } catch (IOException e) {
//                e.printStackTrace();
            }
        }

        @Override
        public void notify(byte[] buffor, int len) {
            try {
                output.write(buffor, 0, len);
            } catch (IOException e) {
                System.out.println("Połaczenie przerwane!");
                close();
            }
        }

    }
}



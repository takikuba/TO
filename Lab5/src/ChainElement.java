import javax.swing.*;
import java.math.BigInteger;
import java.nio.ByteBuffer;

public abstract class ChainElement {
    private ChainElement next;
    private JTextArea text;

    public ChainElement(JTextArea text, ChainElement next){
        this.next = next;
        this.text = text;
    }

    public void handleRequest(byte type, String nick, byte[] array){
        if(!checkDataType(type)){
            if(next != null)
                next.handleRequest(type, nick, array);
        }
        else handleConcreteRequest(type, nick, array);
    }

    public JTextArea getTextArea(){
        return text;
    }

    abstract boolean checkDataType(int type);
    abstract void handleConcreteRequest(byte type, String nick, byte[] array);

}


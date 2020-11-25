import javax.swing.*;
import java.nio.ByteBuffer;

public class TextElement extends ChainElement {

    public TextElement(JTextArea text, ChainElement next) {
        super(text, next);
    }

    @Override
    boolean checkDataType(int type) {
        return type==Client.TYPE_TEXT;
    }

    @Override
    void handleConcreteRequest(byte type, String nick, byte[] array) {
        String msg = new String(array);
        getTextArea().append(nick + ": " + msg + "\n");
    }
}

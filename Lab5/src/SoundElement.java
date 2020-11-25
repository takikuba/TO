import javax.sound.sampled.*;
import javax.swing.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class SoundElement extends ChainElement {

    public SoundElement(JTextArea text, ChainElement next){
        super(text, next);
    }

    @Override
    boolean checkDataType(int type) {
        return type == Client.TYPE_SOUND;
    }

    @Override
    void handleConcreteRequest(byte type, String nick, byte[] array) {
        ByteArrayInputStream in = new ByteArrayInputStream(array);

        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(in);
            AudioFormat af = ais.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, af);
            SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(af);
            line.start();
            line.write(array, 0, array.length);
            line.drain();
            line.close();
            getTextArea().append(nick + " SEND SOUND!\n");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

    }
}

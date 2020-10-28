import java.util.regex.Pattern;

public class Proxy implements Component {

    File file;

    public Proxy(String name){
        if(!name.matches("[a-zA-Z0-9.]+")){
            throw new IllegalArgumentException("Nieprawidłowa nazwa!");
        } else {
            file = new File(name);
        }
    }

    @Override
    public String getName() {
        return file.getName();
    }

    @Override
    public void rename(String name) {
        if(!name.matches("[a-zA-Z0-9.]+")){
            System.out.println("Niepoprawna nazwa!");
        } else {
            file.rename(name);
        }
    }

    public void setContent(String content){
        file.setContent(content);
    }

    public byte[] getContent() {
        return file.getContent();
    }

    public void more(){
        file.more();
    }

    public void catContent(){
        file.catContent();
    }

    @Override
    public String toString() {
        return file.toString();
    }


}

import java.util.Arrays;

public class File implements Component{

    private byte[] content = null;
    private String name;

    public File(String name){
        this.name = name;
    }

    public void setContent(String content){
        this.content = content.getBytes();
    }

    public byte[] getContent() {
        return content;
    }

    public void more(){
        System.out.println(new String(content));
    }

    public void catContent(){
        System.out.println(new String(content));
    }

    @Override
    public String toString() {
        return getName();
    }

    public String getName(){
        return name;
    }

    public void rename(String name){
        this.name = name;
    }
}

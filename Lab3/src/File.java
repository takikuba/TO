import java.util.Arrays;

public class File {
    String name;
    byte[] content = null;
    String path;

    public File(String name){
        this.name = name;
    }
    public void setContent(String content){
        this.content = content.getBytes();
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return this.name;
    }

    public String catContent(){
        return Arrays.toString(content);
    }

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                ", content=" + Arrays.toString(content) +
                ", path='" + path + '\'' +
                '}';
    }
}

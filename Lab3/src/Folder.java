import java.nio.file.Path;

public class Folder {
    private String name;
    private String path;

    public Folder(String name, String path){
        this.name = name;
        this.path = path;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public String getPath(){
        return path;
    }
    @Override
    public String toString(){
        return path+"\'"+name;
    }
}

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Folder implements Component {

    private List<Component> children = new ArrayList<>();
    private String name;

    public Folder(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return getName() + "/";
    }

    public void add(Component component){
        if(!children.contains(component)) {
            children.add(component);
        }
    }

    public void ls(){
        for(Component c: children){
            System.out.println(c.getName());
        }
    }

    public void tree(int x){
        for (Component c: children){
            System.out.print(" ".repeat(x+1));
            System.out.println(c.getName());
            if(c instanceof Folder){
                ((Folder) c).tree(x);
            }
        }
    }
    public void tree(){
        for (Component c: children){
            System.out.println(c.getName());
            if(c instanceof Folder){
                ((Folder) c).tree(1);
            }
        }
    }
    public final String getName(){
        return name;
    }

    public void rename(String name){
        this.name = name;
    }
}

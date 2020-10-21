import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Terminal {

    String manual = "Hello!\n" +
            "Option:\n" +
            "--man: go to manual\n" +
            "--ls: list directory contents\n" +
            "--shutdown: shutdown terminal\n";

    public static void main(String[] args) {
        Folder folder = new Folder("root", "/.");
        System.out.println(folder.toString());
        File file = new File("file1");
        file.setContent("file1");
        System.out.println(file.catContent());
    }

    public Terminal(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello type --man");
        String line = scanner.nextLine();
        while(!line.equals("shutdown")){
            switch (line) {
                case "man":
                    System.out.println(manual);
                case "":

            }

            line = scanner.nextLine();
        }
    }


}

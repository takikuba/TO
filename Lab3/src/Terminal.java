public class Terminal {

    public static void main(String[] args) {

        Folder one = new Folder("1");
        Folder root = new Folder("1.1");
        Folder root2 = new Folder("1.2");
        one.add(root);
        one.add(root2);

        File file11 = new File("file11");
        file11.setContent("Text file11");
        file11.catContent();

        File file12 = new File("file11");
        file12.setContent("Text file12");
        file12.catContent();

        root.add(file11);
        root2.add(file12);

        one.tree();


    }


}
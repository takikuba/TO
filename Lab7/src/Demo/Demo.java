package Demo;

import Game.Menu;
import Screens.SceneManager;
import Screens.Screen;

public class Demo {

    private Screen screen;
    private SceneManager manager;
    private Menu menu;

    public static void main(String[] args) {
        Demo demo = new Demo();
    }

    public Demo(){
        screen = new Screen();
        SceneManager manager = new SceneManager(screen);

        manager.menuScreen();

        screen.setVisible(true);
    }
}

package Screens;

import Game.Game;
import Game.Menu;

import javax.swing.*;

public class SceneManager {

    private Menu menu;
    private Screen screen;
    private Game game;
    private JFrame frame;

    public SceneManager(Screen screen){
        this.screen = screen;
        this.frame = screen.getScreen();
    }

    public void setScene(JPanel component){
        frame.getContentPane().removeAll();
        frame.getContentPane().add(component);
        frame.revalidate();
        frame.repaint();
    }

    public void backToMenu(){
        setScene(menu);
    }

    public boolean continueGame(){
        if(game != null){
            setScene(game);
            return true;
        }
        return false;
    }

    public void newGame(){
        game = new Game(this);
        setScene(game);
    }

    public void menuScreen(){
        menu = new Menu(this);
        setScene(menu);
    }

}

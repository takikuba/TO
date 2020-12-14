package Game;

import Buttons.MyButton;
import Messages.Man;
import Screens.SceneManager;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {

    private SceneManager manager;
    private JButton buttonNewGame = new MyButton("Nowy szpil");
    private JButton buttonContinue = new MyButton("Kōntynuuj");
    private JButton buttonExit = new MyButton("Kōniec");
    private Image image;
    private Man man;

    public Menu(SceneManager manager){
//        System.out.println("Menu running...");
        this.manager = manager;
        image = new ImageIcon("res\\menuBackgriund.png").getImage();
        setLayout(null);

        addMenuOptions();
    }

    private void addMenuOptions() {
        buttonNewGame.addActionListener((e)-> newGame());
        buttonContinue.addActionListener((e)-> continueGame());
        buttonExit.addActionListener((e)-> System.exit(0));

        buttonNewGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonContinue.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonExit.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panelOption = new JPanel();
        panelOption.setLayout(new BoxLayout(panelOption, BoxLayout.Y_AXIS));
        panelOption.add(buttonNewGame);
        panelOption.add(buttonContinue);
        panelOption.add(buttonExit);
        panelOption.setOpaque(false);
        panelOption.setBounds(300, 80, 200, 150);
        add(panelOption);

        man = new Man();
        man.setBounds(650, 0, 150, 500);
        add(man);
    }

    private void continueGame() {
        if(!manager.continueGame()){
//            System.out.println("No game in memory!");
            man.printMessage("Brak szpilu w pamieci!");
        }
    }

    private void newGame(){
        manager.newGame();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

}

package Game;

import Buttons.ButtonBack;
import Buttons.IconButton;
import Constructions.Construction;
import Messages.Man;
import Screens.SceneManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Klasa gry bedzie opierać się o model siatki 4x4
public class Game extends JPanel {

    private SceneManager manager;
    private JButton buttonBack;
    private Board board;
    private Man man;
    private int coins = 2000;
    private ArrayList<Construction> constructions = new ArrayList<>();
    protected IconButton newBuilding;
    private JLabel money;
    private Image image;

    private long timeStart = System.nanoTime();

    public Game(SceneManager manager){
        setLayout(null);
        setBounds(0,0, 800, 500);
        this.manager = manager;
        buttonBack = new ButtonBack(manager);

        image = new ImageIcon("res\\gameBackgriund.png").getImage();

        setBackground(Color.green);
        add(buttonBack);

        board = new Board(this);
        board.lockButtons();
        man = new Man();
        man.setBounds(650, 0, 200, 500);
        add(man);
        getProfit();

        new Shop(this);
    }

    public boolean ableToBuild(IconButton construction){
        if(construction.getConstruction().getPrice() > coins){
            printMessage("Za malo pijyndzy!");
            return false;
        }
        return construction.getConstruction().ableToBuild(constructions);
    }

    public void setNewBuilding(IconButton construction){
        board.unlockButtons();
        coins -= construction.getConstruction().getPrice();
        money.setText("Pijōndze: " + coins);
        newBuilding = construction;
    }

    public ImageIcon getNewBuilding(){
        return newBuilding.getImageIcon();
    }

    public void addConstruction(){
        constructions.add(newBuilding.getConstruction());
        printMessage("");
    }
    public void repaintScene(){
        this.revalidate();
        this.repaint();
    }

    public void printMessage(String message){
        man.printMessage(message);
    }

    private void getProfit(){
        final int[] count = {0};
        JLabel label = new JLabel();
        label.setText("Burlu dnia: " + count[0]);
        label.setBounds(650, 400, 100, 20);
        add(label);

        money = new JLabel("Pijōndze: " + coins);
        money.setBounds(50, 400, 200, 30);
        add(money);

        // Aby usprawnic zegar odlicza do 24h, 1s ospowiada 1h
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count[0]++;
                label.setText("Burlu dnia: " + count[0]);
                repaint();
                if(count[0] >= 24){
                    count[0] = 0;
                    int incom = getIncome();
                    coins += incom;
                    printMessage("Dostołś: " + incom);
//                    System.out.println(coins);
                    money.setText("Pijōndze: " + coins);
                }
                if(count[0] == 3) printMessage("");
            }
        });
        timer.start();
        repaint();
    }

    private int getIncome(){
        int count = 0;
        for(Construction c: constructions){
            count += c.getIncome();
        }
        return count;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, -10, -40, null);
    }

}

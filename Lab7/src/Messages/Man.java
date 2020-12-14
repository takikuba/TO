package Messages;

import Buttons.IconButton;

import javax.swing.*;
import java.awt.*;

public class Man extends JLabel {

    private JPanel panel = new JPanel();
    private JButton man;
    private JLabel area;

    public Man(){
        setBackground(new Color(1,1,1,0));
        setLayout(null);
        man = new IconButton("res\\gornik.png");
        area = new JLabel();
        area.setText("Witej chopie!");

        man.setBorderPainted(false);
        man.setBounds(0, 70, 150, 200);
        area.setBounds(0,20,200, 70);
        area.setBackground(new Color(1,1,1,0));
        area.setBorder(null);

        add(man);
        add(area);
    }

    public void printMessage(String message){
        area.setText(message);
    }

}

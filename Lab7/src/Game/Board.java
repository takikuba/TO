package Game;

import javax.swing.*;
import java.awt.*;

public class Board {

    private Game container;
    private JButton[][] gridArray = new JButton[4][4];
    private int boardX = 200;
    private int boardY = 50;

    public Board(Game container){
        this.container = container;
        makeCanvas();
    }

    private void makeCanvas(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        panel.setBounds(boardX, boardY,400, 400);
        panel.setBackground(new Color(1,1,1,0));
        panel.setOpaque(false);
        for( int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                JButton button = new JButton();
                button.setContentAreaFilled(false);
                button.setFocusPainted(false);
                button.setOpaque(false);
                button.setBackground(new Color(1, 1, 1, 0));
                button.addActionListener((e) ->{
                    button.setIcon(container.getNewBuilding());
                    button.setDisabledIcon(container.getNewBuilding());
                    button.setSelected(true);
                    container.addConstruction();
                    lockButtons();
                });
                gridArray[i][j] = button;
            }
        }

        for(JButton[] button: gridArray){
            for(JButton jButton: button){
                panel.add(jButton);
            }
        }
        container.add(panel);
    }

    public void lockButtons(){
        for(JButton[] button: gridArray){
            for(JButton jButton: button){
                jButton.setEnabled(false);
            }
        }
    }
    public void unlockButtons(){
        for(JButton[] button: gridArray){
            for(JButton jButton: button){
                if(!jButton.isSelected()){
                    jButton.setEnabled(true);
                }
            }
        }
    }

}

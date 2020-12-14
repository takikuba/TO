package Screens;

import javax.swing.*;

public class Screen extends JFrame {

    private JPanel currentPanel;
    private JPanel lastPanel;

    public Screen(){
        setTitle("ślōnski szpil");
        setSize(800, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public JFrame getScreen(){
        return this;
    }

    public void setCurrentPanel(JPanel panel){
        this.currentPanel = panel;
    }

    public JPanel getCurrentPanel() {
        return currentPanel;
    }

    public void setLastPanel(JPanel panel){
        this.lastPanel = panel;
    }

    public JPanel getLastPanel() {
        return lastPanel;
    }

}

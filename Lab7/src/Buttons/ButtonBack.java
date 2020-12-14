package Buttons;

import Screens.SceneManager;

import javax.swing.*;

public class ButtonBack extends JButton {
    public ButtonBack(SceneManager manager) {
        super(new ImageIcon("res\\buttonBack.png"));
        setBounds(10, 10, 30, 30);
        setBorderPainted(false);
        setBorder(null);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);
        this.addActionListener((e) -> {
            manager.backToMenu();
        });
    }
}

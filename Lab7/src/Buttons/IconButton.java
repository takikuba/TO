package Buttons;

import Constructions.Construction;

import javax.swing.*;
import java.awt.*;

public class IconButton extends JButton {

    private Construction construction;

    public IconButton(String path){
        super(new ImageIcon(path));
        setter();
    }

    public IconButton(Construction construction){
        super(construction.getImageIcon());
        this.construction = construction;
        setter();
    }

    private void setter(){
        setSize(30,30);
        setBackground(new Color(1,1,1,0));
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);
    }

    public void printPrice(){
        construction.printPrice();
    }

    public ImageIcon getImageIcon(){
        return construction.getBigImageIcon();
    }

    public Construction getConstruction(){
        return construction;
    }

}

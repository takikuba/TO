package Constructions;

import javax.swing.*;
import java.util.ArrayList;

// Klasa obrazująca Kopalnie
public class Mine extends Construction{
    public Mine() {
        super(5000, "res\\kopalnia.png");
        name = "Gruba";
        need = "Tartak";
        income = 100;
    }

    @Override
    public boolean ableToBuild(ArrayList<Construction> constructions) {
        System.out.println("Proba budowania: " + getClass());
        for(Construction c: constructions){
            if(c.getClass() == Sawmill.class){
                return true;
            }
        }
        return false;
    }

    @Override
    public ImageIcon getBigImageIcon() {
        return new ImageIcon("res\\kopalniaBig.png");
    }
}

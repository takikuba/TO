package Constructions;

import javax.swing.*;
import java.util.ArrayList;

//Klasa obrazujaca tartak
public class Sawmill extends Construction{
    public Sawmill() {
        super(3000, "res\\tartak.png");
        name = "Tartak";
        need = "Kamieniolom";
        income = 500;
    }

    @Override
    public boolean ableToBuild(ArrayList<Construction> constructions) {
        for(Construction c: constructions){
            if(c.getClass() == Quarry.class){
                return true;
            }
        }
        return false;
    }

    @Override
    public ImageIcon getBigImageIcon() {
        return new ImageIcon("res\\tartakBig.png");
    }
}

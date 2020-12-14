package Constructions;

import javax.swing.*;
import java.util.ArrayList;

//Klasa Obrazujaca mennice
public class Mint extends Construction{
    public Mint() {
        super(10000, "res\\mennica.png");
        name = "Mennica";
        need = "Dōm siōngŏrza";
        income = 3000;
    }

    @Override
    public boolean ableToBuild(ArrayList<Construction> constructions) {
        System.out.println("Proba budowania: " + getClass());
        for(Construction c: constructions){
            if(c.getClass() == Hut.class){
                return true;
            }
        }
        return false;
    }

    @Override
    public ImageIcon getBigImageIcon() {
        return new ImageIcon("res\\mennicaBig.png");
    }
}

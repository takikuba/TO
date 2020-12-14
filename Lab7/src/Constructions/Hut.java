package Constructions;

import javax.swing.*;
import java.util.ArrayList;

//Klasa obrazująca Chatke Drwala
public class Hut extends Construction{

    public Hut(){
        super(1500, "res\\chatka.png");
        name = "Dōm siōngŏrza";
        income = 300;
    }

    @Override
    public boolean ableToBuild(ArrayList<Construction> constructions) {
        System.out.println("Proba budowania: " + getClass());
        return true;
    }

    @Override
    public ImageIcon getBigImageIcon() {
        return new ImageIcon("res\\chatkaBig.png");
    }
}

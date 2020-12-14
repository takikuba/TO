package Constructions;

import javax.swing.*;
import java.util.ArrayList;

//Klasa obrazujaca kamieniolom
public class Quarry extends Construction{
    public Quarry() {
        super(500, "res\\kamieniolom.png");
        name = "Kamieniolom";
        income = 200;
    }

    @Override
    public boolean ableToBuild(ArrayList<Construction> constructions) {
        return true;
    }

    @Override
    public ImageIcon getBigImageIcon() {
        return new ImageIcon("res\\kamieniolomBig.png");
    }
}

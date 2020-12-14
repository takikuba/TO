package Constructions;

import javax.swing.*;
import java.util.ArrayList;

//Klasa szablonu dla konstrukcji w grze
public abstract class Construction extends ImageIcon{
    protected String name;
    private int price;
    private ImageIcon image;
    protected int income;
    protected String need;

    public Construction(int price, String imagePath){
        this.price = price;
        this.image = new ImageIcon(imagePath);
    }

    public ImageIcon getImageIcon(){
        return image;
    }

    public String getName(){
        return name;
    }

    public int getIncome(){
        return income;
    }

    public int getPrice(){
        return price;
    }

    public void printPrice(){
        System.out.println("Cena konstrukcji: " + price);
    }
    public abstract boolean ableToBuild(ArrayList<Construction> constructions);
    public abstract ImageIcon getBigImageIcon();

    public String getMessage(){
        return "<html>" + name + "<br>" + "Cyna: " + price + "<br>" + "Prefit: " + income + "<br>" + "Mus: " + need + "</html>";
    }

}

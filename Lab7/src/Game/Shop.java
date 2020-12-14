package Game;

import Buttons.IconButton;
import Constructions.*;

import javax.swing.*;
import java.awt.event.MouseListener;

//Klasa obrazująca sklep
public class Shop {

    private Game container;
    private JButton buttonShop = new IconButton("res\\shopIcon.jpg");
    private JPanel shop = new JPanel();
    private IconButton hut = new IconButton(new Hut());
    private IconButton mine = new IconButton(new Mine());
    private IconButton mint = new IconButton(new Mint());
    private IconButton quarry = new IconButton(new Quarry());
    private IconButton sawmill = new IconButton(new Sawmill());

    public Shop(Game container){
        this.container = container;
        initShop();
        buttonShop.setBounds(50, 100, 50, 50);
        container.add(buttonShop);
        buttonShop.addActionListener((e)->{
//            System.out.println("Shop open!");
            openShop();
        });

    }
    private void initShop(){
        shop.setLayout(new BoxLayout(shop, BoxLayout.Y_AXIS));
        shop.add(quarry);
        shop.add(hut);
        shop.add(sawmill);
        shop.add(mine);
        shop.add(mint);

        hut.addActionListener((e)->chooseConstruction(hut));
        hut.addMouseListener(new MouseEvent(hut));
        mine.addActionListener((e)->chooseConstruction(mine));
        mine.addMouseListener(new MouseEvent(mine));
        mint.addActionListener((e)->chooseConstruction(mint));
        mint.addMouseListener(new MouseEvent(mint));
        quarry.addActionListener((e)->chooseConstruction(quarry));
        quarry.addMouseListener(new MouseEvent(quarry));
        sawmill.addActionListener((e)->chooseConstruction(sawmill));
        sawmill.addMouseListener(new MouseEvent(sawmill));

        shop.setBounds(50, 100, 50, 200);
    }

    private void openShop() {
        container.printMessage("Sklep ôdewrzōny!");
        container.remove(buttonShop);
        container.add(shop);
        container.repaintScene();
    }

    public void closeShop(){
        container.remove(shop);
        container.add(buttonShop);
        container.repaintScene();
    }

    private void chooseConstruction(IconButton construction){
//        construction.printPrice();
        if(container.ableToBuild(construction)){
//            System.out.println("Buduje: " + construction.getClass());
            closeShop();
            container.setNewBuilding(construction);
        } else {
//            System.out.println("Nie mozesz postawic!");
        }

    }

    private class MouseEvent implements MouseListener {

        private Construction construction;

        public MouseEvent(IconButton icon){
            construction = icon.getConstruction();
        }

        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {}

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {}

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {}

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            container.printMessage(construction.getMessage());
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            container.printMessage("");
        }
    }


}

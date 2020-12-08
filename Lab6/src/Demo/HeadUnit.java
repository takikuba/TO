package Demo;

import Alarming.ResponseCode;
import Alarming.VFDUnit;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HeadUnit extends JFrame {

    private ArrayList<VFDUnit> units = new ArrayList<>();
    private ArrayList<VFDUnit> chooseUnit = new ArrayList<>();
    private ArrayList<JCheckBox> boxes = new ArrayList<>();
    private JButton buttonTest = new JButton("Test");
    private JButton buttonAlarm = new JButton("Alarm");

    public HeadUnit() {

        setSize(300, 400);
        setTitle("SWD_ST");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        buttonAlarm.setBounds(100, 250, 70, 30);
        buttonAlarm.setBackground(Color.red);
        buttonAlarm.addActionListener((e)->{
            AlarmStrategy alarm = new AlarmStrategy();
            alarm.notifyUnits();
        });

        buttonTest.setBounds(100, 300, 70, 30);
        buttonTest.setBackground(Color.green);
        buttonTest.addActionListener((e)->{
            TestStrategy test = new TestStrategy();
            test.notifyUnits();
        });

        getContentPane().add(buttonAlarm);
        getContentPane().add(buttonTest);

    }

    public void addUnit(VFDUnit unit){
//        System.out.println("SWD_ST add unit!");
        if(!units.contains(unit)){
            units.add(unit);
        }
    }
    public void rmUnit(VFDUnit unit){
        units.remove(unit);
    }
    public void run(){

        JPanel panel = new JPanel();
        for(VFDUnit u: units){
            JCheckBox j = new JCheckBox(u.getName());
            j.setSelected(true);
            boxes.add(j);
            panel.add(j);
        }
        getContentPane().add(panel);
        this.setVisible(true);
    }

    public void notifyObservers(String content){
        for(VFDUnit u: getChooseUnit()){
            ResponseCode code = u.notify(content);
            if(code.isOK()){
                System.out.println("Jednostka: " + u.getName() + " poprawnie.");
            } else {
                System.out.println("Jednostka: " + u.getName() + " error!");
            }
        }
    }

    private ArrayList<VFDUnit> getChooseUnit() {
        chooseUnit.clear();

        for(int i = 0; i < units.size(); i++){
            if(boxes.get(i).isSelected()){
                chooseUnit.add(units.get(i));
            }
        }
        return chooseUnit;
    }

    interface Strategy{
        void notifyUnits();
    }
    class AlarmStrategy implements Strategy{
        @Override
        public void notifyUnits() {
            notifyObservers("A");
        }
    }
    class TestStrategy implements Strategy{
        @Override
        public void notifyUnits() {
            notifyObservers("T");
        }
    }

}

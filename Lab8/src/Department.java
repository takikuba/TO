import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Department extends JFrame {

    private List<Holder> holders = new ArrayList<>();
    private JPanel panel = new JPanel();

    public static void main(String[] args) {
        new Department();
    }

    public Department(){

        Holder h0 = new Holder(123, "n"+123, "s"+123, new PlaceOfResidence(123, "u"+1, 123, "p"+123), "cel "+123);
        h0.addWeapon(new Weapon(WeaponFactory.getWeaponType("model"+123, new Ammunition("a"+123, 123, 123), 123*100), 123123123));
        h0.setLastControl(LocalDate.of(1900, 12, 1));
        holders.add(h0);


        for(int i=0; i < 10; i++){
            holders.add(new Holder(i, "n"+i, "s"+i, new PlaceOfResidence(i, "u"+1, i, "p"+i), "cel "+i));
            WeaponFactory.getWeaponType("model"+i, new Ammunition("a"+i, i, i), i*100);
        }


        setTitle("Department");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(350, 300);

        JToolBar menuBar = new JToolBar();


        JButton menuItemAdd = new JButton("Add Holder");
        menuItemAdd.addActionListener((e)->menuAction("add"));
        JButton menuItemRegister = new JButton("Register Weapon");
        menuItemRegister.addActionListener((e)->menuAction("reg"));
        JButton menuItemControl = new JButton("Control");
        menuItemControl.addActionListener((e)->menuAction("con"));

        menuBar.add(menuItemAdd);
        menuBar.add(menuItemRegister);
        menuBar.add(menuItemControl);

        panel.setBackground(new Color(121, 159, 180, 253));
        panel.add(new JLabel("Welcome in Department \n Choose option!"));

        getContentPane().add(menuBar, BorderLayout.NORTH);
        getContentPane().add(panel, BorderLayout.CENTER);

        setVisible(true);

    }

    private void setPanel(JPanel panel){
//        System.out.println(panel.toString());
        getContentPane().remove(this.panel);
        this.panel = panel;
        getContentPane().add(panel);
        revalidate();
        repaint();
    }

    private void menuAction(String action) {
//        System.out.println(action);
        switch(action){
            case("add"):
                setPanel(new AddHolder());
                break;
            case("reg"):
                setPanel(new Register());
                break;
            case("con"):
                setPanel(new Control());
                break;
            default:
                break;
        }
    }

    class AddHolder extends JPanel {
        private JPanel personData = new JPanel();
        private JPanel permits = new JPanel();
        private JButton buttonSave = new JButton("Save");
        private List<JRadioButton> permitsButton = new ArrayList<>();
        private List<JTextField> data = new ArrayList<>();

        public AddHolder() {
//            setBackground(Color.RED);

            personData.setBorder(new TitledBorder(null, "Person Data", TitledBorder.LEADING, TitledBorder.TOP, null, null));
            personData.setLayout(new GridLayout(7,1));

            JTextField name = new JTextField("name");
            data.add(name);
            JTextField surname = new JTextField("surname");
            data.add(surname);
            JTextField pesel = new JTextField("pesel");
            data.add(pesel);
            JTextField ulica = new JTextField("ulica");
            data.add(ulica);
            JTextField nrDomu = new JTextField("nrDomu");
            data.add(nrDomu);
            JTextField kodPocztowy = new JTextField("kodPocztowy");
            data.add(kodPocztowy);
            JTextField poczta = new JTextField("poczta");
            data.add(poczta);

            for(JTextField field: data){
                personData.add(field);
            }

            add(personData, BorderLayout.WEST);

            permits.setBorder(new TitledBorder(null, "Permits", TitledBorder.LEADING, TitledBorder.TOP, null, null));
            permits.setLayout(new GridLayout(6,1));

            JRadioButton pelnoletni = new JRadioButton("Pelnoletni");
            permitsButton.add(pelnoletni);
            JRadioButton pobyt = new JRadioButton("Staly pobyt:");
            permitsButton.add(pobyt);
            JRadioButton psycholog = new JRadioButton("Zaswiadczenie psych:");
            permitsButton.add(psycholog);
            JRadioButton zweryfikowany = new JRadioButton("Zweryfikowany:");
            permitsButton.add(zweryfikowany);

            JTextField cel = new JTextField("Cel pozwolenia");


            for(JRadioButton radio: permitsButton){
                permits.add(radio);
            }
            permits.add(cel);

            add(permits, BorderLayout.EAST);

            buttonSave.addActionListener((e)-> {
                for(JRadioButton radio: permitsButton){
                    if(!radio.isSelected()){
                        System.out.println(radio.getText());
                        JOptionPane.showMessageDialog(this, "Osoba nie moze posiadac broni!");
                        return;
                    }
                }
                addHolder(name, surname, pesel, ulica, nrDomu, kodPocztowy, poczta, cel);
                setPanel(new AddHolder());
            });
            add(buttonSave, BorderLayout.SOUTH);
        }

        private void addHolder(JTextField name, JTextField surname, JTextField pesel, JTextField ulica, JTextField nrDomu, JTextField kodPocztowy, JTextField poczta, JTextField cel) {
            PlaceOfResidence place = new PlaceOfResidence(Integer.parseInt(nrDomu.getText()), ulica.getText(), Integer.parseInt(kodPocztowy.getText()), poczta.getText());
            Holder holder = new Holder(Long.parseLong(pesel.getText()), name.getText(), surname.getText(), place, cel.getText());
            holders.add(holder);
            System.out.println(holder.toString());
        }


    }

    class Register extends JPanel {

        private JPanel chooser = new JPanel();
        private JPanel addWeapon = new JPanel();
        private JButton save = new JButton("Save");
        private JButton register = new JButton("Register");

        public Register() {
//            setBackground(Color.BLUE);

            JComboBox<Holder> holdersBox = new JComboBox<>();
            for(Holder holder: holders){
                holdersBox.addItem(holder);
            }

            JComboBox<WeaponType> weaponBox = new JComboBox<>();
            for(WeaponType type: WeaponFactory.getWeapons()){
                weaponBox.addItem(type);
            }

            chooser.setLayout(new GridLayout(4,1));
            chooser.setBorder(new TitledBorder(null, "Chooser:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
            JTextField id = new JTextField("Id broni");
            chooser.add(id);
            chooser.add(holdersBox);
            chooser.add(weaponBox);
            register.addActionListener((e)->{
                Holder h1 = (Holder) holdersBox.getSelectedItem();
//                System.out.println(h1.toString());
                if (h1 != null) {
                    h1.addWeapon(new Weapon((WeaponType) weaponBox.getSelectedItem(), Long.parseLong(id.getText())));
                    h1.setLastControl(LocalDate.now());
                }
            });
            chooser.add(register);
            add(chooser, BorderLayout.WEST);

            // jesli nie ma dostepnego takiego typu broni w factory mamy mozliwosc dodania jej
            addWeapon.setLayout(new GridLayout(6,1));
            addWeapon.setBorder(new TitledBorder(null, "Add Weapon:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
            JTextField model = new JTextField("Model");
            addWeapon.add(model);
            JTextField power = new JTextField("Power");
            addWeapon.add(power);
            JTextField quantity = new JTextField("Ilosc");
            addWeapon.add(quantity);
            JTextField ammunitionName = new JTextField("Ammunition name");
            addWeapon.add(ammunitionName);
            JTextField diameter = new JTextField("Diameter");
            addWeapon.add(diameter);

            save.addActionListener((e)->{
                WeaponFactory.getWeaponType(model.getText(), new Ammunition(ammunitionName.getText(), Integer.parseInt(diameter.getText()), Integer.parseInt(quantity.getText())), Integer.parseInt(power.getText()));
                for(WeaponType type2: WeaponFactory.getWeapons()){
                    weaponBox.addItem(type2);
                }
                setPanel(new Register());
            });
            addWeapon.add(save, BorderLayout.SOUTH);
            add(addWeapon, BorderLayout.EAST);
        }
    }

    class Control extends JPanel {

        private JPanel chooser = new JPanel();
        private JPanel info = new JPanel();
        private JLabel infoDate = new JLabel();
        private JRadioButton infoDead = new JRadioButton("Is dead:");
        private JRadioButton control = new JRadioButton("Was control:");
        private JPanel management = new JPanel();
        private JButton save = new JButton("Save");
        private JButton makeInspection = new JButton("Inspection");
        private JButton infoButton = new JButton("Info");

        private Holder h1 = null;

        public Control() {
//            setBackground(Color.orange);

            JComboBox<Holder> holdersBox = new JComboBox<>();
            for(Holder holder: holders){
                holdersBox.addItem(holder);
            }
            chooser.setBorder(new TitledBorder(null, "Chooser:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
            chooser.add(holdersBox);
            infoButton.addActionListener((e)->{
               h1 = (Holder) holdersBox.getSelectedItem();
               if( h1 != null ){
                   infoDate.setText(h1.getLastControl().toString());
                   if(LocalDate.now().toEpochDay() - h1.getLastControl().toEpochDay() > 365){
                       infoDate.setForeground(Color.RED);
                   } else {
                       infoDate.setForeground(Color.green);
                   }
               }
            });
            chooser.add(infoButton);
            chooser.add(info);
            add(chooser, BorderLayout.WEST);

            info.setBorder(new TitledBorder(null, "Info:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
            info.setLayout(new GridLayout(3,1));
            info.add(infoDate);
            info.add(infoDead);
            info.add(control);
            management.add(info);
            JPanel buttons = new JPanel();
            buttons.setLayout(new GridLayout(2,1));
            management.setBorder(new TitledBorder(null, "Management:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
//            management.setLayout(new GridLayout(2,1));
            save.addActionListener((e)->{
                if(control.isSelected()){
                    h1.setLastControl(LocalDate.now());
                }
                if(infoDead.isSelected()){
                    System.out.println(h1.toString());
                    holders.remove(h1);
                }
                setPanel(new Control());
            });
            buttons.add(save);
            makeInspection.addActionListener((e)->{
                Police.makeInspection(h1.getPlace());
            });
            buttons.add(makeInspection);
            management.add(buttons);
            add(management, BorderLayout.EAST);

        }
    }

}

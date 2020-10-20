import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Screen extends JFrame {

    Currency currencySell;
    Currency currencyBuy;
    double quantity;
    Cantor cantor;
    CurrencyList currencyList;

    public static void main(String []args) {
        new Screen();
    }

    public Screen()  {
        cantor = new Cantor();
        currencyList = new CurrencyList();
        setTitle("Wymiana walut!");
        Label label1 = new Label("Wybierz walute do wymiany: ");
        label1.setBounds(15, 20, 150, 30);
        Label label12 = new Label();
        label12.setBounds(250, 45, 150, 20);
        Choice choice1 = new CashList();
        choice1.setBounds(40, 45, 75, 75);
        ItemListener itemListener1 = (e)-> {
            try {
                currencySell = currencyList.getCurrency(choice1.getItem(choice1.getSelectedIndex()));
                label1.setText("Waluta do wymiany: " + currencySell.name);
                label12.setText("Aktualny kurs: " + currencySell.exchangeRate);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
        choice1.addItemListener(itemListener1);
        itemListener1.itemStateChanged(null);
        getContentPane().add(choice1);
        getContentPane().add(label12);
        getContentPane().add(label1);

        Label label2 = new Label("Wybierz walute na ktora chcesz wymienic: ");
        label2.setBounds(15, 75, 250, 30);
        Label label22 = new Label();
        label22.setBounds(250, 100, 150, 20);

        Choice choice2 = new CashList();
        choice2.setBounds(40, 100, 75, 75);
        ItemListener itemListener2 = (e)->{
            try {
                currencyBuy = currencyList.getCurrency(choice2.getItem(choice2.getSelectedIndex()));
                label2.setText("Waluta do wymiany: " + currencyBuy.name);
                label22.setText("Aktualny kurs: " + currencyBuy.exchangeRate);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
        choice2.addItemListener(itemListener2);
        itemListener2.itemStateChanged(null);
        getContentPane().add(choice2);
        getContentPane().add(label2);
        getContentPane().add(label22);

        Label label3 = new Label("Podaj kwote do wymiany: [.]");
        label3.setBounds(20, 160, 200, 20);

        TextField textField = new TextField();
        textField.setBounds(220, 160, 40, 20);

        Label label4 = new Label("Otrzymasz: ");
        label4.setBounds(20, 220, 200, 20);

        Button button3 = new Button("Wymien!");
        button3.setBounds(150, 200, 70, 20);
        button3.addActionListener((e)->{
            quantity = Double.parseDouble(textField.getText());
            try {
                double giveTheChange = cantor.exchange(currencySell, currencyBuy, quantity);
                label4.setText("Otrzymasz: " + String.format("%.2f", giveTheChange) + " " + currencyBuy.name);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        getContentPane().add(label3);
        getContentPane().add(label4);
        getContentPane().add(textField);
        getContentPane().add(button3);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(400, 300);
        setVisible(true);
    }
}

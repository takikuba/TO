import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Screen  {

    public static void main(String []args) {

        JFrame jFrame = new JFrame("Wymiana walut");

        Label label1 = new Label("Wybierz walute do wymiany: ");
        label1.setBounds(15, 20, 150, 30);
        Label label12 = new Label();
        label12.setBounds(250, 45, 150, 20);

        Choice choice1;
        choice1 = new CashList().getCashList();
        choice1.setBounds(40, 45, 75, 75);

        Button button1 = new Button("Set");
        button1.setBounds(120, 45, 50, 20);
        final String[] currencyNameSell = new String[1];
        button1.addActionListener((e)->{
            currencyNameSell[0] = choice1.getItem(choice1.getSelectedIndex());
            label1.setText("Waluta do wymiany: " + currencyNameSell[0]);
            try {
                label12.setText("Aktualny kurs: " + Cantor.getRate(currencyNameSell[0]));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        jFrame.getContentPane().add(button1);
        jFrame.getContentPane().add(choice1);
        jFrame.getContentPane().add(label12);
        jFrame.getContentPane().add(label1);

        Label label2 = new Label("Wybierz walute na ktora chcesz wymienic: ");
        label2.setBounds(15, 75, 250, 30);
        Label label22 = new Label();
        label22.setBounds(250, 100, 150, 20);

        Choice choice2 = new CashList().getCashList();
        choice2.setBounds(40, 100, 75, 75);

        Button button2 = new Button("Set");
        button2.setBounds(120, 100, 50, 20);
        final String[] currencyNameBuy = new String[1];
        button2.addActionListener((e)->{
            currencyNameBuy[0] = choice2.getItem(choice2.getSelectedIndex());
            label2.setText("Wymieniam na: " + currencyNameBuy[0]);
            try {
                label22.setText("Aktualny kurs: " + Cantor.getRate(currencyNameBuy[0]));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        jFrame.getContentPane().add(button2);
        jFrame.getContentPane().add(choice2);
        jFrame.getContentPane().add(label2);
        jFrame.getContentPane().add(label22);

        Label label3 = new Label("Podaj kwote do wymiany: [.]");
        label3.setBounds(20, 160, 200, 20);

        TextField textField = new TextField();
        textField.setBounds(220, 160, 40, 20);

        Label label4 = new Label("Otrzymasz: ");
        label4.setBounds(20, 220, 200, 20);

        Button button3 = new Button("Wymien!");
        button3.setBounds(150, 200, 70, 20);
        final Double[] quantity = new Double[1];
        button3.addActionListener((e)->{
            quantity[0] = Double.valueOf(textField.getText());
            try {
                label4.setText("Otrzymasz: " + String.format("%.2f", Cantor.getCash(currencyNameSell[0], currencyNameBuy[0], quantity[0])) + " " + currencyNameBuy[0]);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        jFrame.getContentPane().add(label3);
        jFrame.getContentPane().add(label4);
        jFrame.getContentPane().add(textField);
        jFrame.getContentPane().add(button3);

        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        jFrame.setSize(400, 300);
        jFrame.setVisible(true);
    }
}

class URLReader {
    public static BufferedReader getData() throws Exception{
        URL webPage = new URL("https://www.nbp.pl/kursy/xml/lasta.xml");
        return new BufferedReader( new InputStreamReader(webPage.openStream()));
    }
}

class CashList extends Choice {
    Choice getCashList(){
        Choice choice = new Choice();
        String[] cash = {"THB", "USD", "AUD", "HKD", "CAD", "NZD", "SGD", "EUR", "HUF", "CHF", "GBP", "UAH",
                         "JPY", "CZK", "DKK", "ISK", "NOK", "SEK", "HRK", "RON", "BGN", "TRY", "ILS", "CLP",
                         "PHP", "MXN", "ZAR", "BRL", "MYR", "RUB", "IDR", "INR", "KRW", "CNY", "XRD"};
        for(String s: cash){
            choice.add(s);
        }
        return choice;
    }
}
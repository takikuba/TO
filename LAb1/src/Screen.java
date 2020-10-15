import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Screen  {

    static double getCash(String val1, String val2, Double val3) throws Exception {
        double[] info1 = getLine(val1);
        double[] info2 = getLine(val2);

        return (info1[0] / info1[1]) / (info2[0] / info2[1]) * val3;
    }

    static double getRate(String val1) throws Exception{
        double[] info1 = getLine(val1);
        return info1[0];
    }

    static double[] getLine(String var) throws Exception{
        new URLReader();
        BufferedReader data = URLReader.getData();
        String line, line2 = "one", line3;
        boolean is = false;
        double przelicznik = 0, kurs = 0;
        while ((line = data.readLine()) != null){
            if(is){
                line3 = line.replaceAll(",", ".");
                kurs = Double.parseDouble(line3.replaceAll("[^0-9.]", ""));
                is = false;
            }
            if( line.contains(var)){
                przelicznik = Double.parseDouble(line2.replaceAll("[^\\d.]",""));
                is = true;
            }
            line2 = line;

        }
        data.close();
        double []retval = {0, 0};
        retval[0] = kurs;
        retval[1] = przelicznik;
        return retval;
    }

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
        final String[] val1 = new String[1];
        button1.addActionListener((e)->{
            val1[0] = choice1.getItem(choice1.getSelectedIndex());
            label1.setText("Waluta do wymiany: " + val1[0]);
            try {
                label12.setText("Aktualny kurs: " + getRate(val1[0]));
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
        final String[] val2 = new String[1];
        button2.addActionListener((e)->{
            val2[0] = choice2.getItem(choice2.getSelectedIndex());
            label2.setText("Wymieniam na: " + val2[0]);
            try {
                label22.setText("Aktualny kurs: " + getRate(val2[0]));
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
        final Double[] val3 = new Double[1];
        button3.addActionListener((e)->{
            val3[0] = Double.valueOf(textField.getText());
            try {
                label4.setText("Otrzymasz: " + String.format("%.2f", getCash(val1[0], val2[0], val3[0])) + " " + val2[0]);
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
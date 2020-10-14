import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Screen  {

    static double getCash(String val1, String val2, Double val3) throws Exception {
        double[] info1 = getLine(val1);
        double[] info2 = getLine(val2);
//            System.out.println(info1[0] + " " + info1[1]);
//            System.out.println(info2[0] + " " + info2[1]);

        double reval = (info1[0] / info1[1]) / (info2[0] / info2[1]) * val3;
//            System.out.println(reval);
        return reval;

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
        double []reval = {0, 0};
        reval[0] = kurs;
        reval[1] = przelicznik;
        return reval;
    }

    public static void main(String []args) {

        JFrame jFrame = new JFrame("Wymiana walut");

        Label label1 = new Label("Wybierz walute do wymiany: ");
        label1.setBounds(15, 20, 150, 30);

        Choice choice1;
        choice1 = new CashList().getCashList();
        choice1.setBounds(40, 45, 75, 75);

        Button button1 = new Button("Set");
        button1.setBounds(120, 45, 50, 20);
        final String[] val1 = new String[1];
        button1.addActionListener((e)->{
            val1[0] = choice1.getItem(choice1.getSelectedIndex());
            label1.setText("Waluta do wymiany: " + val1[0]);
        });

        jFrame.getContentPane().add(button1);
        jFrame.getContentPane().add(choice1);
        jFrame.getContentPane().add(label1);

        Label label2 = new Label("Wybierz walute na ktora chcesz wymienic: ");
        label2.setBounds(15, 75, 250, 30);

        Choice choice2 = new CashList().getCashList();
        choice2.setBounds(40, 100, 75, 75);

        Button button2 = new Button("Set");
        button2.setBounds(120, 100, 50, 20);
        final String[] val2 = new String[1];
        button2.addActionListener((e)->{
            val2[0] = choice2.getItem(choice2.getSelectedIndex());
            label2.setText("Wymieniam na: " + val2[0]);
        });

        jFrame.getContentPane().add(button2);
        jFrame.getContentPane().add(choice2);
        jFrame.getContentPane().add(label2);

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
                label4.setText(String.valueOf("Otrzymasz: " + String.format("%.2f", getCash(val1[0], val2[0], val3[0]))) + val2[0]);
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
        Choice choice1 = new Choice();
        choice1.add("THB");
        choice1.add("USD");
        choice1.add("AUD");
        choice1.add("HKD");
        choice1.add("CAD");
        choice1.add("NZD");
        choice1.add("SGD");
        choice1.add("EUR");
        choice1.add("HUF");
        choice1.add("CHF");
        choice1.add("GBP");
        choice1.add("UAH");
        choice1.add("JPY");
        choice1.add("CZK");
        choice1.add("DKK");
        choice1.add("ISK");
        choice1.add("NOK");
        choice1.add("SEK");
        choice1.add("HRK");
        choice1.add("RON");
        choice1.add("BGN");
        choice1.add("TRY");
        choice1.add("ILS");
        choice1.add("CLP");
        choice1.add("PHP");
        choice1.add("MXN");
        choice1.add("ZAR");
        choice1.add("BRL");
        choice1.add("MYR");
        choice1.add("RUB");
        choice1.add("IDR");
        choice1.add("INR");
        choice1.add("KRW");
        choice1.add("CNY");
        choice1.add("XRD");
        return choice1;
    }

}
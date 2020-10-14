import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Scanner;


public class MakeChoice {
    public static void main(String[] args) throws IOException {

        String wypisWalut;
        wypisWalut = "1 - THB, " +
                "2 - USD, " +
                "3 - AUD, " +
                "4 - HKD, " +
                "5 - CAD, " +
                "6 - NZD, " +
                "7 - SGD, " +
                "8 - EUR, " +
                "9 - HUF, " +
                "10 - CHF, " +
                "11 - GBP, " +
                "12 - UAH, " +
                "13 - JPY, " +
                "14 - CZK, " +
                "15 - DKK, " +
                "16 - ISK, " +
                "17 - NOK, " +
                "18 - SEK, " +
                "19 - HRK, " +
                "20 - RON, " +
                "21 - BGN, " +
                "22 - TRY, " +
                "23 - ILS, " +
                "24 - CLP, " +
                "25 - PHP, " +
                "26 - MXN, " +
                "27 - ZAR, " +
                "28 - BRL, " +
                "29 - MYR, " +
                "30 - RUB, " +
                "31 - IDR, " +
                "32 - INR, " +
                "33 - KRW, " +
                "34 - CNY, " +
                "35 - XDR";
        System.out.print("Wybierz walute do wymiany: " + wypisWalut);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line1 = reader.readLine();
        System.out.print("Wybierz walute na jaka chcesz zamienic: " + wypisWalut);
        String line2 = reader.readLine();

        String kurs = String.valueOf(new URLReader());

    }
}

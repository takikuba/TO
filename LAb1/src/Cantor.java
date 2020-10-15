import java.io.BufferedReader;

public class Cantor {

    static double getCash(String currencySell, String currencyBuy, Double quantity) throws Exception {
        double[] cash1 = getLine(currencySell);
        double[] cash2 = getLine(currencyBuy);

        return (cash1[0] / cash1[1]) / (cash2[0] / cash2[1]) * quantity;
    }

    static double getRate(String currencyName) throws Exception{
        double[] rate = getLine(currencyName);
        return rate[0];
    }

    static double[] getLine(String currencyName) throws Exception{
        new URLReader();
        BufferedReader data = URLReader.getData();
        String line, strConverter = "one", strExchangeRate;
        boolean is = false;
        double conventer = 0, exchangeRate = 0;
        while ((line = data.readLine()) != null){
            if(is){
                strExchangeRate = line.replaceAll(",", ".");
                exchangeRate = Double.parseDouble(strExchangeRate.replaceAll("[^0-9.]", ""));
                is = false;
            }
            if( line.contains(currencyName)){
                conventer = Double.parseDouble(strConverter.replaceAll("[^0-9.]",""));
                is = true;
            }
            strConverter = line;

        }
        data.close();
        double []currency = {0, 0};
        currency[0] = exchangeRate;
        currency[1] = conventer;
        return currency;
    }

}

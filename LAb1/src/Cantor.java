import java.io.BufferedReader;

public class Cantor {

    static double giveTheChange;

    public Cantor(Currency currencySell, Currency currencyBuy, double quantity){
        giveTheChange = (currencySell.exchangeRate / currencySell.converter) / (currencyBuy.exchangeRate / currencyBuy.converter) * quantity;
    }

}

class Currency{
    String name;
    double exchangeRate;
    double converter;

    Currency(String name) throws Exception {
        this.name = name;
        this.setLine(this.name);
    }
    double getRate() {
        return this.exchangeRate;
    }

    double getConverter() {
        return this.converter;
    }

    void setLine(String currencyName) throws Exception{
        URLReader urlReader = new URLReader();
        BufferedReader data = urlReader.data;
        String line, strConverter = "one", strExchangeRate;
        boolean is = false;
        double converter = 0, exchangeRate = 0;
        while ((line = data.readLine()) != null){
            if(is){
                strExchangeRate = line.replaceAll(",", ".");
                exchangeRate = Double.parseDouble(strExchangeRate.replaceAll("[^0-9.]", ""));
                is = false;
            }
            if( line.contains(currencyName)){
                converter = Double.parseDouble(strConverter.replaceAll("[^0-9.]",""));
                is = true;
            }
            strConverter = line;

        }
        data.close();
        this.exchangeRate = exchangeRate;
        this.converter = converter;
    }

}

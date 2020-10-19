public class Cantor {

    static double giveTheChange;

    public Cantor(Currency currencySell, Currency currencyBuy, double quantity){
        giveTheChange = (currencySell.exchangeRate / currencySell.converter) / (currencyBuy.exchangeRate / currencyBuy.converter) * quantity;
    }
}
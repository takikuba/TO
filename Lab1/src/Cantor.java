public class Cantor {

    public double exchange(Currency currencySell, Currency currencyBuy, double quantity){
        return (currencySell.exchangeRate / currencySell.converter) / (currencyBuy.exchangeRate / currencyBuy.converter) * quantity;
    }
}
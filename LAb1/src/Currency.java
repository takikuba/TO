public class Currency{
    String name;
    double exchangeRate;
    int converter;

    Currency(String name) {
        this.name = name;
    }

    void setCurrencyElements() throws Exception {
        CurrencyList currencyList = new CurrencyList();
        for(Currency myCurrency: currencyList.currencyList){
            if(this.name.equals(myCurrency.name)){
                this.converter = myCurrency.converter;
                this.exchangeRate = myCurrency.exchangeRate;
            }
        }
    }
}

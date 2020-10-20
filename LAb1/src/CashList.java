import java.awt.*;

public class CashList extends Choice {

    CashList() {
        CurrencyList currencyList = new CurrencyList();
        for(Currency myCurrency: currencyList.currencyList){
            this.add(myCurrency.name);
        }
    }

}
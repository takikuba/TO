import java.awt.*;

public class CashList extends Choice {

    static Choice choice;

    CashList() throws Exception {
        choice = getCashList();
    }

    Choice getCashList() throws Exception {
        choice = new Choice();
        CurrencyList currencyList = new CurrencyList();
        for(Currency myCurrency: currencyList.currencyList){
            choice.add(myCurrency.name);
        }
        return choice;
    }

}
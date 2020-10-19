import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.ArrayList;
import java.util.List;

public class Cantor {

    static double giveTheChange;

    public Cantor(Currency currencySell, Currency currencyBuy, double quantity){
        giveTheChange = (currencySell.exchangeRate / currencySell.converter) / (currencyBuy.exchangeRate / currencyBuy.converter) * quantity;
    }
}

class Currency{
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

class CurrencyList{

    List<Currency> currencyList = new ArrayList<>();

    CurrencyList() throws Exception {
        NodeList nodeList = new URLReader().getXMLData();
        for( int i = 0; i < nodeList.getLength(); i++ ){
            Node node = nodeList.item(i);
            if ( node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) node;
                Currency currency = new Currency(element.getElementsByTagName("kod_waluty").item(0).getTextContent());
                currency.converter = Integer.parseInt(element.getElementsByTagName("przelicznik").item(0).getTextContent());
                currency.exchangeRate = Double.parseDouble(element.getElementsByTagName("kurs_sredni").item(0).getTextContent().replaceAll(",","."));
                currencyList.add(currency);
            }
        }
    }
}
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class CurrencyList {

    List<Currency> currencyList = new ArrayList<>();

    CurrencyList() {

        currencyList.add(new Currency("PLN", 1, 1));
        NodeList nodeList = new XMLReader().getXMLData();
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

    Currency getCurrency(String currencyName){
        for(Currency myCurrency: currencyList){
            if(myCurrency.name.equals(currencyName)){
                return myCurrency;
            }
        }
        return null;
    }
}
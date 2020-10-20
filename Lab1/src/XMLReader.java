import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;

class XMLReader {

    public NodeList getXMLData()  {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new URL("https://www.nbp.pl/kursy/xml/lasta.xml").openStream());
            doc.getDocumentElement().normalize();
            return doc.getElementsByTagName("pozycja");
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

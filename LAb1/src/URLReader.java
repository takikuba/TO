import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;

class URLReader {
    static NodeList nodeList;

    URLReader() throws Exception {
        URLReader.nodeList = getXMLData();
    }

    public NodeList getXMLData() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new URL("https://www.nbp.pl/kursy/xml/lasta.xml").openStream());
        doc.getDocumentElement().normalize();

        return doc.getElementsByTagName("pozycja");
    }
}

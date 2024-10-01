import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class XMLParser implements BankStatementParser {
    @Override
    public List<Transaction> parse(String filePath) {
        List<Transaction> transactions = new ArrayList<>();
        try {
            File inputFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("transactions");
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    transactions.add(new Transaction(
                            eElement.getElementsByTagName("date").item(0).getTextContent(),
                            Double.parseDouble(eElement.getElementsByTagName("amount").item(0).getTextContent()),
                            eElement.getElementsByTagName("category").item(0).getTextContent()
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transactions;
    }
}

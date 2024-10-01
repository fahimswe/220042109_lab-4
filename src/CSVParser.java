import java.io.*;
import java.util.*;
public class CSVParser implements BankStatementParser {
    public List<Transaction>parse(String filePath){
        List<Transaction>transactions=new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                transactions.add(new Transaction(parts[0], Double.parseDouble(parts[1]), parts[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}
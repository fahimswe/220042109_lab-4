import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import org.json.*;
public class JSONParser implements BankStatementParser {
    @Override
    public List<Transaction> parse(String filePath) {
        List<Transaction> transactions = new ArrayList<>();
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray jsonArray = new JSONArray(content);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                transactions.add(new Transaction(
                        jsonObject.getString("date"),
                        jsonObject.getDouble("amount"),
                        jsonObject.getString("category")
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}
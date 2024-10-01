import java.util.List;
public class BankStatementAnalyzer {
    public void calculate(String filePath, String fileType){
        BankStatementParser parser = BankStatementParserFactory.createParser(fileType);
        List<Transaction> transactions= parser.parse(filePath);
double totalProfitLoss= calculateProfitLoss(transactions);
System.out.println("Total Profit/Loss: "+totalProfitLoss);
    }
    private double calculateProfitLoss(List<Transaction> transactions) {
        double total = 0;
        for (Transaction t : transactions) {
            total += t.getAmount();
        }
        return total;
    }
}

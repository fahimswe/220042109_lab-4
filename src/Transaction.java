public class Transaction {
    private String date;
    private double amount;
    private String category;

    public Transaction(String date, double amount, String category) {
        this.date = date;
        this.amount = amount;
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

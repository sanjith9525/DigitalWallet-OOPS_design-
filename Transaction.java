

public class Transaction {
    public String fromUser;
    public String toUser;
    public double amount;
    Transaction(String fromUser, String toUser, double amount) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.amount = amount;
    }
}
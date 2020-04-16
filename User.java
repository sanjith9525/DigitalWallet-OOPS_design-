

public class User{
    public String name;
    public double balance;
    public int numTransactions;
    User(String name, double balance) {
        this.name=name;
        this.balance=balance;
        this.numTransactions=0;
    }
}
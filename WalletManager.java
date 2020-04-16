
import java.util.*;


public class WalletManager {
    //private WalletManager WalletManagerInstance;
    private List<Transaction> transactionList;
    private HashMap<String, User> Users;
    //private List<Users> Users;

    WalletManager() {
        transactionList = new ArrayList<Transaction>();
        Users = new HashMap<String, User>();
    }

    public void transact(String fromUser, String toUser, double amount) {
        if(this.Users.contains(fromUser)) {
            User user1 = Users.get(fromUser);
            if(amount>user1.balance) {
                throw new Exception("Not enough balance");
            }
        } else {
            throw new Exception("User does not exist");
        }
        if(this.Users.contains(toUser)) {
            User user2 = Users.get(toUser);
        }
        if(amount < 0.0001) {
            throw new Exception("Amount is too less");
        }
        user1.balance -= amount;
        user2.balance += amount;
        user1.numTransactions++;
        Transaction currentTransaction = new Transaction(fromUser, toUser, amount);
        transactionList.add(currentTransaction);

        if(user1.balance == user2.balance) {
            user1.balance += 10;
            user2.balance += 10;
            Transaction offerTransaction = new Transaction("Offer1", toUser, amount);
            transactionList.add(offerTransaction);
        }


    }
    
    
    
    public void createUser(String name, double amount) {
        if(Users.contains(name)) {
            throw new Exception("Name already exists");
        } else {
            User newUser = new User(name, amount);
            Users.add(name, User);
        }


    }

    public void offerTwo() {
        User first = null;
        User second = null;
        User third = null;
        PriorityQueue<User> offerQueue = new PriorityQueue<>( new Comparator<Double>() {
            @Override
            public int compare(User User1, User User2) {
                if(User1.numTransactions==User2.numTransactions) {
                    return User2.balance - User1.balance;
                } else {
                    return User2.numTransactions - User1.numTransactions;
                }
            }
        });      
        for(Map.Entry<String, User> entry : Users.entrySet()) {
            offerQueue.add(entry.getValue());
        }
        if(!offerQueue.isEmpty()) {
            User first = offerQueue.remove();
            first.balance += 10; 
            Transaction offerTwoTransaction = new Transaction("offerTwo", first.name, 10);
            transactionList.add(offerTwoTransaction);
        }
        if(!offerQueue.isEmpty()) {
            User second = offerQueue.remove();
            second.balance += 5; 
            Transaction offerTwoTransaction = new Transaction("offerTwo", second.name, 5);
            transactionList.add(offerTwoTransaction);
        }
        if(!offerQueue.isEmpty()) {
            User thrid = offerQueue.remove();
            thrid.balance += 2; 
            Transaction offerTwoTransaction = new Transaction("offerTwo", third.name, 2);
            transactionList.add(offerTwoTransaction);
        }
    }

    public void printOverview() {
        for(Map.Entry<String, User> entry : Users.entrySet()) {
            System.out.println(entry.getValue().name + " " + entry.getValue().balance);
        }
    }

    public void printStatement(String userName) {
        for(Transaction transactionIterator : transactionList) {
            if(transactionList.fromUser == userName) {
                System.out.println(transactionList.toUser + " debit " + transactionList.amount);
            }
            else if(transactionList.toUser == userName) {
                System.out.println(transactionList.fromUser + " credit " + transactionList.amount);
            }
        }
    }

}
package joshuahecker.bankapp;
import java.util.Scanner;

public class Account {
    int balance;
    int transactionAmount;
    String transactionType;
    String customerName;
    String customerId;
    
    Account (String cName, String cID)
    {
        customerName = cName;
        customerId = cID;
    }
}

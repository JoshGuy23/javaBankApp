package joshuahecker.bankapp;
import java.util.Scanner;

public class Account {
    double balance = 0;
    double transactionAmount;
    String transactionType = "n";
    String customerName;
    String customerId;
    
    Account (String cName, String cID)
    {
        customerName = cName;
        customerId = cID;
    }
    
    void deposit(int amt)
    {
        if (amt > 0)
        {
            balance += amt;
            transactionAmount = amt;
            transactionType = "d";
        }
    }
    
    void withdraw(int amt)
    {
        if (amt > 0)
        {
            if (balance - amt >= 0)
            {
                balance -= amt;
                transactionAmount = amt;
                transactionType = "w";
            }
            else
            {
                System.out.println("You cannot withdraw more than you have.");
            }
        }
    }
    
    void seePreviousTransaction()
    {
        switch(transactionType)
        {
            case "n":
                System.out.println("You have not yet performed any transactions this session.");
            case "d":
                System.out.println("You deposited: $" + transactionAmount);
            case "w":
                System.out.println("You withdrew: $" + transactionAmount);
        }
    }
    
    void viewBalance()
    {
        System.out.println("Your balance is: $" + balance);
    }
    
    double calculateInterest(int yrs)
    {
        double rate = 0.0185;
        
        System.out.println("The current interest rate is: " + rate * 100 + "%");
        
        return (balance * rate * yrs) + balance;
    }
}

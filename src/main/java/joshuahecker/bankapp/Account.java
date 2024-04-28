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
    
    void deposit(double amt)
    {
        if (amt > 0)
        {
            balance += amt;
            transactionAmount = amt;
            transactionType = "d";
            
            System.out.println("You have deposited: $" + amt);
            System.out.println("You now have: $" + balance);
        }
    }
    
    void withdraw(double amt)
    {
        if (amt > 0)
        {
            if (balance - amt >= 0)
            {
                balance -= amt;
                transactionAmount = amt;
                transactionType = "w";
                
                System.out.println("You have withdrawn: $" + amt);
                System.out.println("You now have: $" + balance);
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
                break;
            case "d":
                System.out.println("You deposited: $" + transactionAmount);
                break;
            case "w":
                System.out.println("You withdrew: $" + transactionAmount);
                break;
            default:
                System.out.println("Error");
        }
    }
    
    void viewBalance()
    {
        System.out.println("Your balance is: $" + balance);
    }
    
    void calculateInterest(int yrs)
    {
        double rate = 0.0185;
        
        System.out.println("The current interest rate is: " + rate * 100 + "%");
        
        double interest = (balance * rate * yrs) + balance;
        
        System.out.println("In " + yrs + " years, your balance will be: $" + interest);
        System.out.println("You will have earned: $" + (interest - balance));
    }
    
    void showMenu()
    {
        Scanner input = new Scanner(System.in);
        boolean exit = false;
        
        System.out.println("Welcome, " + customerName + ". (" + customerId + ")");
        System.out.println("Please select an option:");
        System.out.println("A. View Your Balance");
        System.out.println("B. Make a Deposit");
        System.out.println("C. Make a Withdrawal");
        System.out.println("D. View Your Last Transaction");
        System.out.println("E. Calculate Earnings from Interest");
        System.out.println("F. Exit");
        
        while (!exit)
        {
            System.out.println("Enter your choice:");
            String choice = input.nextLine().toUpperCase();
            
            switch(choice)
            {
                case "A":
                    viewBalance();
                    break;
                case "B":
                    System.out.println("How much will you deposit?");
                    deposit(input.nextDouble());
                    break;
                case "C":    
                    System.out.println("How much will you withdraw?");
                    withdraw(input.nextDouble());
                    break;
                case "D":
                    seePreviousTransaction();
                    break;
                case "E":
                    System.out.println("How many years of accrued interest are you interested in?");
                    calculateInterest(input.nextInt());
                    break;
                case "F":
                    exit = true;
                    break;
                default:
                    System.out.println("Please enter a valid menu option.");
            }
            
            System.out.println("Thank you for using this system.");
        }
    }
}

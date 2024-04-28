package joshuahecker.bankapp;
import java.util.Scanner;

public class BankApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please enter your first name.");
        
        String name = input.nextLine();
        Account user = new Account(name, "A01");
        
        user.showMenu();
    }
}

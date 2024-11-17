package application;

import java.util.Locale;
import java.util.Scanner;
import models.entities.Account;
import models.exceptions.BusinessException;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter account data");
        System.out.print("Number: ");
        int numAccount = sc.nextInt();
        sc.nextLine();
        System.out.print("Holder: ");
        String holder = sc.nextLine();
        System.out.print("Initial balance: R$ ");
        double balance = sc.nextDouble();
        System.out.print("Withdraw limit: R$ ");
        double withdrawLimit = sc.nextDouble();

        Account account = new Account(numAccount, holder, balance, withdrawLimit);

        System.out.println();
        System.out.print("Enter amount for withdraw: R$ ");
        double amount = sc.nextDouble();

        try {
            account.withdraw(amount);
            System.out.println("New balance: R$ " + String.format("%.2f", account.getBalance()));
        } 
        catch (BusinessException e) {
            System.out.println("Withdraw error: " + e.getMessage());

        }
    }
}

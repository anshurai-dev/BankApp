package app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Welcome to Console Bank");
            System.out.println("""
                    1) Open Account
                    2) Deposit
                    3) Withdraw
                    4) Transfer
                    S) Account Statement
                    6) List Accounts
                    7) Search Account by Customer Name
                    0) Exit
                    """);
            System.out.print("Enter your choice: ");
            String choice = input.nextLine().trim();
            System.out.println("Your choice is: " + choice);
        }
    }
}
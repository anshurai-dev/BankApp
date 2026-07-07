package app;

import service.BankService;
import service.impl.BankServiceImpl;

import java.util.Scanner;

import domain.Account;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankService bankService = new BankServiceImpl();
        boolean running = true;
        while (running) {
            System.out.println("Welcome to Console Bank");
            System.out.println("""
                    1) Open Account
                    2) Deposit
                    3) Withdraw
                    4) Transfer
                    5) Account Statement
                    6) List Accounts
                    7) Search Account by Customer Name
                    0) Exit
                    """);
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();
            System.out.println("Your choice is: " + choice);

            switch (choice) {
                case "1" -> operAccount(scanner, bankService);
                case "2" -> deposit(scanner, bankService);
                case "3" -> withdraw(scanner);
                case "4" -> transfer(scanner);
                case "5" -> statement(scanner);
                case "6" -> listAccount(scanner, bankService);
                case "7" -> searchAccount(scanner);
                case "0" -> running = false;
            }
        }
    }
    private static void operAccount(Scanner scanner , BankService bankService) {
        System.out.println("Customer Name: ");
        String name = scanner.nextLine().trim();
        System.out.println("Customer email: ");
        String email = scanner.nextLine().trim();
        System.out.println("Account Type (SAVINGS/CURRENT) ");
        String type = scanner.nextLine().trim();
        System.out.println("Initial deposit (optional, blank for 0): ");
        String amountStr = scanner.nextLine().trim();
        Double initial = Double.valueOf(amountStr);
        String accountNumber = bankService.openAccount(name,email,type);
          if(initial<0)
              bankService.deposit();
           System.out.println("Account opened successfully" + accountNumber);
    }
    private static void deposit(Scanner scanner, BankService bankService) {
        System.out.println("Account Number: ");
        String accountNumber = scanner.nextLine().trim();
        System.out.println("Amount: ");
        Double amount = Double.valueOf(scanner.nextLine().trim());
        bankService.deposit(accountNumber, amount, "Deposit");
        System.out.println("Deposited");

    }
    private static void withdraw(Scanner scanner) {}
    private static void transfer(Scanner scanner) {}
    private static void statement(Scanner scanner) {}
    private static void listAccount(Scanner scanner, BankService bankService) {
        bankService.listAccounts().forEach( a ->{
            System.out.println(a.getAccountNumber() + " | " + a.getAccountType() + " | " + a.getBalance());
        });
    }
    private static void searchAccount(Scanner scanner) {}
}
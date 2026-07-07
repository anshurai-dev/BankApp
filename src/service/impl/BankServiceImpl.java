package service.impl;

import domain.Account;
import repository.AccountRepository;
import service.BankService;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BankServiceImpl implements BankService {

    private final AccountRepository accountRepository =  new AccountRepository();

    @Override
    public String openAccount(String name, String email, String accountType) {

        String customerId = UUID.randomUUID().toString();

        // CHANGE  LATER --> 10 + 1  = AC000011 --> AC<06>
      //  String accountNUmber = UUID.randomUUID().toString();
        String accountNumber = getAccountNumber();
        Account account = new Account(accountNumber,accountType,(double) 0, customerId);

        //SAVE
        accountRepository.save(account);
        return accountNumber;
    }

    @Override
    public List<Account> listAccounts() {
        return accountRepository.findAll().stream().sorted(Comparator.comparing(Account::getAccountNumber)).collect(Collectors.toList());
    }

    @Override
    public void deposit(String accountNumber, Double amount, String deposit) {
        Account account = accountRepository.findBvNumber(accountNumber).orElseThrow(() -> new RunTimeExeption("Account not found: " + accountNumber));
    }


    private String getAccountNumber() {
        int size = accountRepository.findAll().size()+1;
        return String.format("AC%06d",size);
    }
}

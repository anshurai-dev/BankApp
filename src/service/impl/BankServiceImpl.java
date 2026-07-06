package service.impl;

import domain.Account;
import service.BankService;

import java.util.Scanner;
import java.util.UUID;

public class BankServiceImpl implements BankService {

    @Override
    public String openAccount(String name, String email, String accountType) {

        String customerId = UUID.randomUUID().toString();

        // CHANGE  LATER --> 10 + 1  = AC11
        String accountNUmber = UUID.randomUUID().toString();
        Account a = new Account(accountNUmber,accountType,(double) 0, customerId);

        //SAVE

        return "";
    }
}

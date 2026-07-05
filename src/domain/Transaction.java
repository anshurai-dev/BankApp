package domain;

import java.time.LocalDateTime;

public class Transaction {
    private String id;
    private Type type;
    private String accountNumber;
    private Double amount;
    private LocalDateTime timestamp;
    private String note;

    public Transaction(String accountNumber,String id, Double amount, LocalDateTime timestamp, String note) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.id = id;
        this.timestamp = timestamp;
        this.note = note;
    }


}

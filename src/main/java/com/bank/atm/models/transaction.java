package com.bank.atm.models;

import java.time.LocalDateTime;

public class transaction {
    private Long id;
    private String fromIban;
    private String toIban;
    private double amount;
    private LocalDateTime transactionDate;


    public transaction() {}

    public transaction(String fromIban, String toIban, double amount) {
        this.fromIban = fromIban;
        this.toIban = toIban;
        this.amount = amount;
        this.transactionDate = LocalDateTime.now();
    }



    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFromIban() { return fromIban; }
    public void setFromIban(String fromIban) { this.fromIban = fromIban; }
    public String getToIban() { return toIban; }
    public void setToIban(String toIban) { this.toIban = toIban; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public LocalDateTime getTransactionDate() { return transactionDate; }
    public void setTransactionDate(LocalDateTime transactionDate) { this.transactionDate = transactionDate; }
}
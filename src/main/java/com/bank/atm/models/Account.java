package com.bank.atm.models;

public class Account {

    private Long id;
    private String iban;
    private Long userId;
    private double balance;

    public Account() {}

    public Account(Long id, String iban, Long userId, double balance) {
        this.id = id;
        this.iban = iban;
        this.userId = userId;
        this.balance = balance;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getIban(){
        return iban;
    }
    public void setIban(String iban){
        this.iban = iban;
    }
    public Long getUserId(){
        return userId;
    }
    public void setUserId(Long userId){
        this.userId = userId;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }

}

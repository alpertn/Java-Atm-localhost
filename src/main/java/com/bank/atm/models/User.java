package com.bank.atm.models;

import java.time.LocalDate;


public class User {

    private Long id;
    private String name;
    private String surname;
    private String tckimlikno;
    private String iban;
    private String password;
    private LocalDate birthdate;
    private float balance;

    public User() {}

    public User(Long id,String name, String surname, String tckimlikno, LocalDate birthdate,String iban,String password, float newbalance) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.tckimlikno = tckimlikno;
        this.birthdate = birthdate;
        this.iban = iban;
        this.password = password;
        this.balance = newbalance;
    }

    public Long getId(){

        return id;
    }
    public void SetId(Long yeniid){
        this.id = yeniid;
    }
    public String getName(){
        return name;
    }
    public void SetName(String name){
        this.name = name;
    }
    public String getSurname(){
        return surname;
    }
    public void SetSurname(String surname){
        this.surname = surname;

    }
    public String getTckimlikno(){

        return tckimlikno;
    }
    public void SetTckimlikno(String tckimlikno){

        this.tckimlikno = tckimlikno;
    }
    public LocalDate getBirthdate(){
        return birthdate;
    }
    public void SetBirthdate(LocalDate birthdate){
        this.birthdate = birthdate;
    }
    public String getIban(){
        return iban;
    }
    public void SetIban(String iban){
        this.iban = iban;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String yenisifre){
        password = yenisifre;
    }
    public float getbalance(){

        return balance;
    }
    public void setbalance(float newbalance){
        balance = newbalance;
    }

}

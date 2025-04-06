package com.bank.atm.models;

import java.time.LocalDate;


public class User {

    private Long id;
    private String name;
    private String surname;
    private String tckimlikno;
    private LocalDate birthdate;

    public User() {}

    public User(String name, String surname, String tckimlikno, LocalDate birthdate) {
        this.name = name;
        this.surname = surname;
        this.tckimlikno = tckimlikno;
        this.birthdate = birthdate;
    }

    public Long getId(){
        return id;
    }
    public void SetId(Long id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void SetName(String name){
        this.name = name;
    }
    public String GetSurname(){
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

}

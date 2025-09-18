package com.bank.atm.models;

import java.time.LocalDate;


public class User {

    private Long id;
    private String ad;
    private String soyad;
    private String TCKN;
    private String iban;
    private String sifre;
    private LocalDate dogumtarihi;
    private float bakiye;

    public User() {}

    public User(Long id, String ad, String surname, String tckimlikno, LocalDate birthdate, String iban, String sifre, float newbalance) {
        this.id = id;
        this.ad = ad;
        this.soyad = surname;
        this.TCKN = tckimlikno;
        this.dogumtarihi = birthdate;
        this.iban = iban;
        this.sifre = sifre;
        this.bakiye = newbalance;
    }

    public Long cekid(){

        return id;
    }
    public void belirle_id(Long yeniid){
        this.id = yeniid;
    }
    public String cek_isim(){
        return ad;
    }
    public void belirle_isim(String name){
        this.ad = name;
    }
    public String cek_soyad(){
        return soyad;
    }
    public void belirle_soyad(String surname){
        this.soyad = surname;

    }
    public String cek_tckn(){

        return TCKN;
    }
    public void belirle_tckn(String tckimlikno){

        this.TCKN = tckimlikno;
    }
    public LocalDate cek_dogumtarihi(){
        return dogumtarihi;
    }
    public void belirle_dogumtarihi(LocalDate birthdate){
        this.dogumtarihi = birthdate;
    }
    public String cek_iban(){
        return iban;
    }
    public void belirle_iban(String iban){
        this.iban = iban;
    }
    public String cek_sifre(){
        return sifre;
    }
    public void belirle_sifre(String yenisifre){
        sifre = yenisifre;
    }
    public float cek_bakiye(){

        return bakiye;
    }
    public void belirle_bakiye(float newbalance){
        bakiye = newbalance;
    }

}

package com.example.atm.service;

import com.bank.atm.models.User;
import com.bank.atm.repository.transactionrepository;
import com.bank.atm.repository.userrepository;
import com.bank.atm.models.transaction;
import com.bank.atm.service.Iban;
import com.bank.atm.service.TransactionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class AccountService {

    private final transactionrepository transactionrepository;
    private final userrepository userrepository;
    private final Iban iban;

    public AccountService(transactionrepository transactionrepository,userrepository userrepository,Iban iban) {
        this.transactionrepository=transactionrepository;
        this.userrepository=userrepository;
        this.iban= iban;
    }

    @Transactional
    public User createUser(Long id, String ad, String surname, String tckimlikno, LocalDate birthdate, String sifre, float balance){

        String iban = Iban.createiban();

        User user = new User();
        user.belirle_bakiye('0');
        user.belirle_sifre(sifre);
        user.belirle_id(userrepository.findid() + 1);
        user.belirle_isim(ad);
        user.belirle_tckn(tckimlikno);
        user.belirle_soyad(surname);
        user.belirle_dogumtarihi(birthdate);
        user.belirle_iban(iban);

        return userrepository.save(user);

    }

    public User getuserbyiban(String iban){
        return userrepository.findaccountbyiban(iban)
                .orElseThrow(() -> new RuntimeException("Bu ibana kayitli bir hesap bulunamadi.")); // if ile yaptıgımda hata verdı oyuzden bunu kullandım. hem daha az kod yazıyoruz hem daha estetık gozukuyor.


    }




}

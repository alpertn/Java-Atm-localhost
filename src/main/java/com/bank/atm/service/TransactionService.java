package com.bank.atm.service;

import com.bank.atm.models.transaction;
import com.bank.atm.repository.transactionrepository;
import com.bank.atm.repository.userrepository;
import com.bank.atm.models.User;
import com.bank.atm.repository.*;
import com.bank.atm.models.transaction;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final transactionrepository transactionRepository;

    public TransactionService(transactionrepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void kaydet(transaction islem) {
        transactionRepository.transactionkaydet(islem);
    }

    public void deposit(String iban, Float balance){

        User usser = userrepository.findaccountbyiban(iban).get(); // hata vermemesı ıcın get ekledım.



    }

//    @Transactional
//    public void deposit(String iban, double amount) {
//        Account account = getAccountByIban(iban);
//        account.setBalance(account.getBalance() + amount);
//        accountRepository.update(account);
//
//        // İşlem kaydı oluştur
//        transaction islem = new transaction(null, null, iban, amount);
//        transactionService.kaydet(islem);
//    }
//
//    @Transactional
//    public void withdraw(String iban, double amount) {
//        Account account = getAccountByIban(iban);
//        if (account.getBalance() < amount) {
//            throw new RuntimeException("Insufficient balance");
//        }
//        account.setBalance(account.getBalance() - amount);
//        accountRepository.update(account);
//
//        // İşlem kaydı oluştur
//        transaction islem = new transaction(null, iban, null, amount);
//        transactionService.kaydet(islem);
//    }
//
//    @Transactional
//    public void transfer(String fromIban, String toIban, double amount) {
//        withdraw(fromIban, amount);
//        deposit(toIban, amount);
//
//        // Transfer işlemi için ayrı kayıt
//        transaction islem = new transaction(null, fromIban, toIban, amount);
//        transactionService.kaydet(islem);
//    }
}

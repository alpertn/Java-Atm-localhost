package com.bank.atm.service;

import com.bank.atm.models.transaction;
import com.bank.atm.repository.transactionrepository;
import com.bank.atm.repository.userrepository;
import com.bank.atm.models.User;
import com.bank.atm.repository.*;
import com.bank.atm.models.transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {

    private final transactionrepository transactionRepository;

    public TransactionService(transactionrepository transactionRepository) {
        this.transactionRepository = transactionRepository; // Static olmayan olsa bile kullanmamıza yarıyor.
    }

    public void kaydet(transaction islem) {
        transactionRepository.transactionkaydet(islem);
    }

    public  void deposit(String iban, Float balance){


        User usser = userrepository.findaccountbyiban(iban).orElse(null); // hata veriyor fixlenecek.


    }

    @Transactional
    public void para_yatırma(String iban, Float miktar){


        Double balance = transactionRepository.ibantobalance(iban);
        var user = transactionRepository.updatebalancewithiban(balance + miktar,iban);
        //ibantobalance
        //Updatebakiye


    }

    @Transactional
    public void transfer(String gondereniban , String alıcıiban, Float miktar){

        Double gonderenbalance = transactionRepository.ibantobalance(gondereniban);

        if (gonderenbalance > miktar){

            Double  oldbalance = transactionRepository.ibantobalance(alıcıiban);
            transactionRepository.updatebalancewithiban(gonderenbalance - miktar, gondereniban); // basit bir transfer kodu. gercekte kullanilanlar daha kapsamlidir ama ben burda kisa tutmak istedim.
            transactionRepository.updatebalancewithiban(oldbalance + miktar , alıcıiban);


        }else{

        }



    }

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

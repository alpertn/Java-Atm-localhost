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
    public Boolean transfer(String gondereniban , String alıcıiban, Float miktar){

        Double gonderenbalance = transactionRepository.ibantobalance(gondereniban);

        if (gonderenbalance != null && gonderenbalance > miktar){

            Double  oldbalance = transactionRepository.ibantobalance(alıcıiban);
            boolean status = transactionRepository.updatebalancewithiban(gonderenbalance - miktar, gondereniban);
            boolean status2 = transactionRepository.updatebalancewithiban(oldbalance + miktar , alıcıiban);

            if (!status && !status2){

                return false;

            }else{

                return true;

            }


        } else {
            return false;
        }



    }


}

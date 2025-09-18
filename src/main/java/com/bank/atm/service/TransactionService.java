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

        User user = userrepository.findaccountbyiban(iban);

    }
}

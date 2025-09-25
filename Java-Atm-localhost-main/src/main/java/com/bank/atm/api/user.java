package com.bank.atm.api;
import com.bank.atm.models.transaction;
import com.bank.atm.models.User;
import com.bank.atm.repository.transactionrepository;
import com.bank.atm.repository.userrepository;


import com.bank.atm.repository.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/user")
public class user {

    private final userrepository userRepository;


    public user(userrepository userRepository) {
        this.userRepository = userRepository;
    }







}

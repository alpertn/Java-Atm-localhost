package com.bank.atm.api;


import com.bank.atm.repository.transactionrepository;
import com.bank.atm.repository.userrepository;
import com.bank.atm.service.AccountService;
import com.bank.atm.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.bank.atm.dto.userdto;
import com.bank.atm.security.clown;
import org.springframework.validation.BindingResult;

import com.bank.atm.security.sqlinjectiontester;


@RestController
@RequestMapping("api/transaction")
public class transaction {

    private final transactionrepository transactionepositoryi; // kullanabilmek icin bunu yaziyoruz
    private final userrepository userrepository;
    private final AccountService accountservice;
    private final TransactionService transactionservice;


    public transaction (transactionrepository transactionepositoryi, userrepository userrepository, AccountService accountservice, TransactionService transactionservice) { // constructor'a dto sınıfını koyunca hata verıyor dırekt cagırmamız lazım.
        this.transactionepositoryi = transactionepositoryi;
        this.userrepository = userrepository;
        this.accountservice = accountservice;
        this.transactionservice = transactionservice;
    }
    @PostMapping("/createuser")
    public ResponseEntity<?> createuser(@Valid
                                        @RequestBody
                                        userdto request,
                                        BindingResult bindingresult

    ){

        if (sqlinjectiontester.isSqlInjection(request.getname() + request.getsurname() + request.getbirthdate() +  request.getpassword() +request.gettckn()) == true)
        {

            return ResponseEntity.badRequest().body(clown.json());


        }else{
            System.out.println(
                    request.getname() + request.getsurname() + request.getbirthdate() +  request.getpassword() +request.gettckn()
            );
            if(bindingresult.hasErrors()){

                return ResponseEntity.badRequest().build();

            }else{

                accountservice.createUser(request.getname(),request.getsurname(),request.gettckn(),request.getpassword(),request.getbirthdate());
                return ResponseEntity.ok(request);

            }

        }






    }


}

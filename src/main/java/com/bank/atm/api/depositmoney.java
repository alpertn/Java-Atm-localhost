package com.bank.atm.api;


import com.bank.atm.repository.transactionrepository;
import com.bank.atm.repository.userrepository;
import com.bank.atm.service.AccountService;
import com.bank.atm.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.bank.atm.dto.depositmoneydto;
import com.bank.atm.security.clown;
import org.springframework.validation.BindingResult;

import com.bank.atm.security.sqlinjectiontester;

import java.util.Map;


@RestController
@RequestMapping("api/user")
public class depositmoney {

    private final transactionrepository transactionepositoryi;
    private final userrepository userrepository;
    private final AccountService accountservice;
    private final TransactionService transactionservice;


    public depositmoney (transactionrepository transactionepositoryi, userrepository userrepository, AccountService accountservice, TransactionService transactionservice) {
        this.transactionepositoryi = transactionepositoryi;
        this.userrepository = userrepository;
        this.accountservice = accountservice;
        this.transactionservice = transactionservice;
    }
    @PostMapping("/depositmoney")
    public ResponseEntity<?> depositmoney(@Valid
                                        @RequestBody
                                        depositmoneydto request,
                                        BindingResult bindingresult

    ){

        if (sqlinjectiontester.isSqlInjection(request.gettckn() + request.getpassword() + request.getbalance()) == true)
        {

            return ResponseEntity.badRequest().body(clown.json());


        }else{
            if(bindingresult.hasErrors()){

                return ResponseEntity.badRequest().build();

            }else{

                try{

                    float balance = Float.valueOf(request.getbalance());

                    if (transactionepositoryi.parayatirmatckn(request.gettckn(),balance) == true){

                        return ResponseEntity.ok(Map.of("Status","1"));

                    }else{

                        return ResponseEntity.badRequest().build();
                    }


                }catch(NumberFormatException e){

                    return ResponseEntity.badRequest().body(Map.of("error",e));
                }

            }

        }






    }







}

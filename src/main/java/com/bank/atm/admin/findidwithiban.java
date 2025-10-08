package com.bank.atm.admin;

import com.bank.atm.admindto.findidwithibandto;
import com.bank.atm.admindto.updatebalancewithibandto;
import com.bank.atm.repository.transactionrepository;
import com.bank.atm.repository.userrepository;
import com.bank.atm.service.AccountService;
import com.bank.atm.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import com.bank.atm.security.sqlinjectiontester;
import com.bank.atm.security.clown;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class findidwithiban {

    private final transactionrepository transactionepositoryi;
    private final userrepository userrepository;
    private final AccountService accountservice;
    private final TransactionService transactionservice;
    private final checkadmin checkadmin;


    public findidwithiban (transactionrepository transactionepositoryi, userrepository userrepository, checkadmin checkadmin, AccountService accountservice, TransactionService transactionservice) {
        this.transactionepositoryi = transactionepositoryi;
        this.userrepository = userrepository;
        this.checkadmin = checkadmin;
        this.accountservice = accountservice;
        this.transactionservice = transactionservice;
    }


    @PostMapping("/findidwithiban")
    public ResponseEntity<?>  requesthandler(
            @Valid
            @RequestBody
            findidwithibandto request,
            BindingResult bindingresult
    ){


        if(sqlinjectiontester.isSqlInjection(request.getiban() + request.getadminpassword()  + request.getadminname()) == true){


            return ResponseEntity.badRequest().body(clown.json());

        }else{


            if(checkadmin.checkadmin(request.getadminname() , request.getadminpassword()) == true){

                String id  = userrepository.findbyiban2(request.getiban());

                return ResponseEntity.ok(Map.of("id" , id));


            }else{

                return ResponseEntity.badRequest().body(clown.json());

            }


        }


    }


}

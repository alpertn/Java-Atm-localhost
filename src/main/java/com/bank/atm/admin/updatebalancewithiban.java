package com.bank.atm.admin;


import com.bank.atm.admindto.updatebalancewithibandto;
import com.bank.atm.repository.transactionrepository;
import com.bank.atm.repository.userrepository;
import com.bank.atm.service.AccountService;
import com.bank.atm.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.bank.atm.dto.userdto;
import com.bank.atm.security.clown;
import com.bank.atm.admin.checkadmin;
import org.springframework.validation.BindingResult;

import com.bank.atm.security.sqlinjectiontester;


@RestController
@RequestMapping("api/admin")
public class updatebalancewithiban {

    private final transactionrepository transactionepositoryi; // kullanabilmek icin bunu yaziyoruz
    private final userrepository userrepository;
    private final AccountService accountservice;
    private final TransactionService transactionservice;
    private final checkadmin checkadmin;



    public updatebalancewithiban (transactionrepository transactionepositoryi, userrepository userrepository, checkadmin checkadmin, AccountService accountservice, TransactionService transactionservice) { // constructor'a dto sınıfını koyunca hata verıyor dırekt cagırmamız lazım.
        this.transactionepositoryi = transactionepositoryi;
        this.userrepository = userrepository;
        this.checkadmin = checkadmin;
        this.accountservice = accountservice;
        this.transactionservice = transactionservice;
    }

    @PostMapping("/updatebalancewithiban")
    public ResponseEntity<?> request(@Valid
                                        @RequestBody
                                            updatebalancewithibandto request,
                                        BindingResult bindingresult

    ){

        if (sqlinjectiontester.isSqlInjection(request.getadminname() + request.getadminpassword()+ request.getiban()+ request.getbalance().toString()) == true)
        {

            return ResponseEntity.badRequest().body(clown.json());


        }else{



            if(bindingresult.hasErrors()){

                return ResponseEntity.badRequest().build();

            }else{
                if (checkadmin.checkadmin(request.getadminname(),request.getadminpassword()) == true){

                    userrepository.updatebalancewithiban( request.getbalance(),request.getiban());
                    return ResponseEntity.ok(request);

                }else{

                    return ResponseEntity.badRequest().body(clown.json());

                }


            }

        }



    }




}

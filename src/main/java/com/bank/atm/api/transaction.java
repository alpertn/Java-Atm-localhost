package com.bank.atm.api;


import com.bank.atm.repository.transactionrepository;
import com.bank.atm.repository.userrepository;
import com.bank.atm.service.AccountService;
import com.bank.atm.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.bank.atm.dto.transactiondto;
import com.bank.atm.security.clown;
import org.springframework.validation.BindingResult;
import java.util.Map;
import com.bank.atm.security.sqlinjectiontester;


@RestController
@RequestMapping("api/transaction")
public class transaction {

    private final transactionrepository transactionepositoryi;
    private final userrepository userrepository;
    private final AccountService accountservice;
    private final TransactionService transactionservice;


    public transaction (transactionrepository transactionepositoryi, userrepository userrepository, AccountService accountservice, TransactionService transactionservice) { // constructor'a dto sınıfını koyunca hata verıyor dırekt cagırmamız lazım.
        this.transactionepositoryi = transactionepositoryi;
        this.userrepository = userrepository;
        this.accountservice = accountservice;
        this.transactionservice = transactionservice;
    }
    @PostMapping("/sendmoney")
    public ResponseEntity<?> createuser(@Valid
                                        @RequestBody
                                        transactiondto request,
                                        BindingResult bindingresult

    ){

        if (sqlinjectiontester.isSqlInjection(request.getbalance() + request.getiban() + request.gettckn() +  request.getpassword() +request.gettckn()) == true)
        {

            return ResponseEntity.badRequest().body(clown.json());


        }else{
            if(transactionepositoryi.tckndogrula(request.gettckn(),request.getpassword()) == true){


                if (transactionepositoryi.findibanwithtckn(request.gettckn()) != null){


                    if(bindingresult.hasErrors()){

                        return ResponseEntity.badRequest().build();

                    }else{

                        String iban = transactionepositoryi.findibanwithtckn(request.gettckn());
                                try{
                                   Float balance = Float.parseFloat(request.getbalance() );



                                   if(transactionservice.transfer(iban,request.getiban(),balance) == true){


                                       return ResponseEntity.ok(Map.of("Status","1"));

                                   }else{

                                       return ResponseEntity.badRequest().build();
                                   }


                                }catch (NumberFormatException e){

                                    return ResponseEntity.badRequest().body(Map.of("error", "number format exception"));
                                }


                    }

                }


            }else{

                return ResponseEntity.badRequest().body(Map.of("status","0"));

            }


        }


         return ResponseEntity.badRequest().body(Map.of("status","0"));
    }


}

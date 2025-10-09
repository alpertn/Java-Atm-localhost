package com.bank.atm.admin;


import com.bank.atm.admindto.finduserwithiddto;
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
import java.util.Map;

@RestController
@RequestMapping("api/admin")
public class finduserwithid {

    private final transactionrepository transactionepositoryi; // kullanabilmek icin bunu yaziyoruz
    private final userrepository userrepository;
    private final AccountService accountservice;
    private final TransactionService transactionservice;
    private final checkadmin checkadmin;



    public finduserwithid (transactionrepository transactionepositoryi, userrepository userrepository, checkadmin checkadmin, AccountService accountservice, TransactionService transactionservice) { // constructor'a dto sınıfını koyunca hata verıyor dırekt cagırmamız lazım.
        this.transactionepositoryi = transactionepositoryi;
        this.userrepository = userrepository;
        this.checkadmin = checkadmin;
        this.accountservice = accountservice;
        this.transactionservice = transactionservice;
    }

    @PostMapping("/finduserwithid")
    public ResponseEntity<?> request(@Valid
                                     @RequestBody
                                     finduserwithiddto request,
                                     BindingResult bindingresult

    ){

        if (sqlinjectiontester.isSqlInjection(request.getadminname() + request.getadminpassword()+ request.getid()) == true)
        {

            return ResponseEntity.badRequest().body(clown.json());


        }else{



            if(bindingresult.hasErrors()){

                return ResponseEntity.badRequest().build();

            }else{
                if (checkadmin.checkadmin(request.getadminname(),request.getadminpassword()) == true){

                    var userOpt = userrepository.idsorgu(Long.valueOf(request.getid()));

                    if (userOpt.isPresent()) {
                        return ResponseEntity.ok(userOpt.get()); // User objesini JSON olarak döner
                    } else {
                        return ResponseEntity.status(404).body(Map.of("error", "User not found"));
                    }

                }else{

                    return ResponseEntity.badRequest().body(clown.json());

                }


            }

        }



    }




}

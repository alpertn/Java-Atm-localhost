//package com.bank.atm.admin;
//
//import com.bank.atm.admindto.finduserwithiddto;
//import com.bank.atm.repository.transactionrepository;
//import com.bank.atm.repository.userrepository;
//import com.bank.atm.service.AccountService;
//import com.bank.atm.service.TransactionService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import jakarta.validation.Valid;
//import com.bank.atm.dto.userdto;
//import com.bank.atm.security.clown;
//import com.bank.atm.admin.checkadmin;
//import org.springframework.validation.BindingResult;
//import com.bank.atm.security.sqlinjectiontester;
//
//import jakarta.servlet.http.HttpServletRequest;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.List;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Map;
//
//
//@RestController
//@RequestMapping("api/admin")
//public class finduserwithid {
//
//    private static final long TIME_LIMIT_MILLIS = 60 * 1000;
//    private static final int MAX_REQUESTS = 10;
//
//    private static final Map<String, List<Long>> requestHistory = new ConcurrentHashMap<>();
//
//    private final transactionrepository transactionepositoryi;
//    private final userrepository userrepository;
//    private final AccountService accountservice;
//    private final TransactionService transactionservice;
//    private final checkadmin checkadmin;
//
//
//    public finduserwithid (transactionrepository transactionepositoryi, userrepository userrepository, checkadmin checkadmin, AccountService accountservice, TransactionService transactionservice) {
//        this.transactionepositoryi = transactionepositoryi;
//        this.userrepository = userrepository;
//        this.checkadmin = checkadmin;
//        this.accountservice = accountservice;
//        this.transactionservice = transactionservice;
//    }
//
//    private String getClientIp(HttpServletRequest request) {
//        String xfHeader = request.getHeader("X-Forwarded-For");
//        if (xfHeader != null && !xfHeader.isEmpty() && !"unknown".equalsIgnoreCase(xfHeader)) {
//            return xfHeader.split(",")[0].trim();
//        }
//        return request.getRemoteAddr();
//    }
//
//
//    @PostMapping("/finduserwithid")
//    public ResponseEntity<?> request(@Valid
//                                     @RequestBody
//                                     finduserwithiddto requestDto,
//                                     BindingResult bindingresult,
//                                     HttpServletRequest request
//
//    ){
//        String clientIp = getClientIp(request);
//        long currentTime = System.currentTimeMillis();
//
//        final boolean[] isRateLimited = {false};
//
//        requestHistory.compute(clientIp, (key, timestampsList) -> {
//            if (timestampsList == null) {
//                timestampsList = Collections.synchronizedList(new ArrayList<>());
//            }
//
//            timestampsList.removeIf(timestamp -> timestamp < currentTime - TIME_LIMIT_MILLIS);
//
//            if (timestampsList.size() >= MAX_REQUESTS) {
//                isRateLimited[0] = true;
//            } else {
//                timestampsList.add(currentTime);
//            }
//
//            return timestampsList;
//        });
//
//        if (isRateLimited[0]) {
//            return ResponseEntity.status(429).body("{\"error\": \"Too Many Requests. Maximum " + MAX_REQUESTS + " requests per minute allowed per IP.\"}");
//        }
//
//
//        if (sqlinjectiontester.isSqlInjection(requestDto.getadminname() + requestDto.getadminpassword()+ requestDto.getid()) == true)
//        {
//
//            return ResponseEntity.badRequest().body(clown.json());
//
//
//        }else{
//
//
//
//            if(bindingresult.hasErrors()){
//
//                return ResponseEntity.badRequest().build();
//
//            }else{
//                if (checkadmin.checkadmin(requestDto.getadminname(),requestDto.getadminpassword()) == true){
//
//                    var userOpt = userrepository.idsorgu(Long.valueOf(requestDto.getid()));
//
//                    if(userOpt.isPresent()) {
//                        return ResponseEntity.ok(userOpt.get());
//                    } else {
//                        return ResponseEntity.notFound().build();
//                    }
//
//
//                }else{
//
//                    return ResponseEntity.badRequest().body(clown.json());
//
//                }
//
//
//            }
//
//        }
//    }
//}

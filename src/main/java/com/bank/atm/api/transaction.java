package com.bank.atm.api;

import com.bank.atm.*;
import com.bank.atm.repository.transactionrepository;
import com.bank.atm.repository.userrepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bank.atm.service.TransactionService;
import com.bank.atm.service.AccountService;

@RestController
@RequestMapping("/api/transaction")
public class transaction {


    private final transactionrepository transactionepositoryi; // kullanabilmek icin bunu yaziyoruz
    private final userrepository userrepository;
    private final AccountService accountservice;
    private final TransactionService transactionservice;


    public transaction(transactionrepository transactionepositoryi, userrepository userrepository, AccountService accountservice, TransactionService transactionservice) {
        this.transactionepositoryi = transactionepositoryi;
        this.userrepository = userrepository;
        this.accountservice = accountservice;
        this.transactionservice = transactionservice;
    }


//package com.example.contactapi.controller;                  // Bu sınıfın Java package (paket) tanımı
//
//import com.example.contactapi.dto.ContactRequest;           // DTO sınıfı: API'den gelen verileri temsil eder (name, phone)
//import com.example.contactapi.model.Contact;                // Model sınıfı: işlenen ve dönen kişi verisi
//import com.example.contactapi.service.ContactService;       // Servis sınıfı: iş mantığını içerir
//
//import jakarta.validation.Valid;                             // Kütüphane: Verileri doğrulamak için kullanılır (@Valid anotasyonu)
//import org.springframework.http.ResponseEntity;             // Kütüphane: HTTP cevabı döndürmek için kullanılır
//import org.springframework.validation.BindingResult;        // Kütüphane: Validasyon hatalarını tutar
//import org.springframework.web.bind.annotation.*;           // Kütüphane: REST API için gerekli anotasyonları içerir
//
//import java.util.List;                                       // Java'nın List koleksiyonu
//
//    @RestController                                             // Spring anotasyonu: Bu sınıf bir REST controller'dır
//    @RequestMapping("/api/contacts")                            // Bu controller altındaki tüm endpoint'ler bu URL ile başlar
//    public class ContactController {                            // Sınıf tanımı: ContactController sınıfı başlar
//
//        private final ContactService contactService;            // Servis katmanından gelen bağımlılık, iş mantığını içerir
//
//        public ContactController(ContactService contactService) {       // Constructor (yapıcı metod)
//            this.contactService = contactService;                        // Gelen servisi bu sınıf içinde kullanmak için atama yapılır
//        }
//
//        /**
//         * Bu metod, yeni bir kişi (contact) kaydı oluşturmak için POST isteğini karşılar.
//         * URL: POST /api/contacts
//         */
//        @PostMapping                                                // Anotasyon: Bu metod bir POST isteğini karşılar
//        public ResponseEntity<?> createContact(                     // Geri dönüş tipi: HTTP yanıtı döner (200, 400 vs.)
//                                                                    @Valid                                              // Anotasyon: request nesnesinin geçerliliğini kontrol eder (örneğin boş mu, format doğru mu)
//                                                                    @RequestBody                                        // Anotasyon: HTTP isteğinin gövdesindeki JSON veriyi Java nesnesine dönüştürür
//                                                                    ContactRequest request,                             // Değişken: İstemciden gelen "name" ve "phone" verilerini içeren DTO
//                                                                    BindingResult bindingResult                         // Değişken: Validasyon sırasında oluşan hataları tutar
//        ) {
//            // Eğer validasyon hatası varsa (örneğin name boş gelmişse), 400 Bad Request dön
//            if (bindingResult.hasErrors()) {
//                return ResponseEntity.badRequest()                  // HTTP 400 yanıtı döndürülür
//                        .body(bindingResult.getAllErrors());       // Tüm validasyon hataları JSON olarak döndürülür
//            }
//
//            // Hata yoksa, servise yönlendir → yeni kişi oluşturulur
//            Contact createdContact = contactService.createContact(request);    // Değişken: Oluşturulan yeni kişi bilgisi
//
//            return ResponseEntity.ok(createdContact);                          // HTTP 200 OK ve oluşturulan kişi JSON olarak döndürülür
//        }
//
//        /**
//         * Bu metod, tüm kayıtlı kişileri listelemek için GET isteğini karşılar.
//         * URL: GET /api/contacts
//         */
//        @GetMapping                                                       // Anotasyon: Bu metod bir GET isteğini karşılar
//        public ResponseEntity<List<Contact>> getAllContacts() {          // Geri dönüş: Contact listesini döner
//            return ResponseEntity.ok(contactService.getAll());           // Servisten tüm kişileri alır ve HTTP 200 ile döner
//        }
//    }
//


}

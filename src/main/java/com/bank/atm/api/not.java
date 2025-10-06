//package com.example.contactapi.controller;
//
//import com.example.contactapi.dto.ContactRequest;       // İsim ve telefon DTO
//import com.example.contactapi.dto.EmailRequest;         // Email DTO
//import com.example.contactapi.model.Contact;
//import com.example.contactapi.service.ContactService;
//
//import jakarta.validation.Valid;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/contacts")  // Temel path
//public class ContactController {
//
//    private final ContactService contactService;
//
//    public ContactController(ContactService contactService) {
//        this.contactService = contactService;
//    }
//
//    /**
//     * İsim ve telefon alan endpoint
//     * POST /api/contacts/telefonadsoyad
//     */
//    @PostMapping("/telefonadsoyad")
//    public ResponseEntity<?> createContact(
//            @Valid @RequestBody ContactRequest request,
//            BindingResult bindingResult
//    ) {
//        if (bindingResult.hasErrors()) {
//            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
//        }
//        Contact createdContact = contactService.createContact(request);
//        return ResponseEntity.ok(createdContact);
//    }
//
//    /**
//     * Sadece email alan endpoint
//     * POST /api/contacts/mailal
//     */
//    @PostMapping("/mailal")
//    public ResponseEntity<?> createEmail(
//            @Valid @RequestBody EmailRequest request,
//            BindingResult bindingResult
//    ) {
//        if (bindingResult.hasErrors()) {
//            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
//        }
//        Contact contactWithEmail = new Contact();
//        contactWithEmail.setEmail(request.getEmail());
//        return ResponseEntity.ok(contactWithEmail);
//    }
//
//    /**
//     * Tüm kayıtlı kişileri listele
//     * GET /api/contacts
//     */
//    @GetMapping
//    public ResponseEntity<List<Contact>> getAllContacts() {
//        return ResponseEntity.ok(contactService.getAll());
//    }
//}
package com.prospera.account.controller;

import com.prospera.account.service.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account")
public class AccountController {

    private final AccountServiceImpl accountService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateAccounts() {
        try {
        accountService.generateRandomAccounts();
            return ResponseEntity.ok( " random accounts generated successfully!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("❌ Failed to generate accounts.");
        }
    }
}

package com.example.sellinglaptops.controller;

import com.example.sellinglaptops.model.Account;
import com.example.sellinglaptops.service.account.AccountService;
import com.example.sellinglaptops.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private IAccountService iAccountService;
    @GetMapping("/{id}")
    private ResponseEntity<Account> getByIdAccount(@PathVariable long id) {
        Optional<Account> account = iAccountService.findById(id);
        if (account.isPresent()) {
            return ResponseEntity.ok(account.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}

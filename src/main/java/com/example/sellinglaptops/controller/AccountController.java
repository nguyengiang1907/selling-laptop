package com.example.sellinglaptops.controller;

import com.example.sellinglaptops.model.Account;
import com.example.sellinglaptops.model.AccountDTO;
import com.example.sellinglaptops.service.account.AccountService;
import com.example.sellinglaptops.service.account.IAccountService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    Account accountLogin = new Account();
    @Value("C:\\IDE\\SellingLaptops\\src\\main\\resources\\static\\")
    private String fileUpload;
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
    @PostMapping("/signUp")
    private ResponseEntity<Account> createAccount(@ModelAttribute AccountDTO accountDTO) throws IOException {

        MultipartFile multipartFile = accountDTO.getImage();
        String fileName = multipartFile.getOriginalFilename();
        FileCopyUtils.copy(accountDTO.getImage().getBytes(), new File(fileUpload + fileName));
        Account account = new Account(accountDTO.getName(),accountDTO.getPassword(),accountDTO.getEmail(),accountDTO.getPhoneNumber(),accountDTO.getAddress(),fileName);

        if (iAccountService.findAllByEmail(account.getEmail()) == null){
            if (accountDTO.getPassword().equals(accountDTO.getRePassword())){
                return new ResponseEntity<>(iAccountService.save(account), HttpStatus.CREATED);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("login/{email}/{password}")
    private ResponseEntity<Account> getAccountByEmailAndPassword(@PathVariable String email, @PathVariable String password){
        Account account = iAccountService.findAllByEmailAndPassword(email,password);
        if (account != null){
            accountLogin = account;
            return new ResponseEntity<>(account,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/check")
    public ResponseEntity<Account> checkSession() {
        if (accountLogin != null) {
            return new ResponseEntity<>(accountLogin, HttpStatus.OK);
        } else {
            System.out.println("No User ID found in session");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("/logout")
//    public String logout() {
//        accountLogin = null;
//        return "logout";
//    }
}

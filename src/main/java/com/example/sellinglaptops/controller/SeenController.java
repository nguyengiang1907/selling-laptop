package com.example.sellinglaptops.controller;

import com.example.sellinglaptops.model.Account;
import com.example.sellinglaptops.model.Laptop;
import com.example.sellinglaptops.model.Seen;
import com.example.sellinglaptops.service.account.IAccountService;
import com.example.sellinglaptops.service.laptop.ILaptopService;
import com.example.sellinglaptops.service.seen.ISeenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/seen")
public class SeenController {
    @Autowired
    private ISeenService iSeenService;
    @Autowired
    private ILaptopService iLaptopService;
    @Autowired
    private IAccountService iAccountService;

    @GetMapping("/{idAccount}")
    private ResponseEntity<List<Seen>> getSeen(@PathVariable long idAccount) {
        Optional<Account> account = iAccountService.findById(idAccount);
        List<Seen> seenList = iSeenService.findAllByAccount(account.get());
        if (seenList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(seenList, HttpStatus.OK);
        }
    }
    @PostMapping("/{idAccount}/{idLaptop}")
    private ResponseEntity<Seen> createSeen(@PathVariable long idAccount, @PathVariable long idLaptop) {
            Optional<Laptop> laptop = iLaptopService.findById(idLaptop);
        LocalDateTime localDateTime = LocalDateTime.now();
        Optional<Account> account = iAccountService.findById(idAccount);
        Seen seen = iSeenService.findByAccountAndLaptop(account.get(),laptop.get());
        Seen newSeen = new Seen(laptop.get(),account.get(),localDateTime,localDateTime);
        if (seen != null){
            iSeenService.remove(seen.getId());
            iSeenService.save(newSeen);
            return new ResponseEntity<>(newSeen, HttpStatus.CREATED);
        }else {
            iSeenService.save(newSeen);
            return new ResponseEntity<>(newSeen, HttpStatus.CREATED);
        }
    }

}

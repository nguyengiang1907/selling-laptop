package com.example.sellinglaptops.controller;

import com.example.sellinglaptops.model.Laptop;
import com.example.sellinglaptops.service.laptop.ILaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/laptops")
public class LaptopController {
    @Autowired
    private ILaptopService iLaptopService;

    @GetMapping("/{id}")
    private ResponseEntity<Laptop> getLaptopById(@PathVariable int id) {
        Optional<Laptop> laptopOptional = iLaptopService.findById(id);
        return new ResponseEntity<>(laptopOptional.get(), HttpStatus.OK);
    }
    @GetMapping()
    private ResponseEntity<List<Laptop>> getAllLaptops() {
        List<Laptop> laptops = (List<Laptop>) iLaptopService.findAll();
        if (laptops.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(laptops, HttpStatus.OK);
        }
    }
}

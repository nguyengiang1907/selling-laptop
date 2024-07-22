package com.example.sellinglaptops.controller;

import com.example.sellinglaptops.model.Account;
import com.example.sellinglaptops.model.Cart;
import com.example.sellinglaptops.model.Laptop;
import com.example.sellinglaptops.model.QuantityRequest;
import com.example.sellinglaptops.service.account.IAccountService;
import com.example.sellinglaptops.service.cart.ICartService;
import com.example.sellinglaptops.service.laptop.ILaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private ICartService iCartService;
    @Autowired
    private IAccountService iAccountService;
    @Autowired
    private ILaptopService iLaptopService;

    @GetMapping("/{id}")
    private ResponseEntity<List<Cart>> getCartById(@PathVariable long id){
        Optional<Account> account = iAccountService.findById(id);
        List<Cart> carts = iCartService.findCartByIdAccount(account.get());
        if (carts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(carts, HttpStatus.OK);
        }
    }
    @PostMapping("/{idUser}/{idLaptop}")
    private ResponseEntity<Cart> addCart(@PathVariable long idUser, @PathVariable long idLaptop, @RequestBody QuantityRequest quantityRequest){
        Optional<Account> account = iAccountService.findById(idUser);
        Optional<Laptop> laptop = iLaptopService.findById(idLaptop);
        Cart newCart = new Cart(laptop.get().getQuantity(),laptop.get(),account.get());
        Optional<Cart> cart = iCartService.findCartByIdAccountAndIdLaptop(account.get(),laptop.get());
        if (cart.isEmpty()){
            newCart.setQuantity(quantityRequest.getQuantity());
           iCartService.save(newCart);
           return new ResponseEntity<>(newCart, HttpStatus.CREATED);
        }else {
            cart.get().setQuantity(cart.get().getQuantity() + quantityRequest.getQuantity());
            iCartService.save(cart.get());
            return new ResponseEntity<>(cart.get(), HttpStatus.OK);
        }
    }
    @GetMapping("/increase/{id}")
    private ResponseEntity<Cart> increaseLaptop(@PathVariable long id) {
        Optional<Cart> cart = iCartService.findById(id);
        cart.get().setQuantity(cart.get().getQuantity() - 1);
        if (cart.get().getQuantity() == 0){
            iCartService.remove(id);
            return new ResponseEntity<>(cart.get(), HttpStatus.NO_CONTENT);
        }else {
            iCartService.save(cart.get());
            return new ResponseEntity<>(cart.get(), HttpStatus.OK);
        }
    }
    @GetMapping("/reduce/{id}")
    private ResponseEntity<Cart> reduceLaptop(@PathVariable long id) {
        Optional<Cart> cart = iCartService.findById(id);
        cart.get().setQuantity(cart.get().getQuantity() + 1);
        iCartService.save(cart.get());
        return new ResponseEntity<>(cart.get(), HttpStatus.OK);
    }
    @DeleteMapping("/deleteCart/{id}")
    private ResponseEntity<Cart> deleteLaptop(@PathVariable long id) {
        iCartService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

package com.example.sellinglaptops.service.cart;

import com.example.sellinglaptops.model.Account;
import com.example.sellinglaptops.model.Cart;
import com.example.sellinglaptops.model.Laptop;
import com.example.sellinglaptops.service.IGenerateService;

import java.util.List;
import java.util.Optional;


public interface ICartService extends IGenerateService<Cart> {
    List<Cart> findCartByIdAccount(Account account);
    Optional<Cart> findCartByIdAccountAndIdLaptop(Account account, Laptop laptop);
}

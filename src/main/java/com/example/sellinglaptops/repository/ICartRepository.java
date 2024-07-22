package com.example.sellinglaptops.repository;

import com.example.sellinglaptops.model.Account;
import com.example.sellinglaptops.model.Cart;
import com.example.sellinglaptops.model.Laptop;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface ICartRepository extends CrudRepository<Cart, Long> {
     List<Cart> findCartByIdAccount(Account account);
     Optional<Cart> findCartByIdAccountAndIdLaptop(Account account, Laptop laptop);
}

package com.example.sellinglaptops.service.cart;

import com.example.sellinglaptops.model.Account;
import com.example.sellinglaptops.model.Cart;
import com.example.sellinglaptops.model.Laptop;
import com.example.sellinglaptops.repository.ICartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CartService implements ICartService{
    @Autowired
    private ICartRepository iCartRepository;
    @Override
    public Iterable<Cart> findAll() {
        return iCartRepository.findAll();
    }

    @Override
    public Optional<Cart> findById(long id) {
        return iCartRepository.findById(id);
    }

    @Override
    public Cart save(Cart cart) {
        return iCartRepository.save(cart);
    }

    @Override
    public void remove(long id) {
        iCartRepository.deleteById(id);
    }

    @Override
    public List<Cart> findCartByIdAccount(Account account) {
        return iCartRepository.findCartByIdAccount(account);
    }

    @Override
    public Optional<Cart> findCartByIdAccountAndIdLaptop(Account account, Laptop laptop) {
        return iCartRepository.findCartByIdAccountAndIdLaptop(account,laptop);
    }
}

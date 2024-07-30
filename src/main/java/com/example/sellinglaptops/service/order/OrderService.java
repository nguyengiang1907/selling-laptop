package com.example.sellinglaptops.service.order;

import com.example.sellinglaptops.model.Account;
import com.example.sellinglaptops.model.Order;
import com.example.sellinglaptops.model.Status;
import com.example.sellinglaptops.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderService implements IOrderService{
    @Autowired
    private IOrderRepository iOrderRepository;
    @Override
    public Iterable<Order> findAll() {
        return iOrderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(long id) {
        return iOrderRepository.findById(id);
    }

    @Override
    public Order save(Order order) {
        return iOrderRepository.save(order);
    }

    @Override
    public void remove(long id) {
        iOrderRepository.deleteById(id);
    }

    @Override
    public List<Order> findAllByAccount(Account account) {
        return iOrderRepository.findAllByAccount(account);
    }

    @Override
    public List<Order> findAllByAccountAndStatus(Account account, Status status) {
        return iOrderRepository.findAllByAccountAndStatus(account,status);
    }
}

package com.example.sellinglaptops.repository;

import com.example.sellinglaptops.model.Account;
import com.example.sellinglaptops.model.Order;
import com.example.sellinglaptops.model.Status;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IOrderRepository extends CrudRepository<Order,Long> {
    @Query("SELECT o FROM Order o JOIN Cart c on o.cart.id = c.id JOIN Account a on c.idAccount.id = a.id where a = ?1")
    List<Order> findAllByAccount(Account account);
    List<Order> findAllByAccountAndStatus(Account account, Status status);
}

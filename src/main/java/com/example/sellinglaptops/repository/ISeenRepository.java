package com.example.sellinglaptops.repository;

import com.example.sellinglaptops.model.Account;
import com.example.sellinglaptops.model.Laptop;
import com.example.sellinglaptops.model.Seen;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ISeenRepository extends CrudRepository<Seen, Long> {
    List<Seen> findAllByAccount(Account account);
    Seen findByAccountAndLaptop(Account account, Laptop laptop);
}

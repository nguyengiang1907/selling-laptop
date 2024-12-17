package com.example.sellinglaptops.repository;

import com.example.sellinglaptops.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface IAccountRepository extends CrudRepository<Account, Long> {
    Account findAllByEmail(String email);
    Account findAllByEmailAndPassword(String email, String password);
}

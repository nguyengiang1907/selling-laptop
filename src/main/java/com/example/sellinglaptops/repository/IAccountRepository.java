package com.example.sellinglaptops.repository;

import com.example.sellinglaptops.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface IAccountRepository extends CrudRepository<Account, Long> {
}

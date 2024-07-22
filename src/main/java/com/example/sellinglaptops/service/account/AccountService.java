package com.example.sellinglaptops.service.account;

import com.example.sellinglaptops.model.Account;
import com.example.sellinglaptops.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository iAccountRepository;
    @Override
    public Iterable<Account> findAll() {
        return iAccountRepository.findAll();
    }

    @Override
    public Optional<Account> findById(long id) {
        return iAccountRepository.findById(id);
    }

    @Override
    public Account save(Account account) {
        return iAccountRepository.save(account);
    }

    @Override
    public void remove(long id) {
        iAccountRepository.deleteById(id);
    }
}

package com.example.sellinglaptops.service.seen;

import com.example.sellinglaptops.model.Account;
import com.example.sellinglaptops.model.Laptop;
import com.example.sellinglaptops.model.Seen;
import com.example.sellinglaptops.repository.ISeenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeenService implements ISeenService {
    @Autowired
    private ISeenRepository iSeenRepository;
    @Override
    public Iterable<Seen> findAll() {
        return iSeenRepository.findAll();
    }

    @Override
    public Optional<Seen> findById(long id) {
        return iSeenRepository.findById(id);
    }

    @Override
    public Seen save(Seen seen) {
        return iSeenRepository.save(seen);
    }

    @Override
    public void remove(long id) {
        iSeenRepository.deleteById(id);
    }

    @Override
    public List<Seen> findAllByAccount(Account account) {
        return iSeenRepository.findAllByAccount(account);
    }

    @Override
    public Seen findByAccountAndLaptop(Account account, Laptop laptop) {
        return iSeenRepository.findByAccountAndLaptop(account,laptop);
    }
}

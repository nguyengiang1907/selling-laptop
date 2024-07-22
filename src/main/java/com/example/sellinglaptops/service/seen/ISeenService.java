package com.example.sellinglaptops.service.seen;

import com.example.sellinglaptops.model.Account;
import com.example.sellinglaptops.model.Laptop;
import com.example.sellinglaptops.model.Seen;
import com.example.sellinglaptops.service.IGenerateService;

import java.util.List;

public interface ISeenService extends IGenerateService<Seen> {
    List<Seen> findAllByAccount(Account account);
    Seen findByAccountAndLaptop(Account account, Laptop laptop);
}

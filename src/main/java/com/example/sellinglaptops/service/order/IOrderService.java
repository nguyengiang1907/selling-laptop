package com.example.sellinglaptops.service.order;

import com.example.sellinglaptops.model.Account;
import com.example.sellinglaptops.model.Order;
import com.example.sellinglaptops.model.Status;
import com.example.sellinglaptops.service.IGenerateService;

import java.util.List;

public interface IOrderService extends IGenerateService<Order> {
        List<Order> findAllByAccount(Account account);
        List<Order> findAllByAccountAndStatus(Account account, Status status);
}

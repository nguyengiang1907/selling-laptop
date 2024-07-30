package com.example.sellinglaptops.controller;

import com.example.sellinglaptops.model.*;
import com.example.sellinglaptops.service.account.IAccountService;
import com.example.sellinglaptops.service.cart.ICartService;
import com.example.sellinglaptops.service.laptop.ILaptopService;
import com.example.sellinglaptops.service.order.IOrderService;
import com.example.sellinglaptops.service.status.IStatusService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private IOrderService iOrderService;
    @Autowired
    private IAccountService iAccountService;
    @Autowired
    private ICartService iCartService;
    @Autowired
    private IStatusService iStatusService;

    @GetMapping("/{idAccount}/{idStatus}")
    private ResponseEntity<List<Order>> getAllByIdAccount(@PathVariable long idAccount, @PathVariable long idStatus) {
        Optional<Account> account = iAccountService.findById(idAccount);
        Optional<Status> status = iStatusService.findById(idStatus);
        List<Order> orders = iOrderService.findAllByAccountAndStatus(account.get(),status.get());
        if (orders.isEmpty()) {
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
           return new ResponseEntity<>(orders, HttpStatus.OK);
        }
    }

    @PostMapping()
    private ResponseEntity<Order> createOrder(@RequestBody OrderDTO orderDTO) {
        LocalDateTime localDateTime = LocalDateTime.now();
        List<Cart> cartList = orderDTO.getListCart();
        Optional<Status> status = iStatusService.findById(orderDTO.getIdStatus());
        for (Cart carts: cartList
             ) {
            Order order = new Order(orderDTO.getComment(),orderDTO.getDiscountCode(),carts.getQuantity(),status.get(),localDateTime,localDateTime,carts.getIdAccount(),carts.getIdLaptop());
            iOrderService.save(order);
            iCartService.remove(carts.getId());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{idOrder}/{idStatus}")
    public ResponseEntity<Order> editStatus(@PathVariable long idOrder, @PathVariable long idStatus) {
        Optional<Order> optionalOrder = iOrderService.findById(idOrder);
        Optional<Status> optionalStatus = iStatusService.findById(idStatus);

        if (!optionalOrder.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Đơn hàng không tìm thấy
        }

        if (!optionalStatus.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Trạng thái không tìm thấy
        }

        Order order = optionalOrder.get();
        Status status = optionalStatus.get();
        order.setStatus(status);
        iOrderService.save(order); // Lưu đơn hàng đã cập nhật nếu cần

        return new ResponseEntity<>(order, HttpStatus.OK);
    }


}

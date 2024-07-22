package com.example.sellinglaptops.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "carts")
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "laptops_id")
    private Laptop idLaptop;
    @ManyToOne
    @JoinColumn(name = "accounts_id")
    private Account idAccount;

    public Cart() {
    }

    public Cart(long id,int quantity , Laptop idLaptop, Account idAccount) {
        this.quantity = quantity;
        this.id = id;
        this.idLaptop = idLaptop;
        this.idAccount = idAccount;
    }

    public Cart(int quantity, Laptop idLaptop, Account idAccount) {
        this.quantity = quantity;
        this.idLaptop = idLaptop;
        this.idAccount = idAccount;

    }
}

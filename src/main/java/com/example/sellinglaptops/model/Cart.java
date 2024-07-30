package com.example.sellinglaptops.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "carts")
@EntityListeners(AuditingEntityListener.class)
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

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Cart() {
    }

    public Cart(int quantity, Laptop idLaptop, Account idAccount, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.quantity = quantity;
        this.idLaptop = idLaptop;
        this.idAccount = idAccount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Cart(long id, int quantity, Laptop idLaptop, Account idAccount, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.quantity = quantity;
        this.idLaptop = idLaptop;
        this.idAccount = idAccount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}

package com.example.sellinglaptops.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.print.attribute.standard.MediaSize;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "orders")
@EntityListeners(AuditingEntityListener.class)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String comment;
    private String discountCode;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "carts_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "accounts_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "laptops_id")
    private Laptop laptop;


    public Order() {
    }

    public Order( String comment, String discountCode, LocalDateTime createdAt, LocalDateTime updatedAt, Account account, Laptop laptop) {
        this.comment = comment;
        this.discountCode = discountCode;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.account = account;
        this.laptop = laptop;
    }

    public Order(String comment, String discountCode, int quantity, Status status, LocalDateTime createdAt, LocalDateTime updatedAt, Account account, Laptop laptop) {
        this.comment = comment;
        this.discountCode = discountCode;
        this.quantity = quantity;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.account = account;
        this.laptop = laptop;
    }

    public Order(String comment, String discountCode, LocalDateTime createdAt, LocalDateTime updatedAt, Cart cart) {
        this.comment = comment;
        this.discountCode = discountCode;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.cart = cart;
    }

    public Order(long id, String comment, String discountCode, LocalDateTime createdAt, LocalDateTime updatedAt, Cart cart) {
        this.id = id;
        this.comment = comment;
        this.discountCode = discountCode;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.cart = cart;
    }
}

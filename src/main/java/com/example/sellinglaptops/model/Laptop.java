package com.example.sellinglaptops.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "laptops")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String cpu;
    private String ram;
    private String display;// màn hình
    private String appearance;// ngoại hình
    private double price;
    private int quantity;
    private String image;

    @JoinColumn(name = "category_id")
    @ManyToOne
    private Category idCategory;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Laptop() {
    }

    public Laptop(String name, String cpu, String ram, String display, String appearance, double price, int quantity, Category idCategory, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.display = display;
        this.appearance = appearance;
        this.price = price;
        this.quantity = quantity;
        this.idCategory = idCategory;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Laptop(long id, String name, String cpu, String ram, String display, String appearance, double price, int quantity, Category idCategory, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.display = display;
        this.appearance = appearance;
        this.price = price;
        this.quantity = quantity;
        this.idCategory = idCategory;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}

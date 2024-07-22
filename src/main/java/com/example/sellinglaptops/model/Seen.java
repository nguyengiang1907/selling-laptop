package com.example.sellinglaptops.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "seens")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Seen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "laptops_id")
    private Laptop laptop;
    @ManyToOne
    @JoinColumn(name = "accounts_id")
    private Account account;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Seen() {
    }

    public Seen(Laptop laptop, Account account, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.laptop = laptop;
        this.account = account;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Seen(long id, Laptop laptop, Account account, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.laptop = laptop;
        this.account = account;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}

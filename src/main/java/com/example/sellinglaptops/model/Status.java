package com.example.sellinglaptops.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "status")
@Getter
@Setter
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public Status() {
    }

    public Status(long id, String name) {
        this.id = id;
        this.name = name;
    }
}

package com.example.sellinglaptops.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "images")
@Getter
@Setter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nameImage;
    @ManyToOne
    @JoinColumn(name = "laptops_id")
    private Laptop idLaptop;
}

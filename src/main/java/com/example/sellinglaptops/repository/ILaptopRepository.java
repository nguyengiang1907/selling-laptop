package com.example.sellinglaptops.repository;

import com.example.sellinglaptops.model.Category;
import com.example.sellinglaptops.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILaptopRepository extends JpaRepository<Laptop,Long> {
    List<Laptop> findAllByIdCategory(Category category);
}

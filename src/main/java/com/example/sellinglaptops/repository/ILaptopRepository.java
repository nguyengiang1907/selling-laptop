package com.example.sellinglaptops.repository;

import com.example.sellinglaptops.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILaptopRepository extends JpaRepository<Laptop,Long> {
}

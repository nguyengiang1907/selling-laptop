package com.example.sellinglaptops.service.laptop;

import com.example.sellinglaptops.model.Laptop;
import com.example.sellinglaptops.repository.ILaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class LaptopService implements ILaptopService {

    @Autowired
    private ILaptopRepository iLaptopRepository;

    @Override
    public Iterable<Laptop> findAll() {
        return iLaptopRepository.findAll();
    }

    @Override
    public Optional<Laptop> findById(long id) {
        return iLaptopRepository.findById(id);
    }

    @Override
    public Laptop save(Laptop laptop) {
        return iLaptopRepository.save(laptop);
    }

    @Override
    public void remove(long id) {
        iLaptopRepository.deleteById(id);
    }
}

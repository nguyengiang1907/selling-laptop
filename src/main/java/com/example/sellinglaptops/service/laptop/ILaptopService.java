package com.example.sellinglaptops.service.laptop;

import com.example.sellinglaptops.model.Category;
import com.example.sellinglaptops.model.Laptop;
import com.example.sellinglaptops.service.IGenerateService;

import java.util.List;

public interface ILaptopService extends IGenerateService<Laptop> {
    List<Laptop> findAllByIdCategory(Category category);
}

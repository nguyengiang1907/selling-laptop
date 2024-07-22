package com.example.sellinglaptops.service.category;

import com.example.sellinglaptops.model.Category;
import com.example.sellinglaptops.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryRepository iCategoryRepository;
    @Override
    public Iterable<Category> findAll() {
        return iCategoryRepository.findAll() ;
    }

    @Override
    public Optional<Category> findById(long id) {
        return iCategoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return iCategoryRepository.save(category);
    }

    @Override
    public void remove(long id) {
        iCategoryRepository.deleteById(id);
    }
}

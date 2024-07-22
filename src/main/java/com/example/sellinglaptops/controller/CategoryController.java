package com.example.sellinglaptops.controller;

import com.example.sellinglaptops.model.Category;
import com.example.sellinglaptops.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;
    @GetMapping()
    private ResponseEntity<List<Category>> getCategory() {
        List<Category> categoryList = (List<Category>) iCategoryService.findAll();
        if (categoryList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(categoryList);
        }
    }
}

package com.example.demo.controller;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

 // controllers
@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public Category createCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.createCategory(categoryDTO);
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
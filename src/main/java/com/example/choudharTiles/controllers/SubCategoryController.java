package com.example.choudharTiles.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.choudharTiles.entity.SubCategory;
import com.example.choudharTiles.repository.SubCategoryRepository;

@RestController
@RequestMapping("/api/subcategories")
@CrossOrigin(origins = "*") // Allow frontend requests
public class SubCategoryController {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @GetMapping
    public List<SubCategory> getAll() {
        return subCategoryRepository.findAll();
    }

    @GetMapping("/category/{categoryId}")
    public List<SubCategory> getByCategory(@PathVariable Long categoryId) {
        return subCategoryRepository.findByCategoryId(categoryId);
    }

    @PostMapping
    public SubCategory save(@RequestBody SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        subCategoryRepository.deleteById(id);
    }
}

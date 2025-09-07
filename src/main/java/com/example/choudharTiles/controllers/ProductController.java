package com.example.choudharTiles.controllers;

import com.example.choudharTiles.entity.Product;
import com.example.choudharTiles.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*") // Allow Angular

public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/add", consumes = { "multipart/form-data" })
    public ResponseEntity<Product> addProduct(
            @RequestParam("code") String code,
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("size") String size,
            @RequestParam("price") Double price,
            @RequestParam("stockQuantity") Integer stockQuantity,
            @RequestParam("category") Long category,
            @RequestParam("vendorId") Long vendorId,
            @RequestParam("status") Boolean status

    ) throws IOException {
        Product saved = productService.saveProduct(code, name, description, size,
                price, stockQuantity, category, vendorId, status);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}

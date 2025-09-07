package com.example.choudharTiles.controllers;

import com.example.choudharTiles.entity.Stock;
import com.example.choudharTiles.entity.Product;
import com.example.choudharTiles.entity.Category;
import com.example.choudharTiles.repository.ProductRepository;
import com.example.choudharTiles.repository.CategoryRepository;
import com.example.choudharTiles.service.StockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
@CrossOrigin(origins = "*")
public class StockController {

    private final StockService stockService;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public StockController(StockService stockService, ProductRepository productRepository,
            CategoryRepository categoryRepository) {
        this.stockService = stockService;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    // ✅ Get stock by product
    @GetMapping("/product/{productId}")
    public List<Stock> getStockByProduct(@PathVariable Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));
        return stockService.getStockByProduct(product);
    }

    // ✅ Get stock by category
    @GetMapping("/category/{categoryId}")
    public List<Stock> getStockByCategory(@PathVariable Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + categoryId));
        return stockService.getStockByCategory(category);
    }

    // ✅ Get stock by size
    @GetMapping("/size/{size}")
    public List<Stock> getStockBySize(@PathVariable String size) {
        return stockService.getStockBySize(size);
    }

    // ✅ Get stock by type
    @GetMapping("/type/{type}")
    public List<Stock> getStockByType(@PathVariable String type) {
        return stockService.getStockByType(type);
    }
}

package com.example.choudharTiles.service;

import com.example.choudharTiles.entity.Product;
import com.example.choudharTiles.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(String code, String name, String description, String size,
            Double price, Integer stockQuantity, Long category,
            Long vendorId, Boolean status) throws IOException {

        Product product = new Product();
        product.setCode(code);
        product.setName(name);
        product.setDescription(description);
        product.setSize(size);
        product.setPrice(price);
        product.setStockQuantity(stockQuantity);
        product.setCategory(category);
        product.setVendorId(vendorId);
        product.setStatus(status);

        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

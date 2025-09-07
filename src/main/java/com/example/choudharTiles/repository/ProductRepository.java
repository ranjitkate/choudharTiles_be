package com.example.choudharTiles.repository;

import com.example.choudharTiles.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

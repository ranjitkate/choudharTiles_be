package com.example.choudharTiles.repository;

import com.example.choudharTiles.entity.Stock;
import com.example.choudharTiles.entity.Product;
import com.example.choudharTiles.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    // Find stock row by product + size + type
    Optional<Stock> findByProductAndSizeAndType(Product product, String size, String type);

    // Reports
    List<Stock> findByCategory(Category category);

    List<Stock> findByProduct(Product product);

    List<Stock> findBySize(String size);

    List<Stock> findByType(String type);
}

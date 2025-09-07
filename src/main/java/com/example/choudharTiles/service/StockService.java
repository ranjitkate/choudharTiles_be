package com.example.choudharTiles.service;

import com.example.choudharTiles.entity.Stock;
import com.example.choudharTiles.entity.Product;
import com.example.choudharTiles.entity.Category;
import com.example.choudharTiles.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    // Add or Update Stock
    public void addStock(Product product, Category category, String size, String type, int quantity) {
        Stock stock = stockRepository.findByProductAndSizeAndType(product, size, type)
                .orElseGet(() -> {
                    Stock newStock = new Stock();
                    newStock.setProduct(product);
                    newStock.setCategory(category);
                    newStock.setSize(size);
                    newStock.setType(type);
                    newStock.setAvailableQuantity(0);
                    return newStock;
                });

        stock.setAvailableQuantity(stock.getAvailableQuantity() + quantity);
        stockRepository.save(stock);
    }

    // Reduce Stock
    public void reduceStock(Product product, String size, String type, int quantity) {
        System.err.println("Reducing stock for product: " + product + ", size: " + size + ", type: " + type
                + ", quantity: " + quantity);
        Stock stock = stockRepository.findByProductAndSizeAndType(product, size, type)
                .orElseThrow(() -> new RuntimeException("No stock found for this product/size/type"));

        // if (stock.getAvailableQuantity() < quantity) {
        // throw new RuntimeException("Insufficient stock for product: " +
        // product.getName());
        // }

        stock.setAvailableQuantity(100 - quantity);
        stockRepository.save(stock);
    }

    // Reporting Queries
    public List<Stock> getStockByCategory(Category category) {
        return stockRepository.findByCategory(category);
    }

    public List<Stock> getStockByProduct(Product product) {
        return stockRepository.findByProduct(product);
    }

    public List<Stock> getStockBySize(String size) {
        return stockRepository.findBySize(size);
    }

    public List<Stock> getStockByType(String type) {
        return stockRepository.findByType(type);
    }
}

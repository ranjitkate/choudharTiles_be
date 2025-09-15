package com.example.choudharTiles.service;

import com.example.choudharTiles.entity.PurchaseItem;
import com.example.choudharTiles.entity.SellOrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // ✅ Increase stock after purchase
    public void increaseStock(PurchaseItem item) {
        String checkSql = "SELECT COUNT(*) FROM stock WHERE product_id = ? AND size = ?";
        Integer count = jdbcTemplate.queryForObject(checkSql, Integer.class, item.getProduct(), item.getSize());

        if (count != null && count > 0) {
            // Update existing stock
            String updateSql = "UPDATE stock SET quantity = quantity + ?, updated_at = now() WHERE product_id = ? AND size = ?";
            jdbcTemplate.update(updateSql, item.getQuantity(), item.getProduct(), item.getSize());
        } else {
            // Insert new stock record
            String insertSql = "INSERT INTO stock (product_id, size, quantity, category_id) VALUES (?, ?, ?,?)";
            jdbcTemplate.update(insertSql, item.getProduct(), item.getSize(), item.getQuantity(), item.getCategory());
        }
    }

    // ✅ Decrease stock after sell
    public void decreaseStock(SellOrderItem item) {
        String updateSql = "UPDATE stock SET quantity = quantity - ?, updated_at = now() WHERE product_id = ? AND size = ?";
        jdbcTemplate.update(updateSql, item.getQuantity(), item.getProduct(), item.getSize());
    }
}

package com.example.choudharTiles.controllers;

import com.example.choudharTiles.bean.StockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
@CrossOrigin(origins = "*") // allow Angular frontend
public class StockController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 🔹 Get all stock records
    @GetMapping
    public List<StockBean> getAllStock() {
        String sql = "SELECT s.id, stock_code AS stockCode, p.name AS productId, p.size, quantity, s.type, " +
                "c.name AS categoryId, weight, created_at AS createdAt, updated_at AS updatedAt " +
                "FROM stock s join products p on s.product_id = p.id join categories c on s.category_id = c.id ORDER BY id DESC";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StockBean.class));
    }

    // 🔹 Get stock by ID
    @GetMapping("/{id}")
    public StockBean getStockById(@PathVariable Long id) {
        String sql = "SELECT s.id, stock_code AS stockCode, p.name AS productId, p.size, quantity, s.type, " +
                "c.name AS categoryId, weight, created_at AS createdAt, updated_at AS updatedAt" +
                "FROM stock s join products p on s.product_id = p.id join categories c on s.category_id = c.id WHERE p.id = ?";

        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(StockBean.class), id);
    }
}

package com.example.choudharTiles.controllers;

import com.example.choudharTiles.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
public class SellOrderItemControllerSP {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/api/sell-order-items-sp")
    @CrossOrigin(origins = "*") // allow Angular frontend
    public List<SellOrderItemBean> getSellOrderItems() {
        String sql = "SELECT * FROM get_sell_order_items()";

        return jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> mapRow(rs));
    }

    private SellOrderItemBean mapRow(ResultSet rs) throws SQLException {
        SellOrderItemBean bean = new SellOrderItemBean();
        bean.setItemId(rs.getLong("item_id"));
        bean.setProduct(rs.getString("product"));
        bean.setSize(rs.getString("size"));
        bean.setQuantity(rs.getInt("quantity"));
        bean.setPrice(rs.getDouble("price"));
        bean.setTotal(rs.getDouble("total"));
        bean.setOrderDate(rs.getTimestamp("order_date"));
        bean.setDeliveryDate(rs.getTimestamp("delivery_date"));
        bean.setCustomerName(rs.getString("customer_name"));
        bean.setCustomerPhone(rs.getString("customer_phone"));
        return bean;
    }
}

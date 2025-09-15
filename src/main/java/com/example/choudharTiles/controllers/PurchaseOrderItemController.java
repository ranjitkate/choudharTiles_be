package com.example.choudharTiles.controllers;

import com.example.choudharTiles.bean.PurchaseOrderItemBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
public class PurchaseOrderItemController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/api/purchase-order-items-sp")
    @CrossOrigin(origins = "*") // allow Angular frontend
    public List<PurchaseOrderItemBean> getAllPurchaseOrderItems() {
        String sql = "SELECT * FROM get_purchase_order_items()";
        return jdbcTemplate.query(sql, new RowMapper<PurchaseOrderItemBean>() {
            @Override
            public PurchaseOrderItemBean mapRow(ResultSet rs, int rowNum) throws SQLException {
                PurchaseOrderItemBean bean = new PurchaseOrderItemBean();
                bean.setOrderId(rs.getLong("order_id"));
                bean.setDeliveryDate(rs.getTimestamp("delivery_date"));
                bean.setOrderDate(rs.getTimestamp("order_date"));
                bean.setVendorName(rs.getString("vendor_name"));
                bean.setCategoryName(rs.getString("category_name"));
                bean.setProductName(rs.getString("product_name"));
                bean.setQuantity(rs.getInt("quantity"));
                bean.setSize(rs.getString("size"));
                bean.setType(rs.getString("type"));
                bean.setPrice(rs.getDouble("price"));
                bean.setTotal(rs.getDouble("total"));
                return bean;
            }
        });
    }
}

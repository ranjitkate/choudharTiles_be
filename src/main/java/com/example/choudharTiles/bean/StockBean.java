package com.example.choudharTiles.bean;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class StockBean {
    private Long id;
    private String stockCode;
    private String productId;
    private String size;
    private Integer quantity;
    private String type;
    private String categoryId;
    private String weight;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}

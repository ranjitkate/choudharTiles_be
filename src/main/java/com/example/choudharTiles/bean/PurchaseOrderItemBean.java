package com.example.choudharTiles.bean;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class PurchaseOrderItemBean {
    private Long orderId;
    private Timestamp deliveryDate;
    private Timestamp orderDate;
    private String vendorName;
    private String categoryName;
    private String productName;
    private Integer quantity;
    private String size;
    private String type;
    private Double price;
    private Double total;
}

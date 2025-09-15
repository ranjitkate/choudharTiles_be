package com.example.choudharTiles.bean;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class SellOrderItemBean {
    private Long itemId;
    private String product;
    private String size;
    private Integer quantity;
    private Double price;
    private Double total;
    private Timestamp orderDate;
    private Timestamp deliveryDate;
    private String customerName;
    private String customerPhone;

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public Timestamp getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Timestamp deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

}

package com.example.choudharTiles.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "purchase_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long category;
    private Long product;

    private String size;

    private Integer quantity;
    private Double price;
    private Double total;
    private String type;
    private String details;

    // 👇 this is the missing part
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_order_id")
    private PurchaseOrder purchaseOrder;

}

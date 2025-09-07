package com.example.choudharTiles.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "purchase_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vendorName;
    private String vendorPhone;
    private String vendorAddress;

    private Double totalAmount;

    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;

    @OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PurchaseItem> items;

    public void setItems(List<PurchaseItem> items) {
        this.items = items;
        if (items != null) {
            items.forEach(i -> i.setPurchaseOrder(this));
        }
    }
}

package com.example.choudharTiles.controllers;

import com.example.choudharTiles.entity.PurchaseOrder;
import com.example.choudharTiles.service.PurchaseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/purchase-orders")
@CrossOrigin(origins = "*")
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public PurchaseOrder createPurchase(@RequestBody PurchaseOrder purchase) {
        return purchaseService.createOrder(purchase);
    }
}

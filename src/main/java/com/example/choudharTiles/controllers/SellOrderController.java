package com.example.choudharTiles.controllers;

import com.example.choudharTiles.entity.SellOrder;
import com.example.choudharTiles.service.SellOrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sell-orders")
@CrossOrigin(origins = "*") // allow Angular frontend
public class SellOrderController {

    private final SellOrderService service;

    public SellOrderController(SellOrderService service) {
        this.service = service;
    }

    @PostMapping
    public SellOrder createOrder(@RequestBody SellOrder order) {
        return service.createOrder(order);
    }
}

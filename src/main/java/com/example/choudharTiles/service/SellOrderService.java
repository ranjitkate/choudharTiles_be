package com.example.choudharTiles.service;

import com.example.choudharTiles.entity.SellOrder;
import com.example.choudharTiles.repository.SellOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class SellOrderService {

    private final SellOrderRepository repository;

    public SellOrderService(SellOrderRepository repository) {
        this.repository = repository;
    }

    public SellOrder createOrder(SellOrder order) {
        // automatically cascade save SellOrderItem
        return repository.save(order);
    }
}

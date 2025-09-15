package com.example.choudharTiles.service;

import com.example.choudharTiles.entity.SellOrder;
import com.example.choudharTiles.entity.SellOrderItem;
import com.example.choudharTiles.repository.SellOrderRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SellOrderService {

    private final SellOrderRepository repository;
    private final StockService stockService;

    // public SellOrderService(SellOrderRepository repository) {
    // this.repository = repository;
    // }
    @Transactional
    public SellOrder createOrder(SellOrder order) {
        // return repository.save(order);
        SellOrder savedOrder = repository.save(order);

        // Update stock for each item
        for (SellOrderItem item : savedOrder.getItems()) {
            stockService.decreaseStock(item);
        }

        return savedOrder;
    }
}

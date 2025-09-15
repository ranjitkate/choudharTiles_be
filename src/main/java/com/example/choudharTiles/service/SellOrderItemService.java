package com.example.choudharTiles.service;

import com.example.choudharTiles.repository.SellOrderItemRepository;
import com.example.choudharTiles.entity.SellOrderItem;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SellOrderItemService {
    private final SellOrderItemRepository repository;

    public SellOrderItemService(SellOrderItemRepository repository) {
        this.repository = repository;
    }

    public List<SellOrderItem> getAllItems() {
        return repository.findAll();
    }
}

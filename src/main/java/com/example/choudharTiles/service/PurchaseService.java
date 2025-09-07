package com.example.choudharTiles.service;

import com.example.choudharTiles.entity.PurchaseOrder;
import com.example.choudharTiles.repository.PurchaseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PurchaseService {
    private final PurchaseRepository purchaseOrderRepository;

    @Transactional
    public PurchaseOrder createOrder(PurchaseOrder order) {

        return purchaseOrderRepository.save(order);
    }
}

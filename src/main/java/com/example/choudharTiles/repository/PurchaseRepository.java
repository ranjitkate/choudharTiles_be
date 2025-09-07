package com.example.choudharTiles.repository;

import com.example.choudharTiles.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<PurchaseOrder, Long> {
}

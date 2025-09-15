package com.example.choudharTiles.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.choudharTiles.dto.SellOrderItemDTO;

import com.example.choudharTiles.service.SellOrderItemService;

@RestController
@RequestMapping("/api/sell-order-items")
@CrossOrigin(origins = "*")
public class SellOrderItemController {

    private final SellOrderItemService service;

    public SellOrderItemController(SellOrderItemService service) {
        this.service = service;
    }

    @GetMapping
    public List<SellOrderItemDTO> getAllItems() {
        return service.getAllItems()
                .stream()
                .map(item -> {
                    SellOrderItemDTO dto = new SellOrderItemDTO();
                    dto.setId(item.getId());
                    dto.setSize(item.getSize());
                    dto.setQuantity(item.getQuantity());
                    dto.setPrice(item.getPrice());
                    dto.setTotal(item.getTotal());
                    // dto.setOrderDate(item.getOrderDate());
                    // dto.setDeliveryDate(item.getDeliveryDate());
                    // dto.setCustomerName(item.getSellOrder().getCustomerName());
                    return dto;
                }).collect(Collectors.toList());
    }

}
package com.example.choudharTiles.controllers;

import com.example.choudharTiles.entity.Size;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.choudharTiles.repository.SizeRepository;

@RestController
@RequestMapping("/api/size")
@CrossOrigin(origins = "*") // Allow frontend requests
public class SizeController {

    @Autowired
    private SizeRepository sizeRepository;

    @GetMapping
    public List<Size> getAll() {
        return sizeRepository.findAll();
    }

    @GetMapping("/size/{sizeId}")
    public List<Size> getByCategory(@PathVariable Long sizeId) {
        return sizeRepository.findByCategoryId(sizeId);
    }

    @PostMapping
    public Size save(@RequestBody Size size) {
        return sizeRepository.save(size);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        sizeRepository.deleteById(id);
    }
}

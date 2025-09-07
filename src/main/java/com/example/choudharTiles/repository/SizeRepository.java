package com.example.choudharTiles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.choudharTiles.entity.Size;

public interface SizeRepository extends JpaRepository<Size, Long> {
    List<Size> findByCategoryId(Long categoryId);
}
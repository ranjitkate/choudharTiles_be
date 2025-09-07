package com.example.choudharTiles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.choudharTiles.entity.SubCategory;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    List<SubCategory> findByCategoryId(Long categoryId);
}

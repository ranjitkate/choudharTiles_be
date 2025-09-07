package com.example.choudharTiles.repository;

import com.example.choudharTiles.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

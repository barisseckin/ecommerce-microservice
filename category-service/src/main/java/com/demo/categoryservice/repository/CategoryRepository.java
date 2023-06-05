package com.demo.categoryservice.repository;

import com.demo.categoryservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsCategoryByName(String name);
    Optional<Category> findCategoryByUuid(String uuid);
    Optional<Category> findCategoryByName(String name);
}

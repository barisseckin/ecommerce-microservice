package com.demo.categoryservice.controller;

import com.demo.categoryservice.CategoryService;
import com.demo.categoryservice.dto.CategoryDto;
import com.demo.categoryservice.dto.request.CreateCategoryRequest;
import com.demo.categoryservice.model.Category;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDto> save(@Valid @RequestBody CreateCategoryRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoryService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam("uuid") String uuid) {
        categoryService.delete(uuid);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Category> getByName(@RequestParam("name") String name) {
        return ResponseEntity
                .ok(categoryService.getByName(name));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoryDto>> getAll(@RequestParam("page") int page, @RequestParam("size") int size) {
        return ResponseEntity
                .ok(categoryService.getAll(page, size));
    }
}

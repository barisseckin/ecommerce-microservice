package com.demo.categoryservice;

import com.demo.categoryservice.dto.CategoryDto;
import com.demo.categoryservice.dto.converter.CategoryConverter;
import com.demo.categoryservice.dto.request.CreateCategoryRequest;
import com.demo.categoryservice.exception.GenericException;
import com.demo.categoryservice.model.Category;
import com.demo.categoryservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryConverter categoryConverter;

    public CategoryDto save(CreateCategoryRequest request) {
        if (categoryRepository.existsCategoryByName(request.name())) {
            throw new GenericException("category name exist, name: " + request.name(), HttpStatus.CONFLICT);
        }

        Category saved = new Category(
                request.name()
        );
        categoryRepository.save(saved);
        return categoryConverter.toDto(saved);
    }

    public void delete(String uuid) {
        Category fromDb = getByUuid(uuid);
        categoryRepository.deleteById(fromDb.getId());
    }

    public Category getByName(String name) {
        return categoryRepository.findCategoryByName(name)
                .orElseThrow(() -> new GenericException("category not found, name: " + name, HttpStatus.NOT_FOUND));
    }

    public List<CategoryDto> getAll(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return categoryRepository.findAll(pageable)
                .stream()
                .map(categoryConverter::toDto)
                .toList();
    }

    private Category getByUuid(String uuid) {
        return categoryRepository.findCategoryByUuid(uuid)
                .orElseThrow(() -> new GenericException("category not found, uuid: " + uuid, HttpStatus.NOT_FOUND));
    }
}

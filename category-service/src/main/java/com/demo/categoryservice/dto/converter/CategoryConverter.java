package com.demo.categoryservice.dto.converter;

import com.demo.categoryservice.dto.CategoryDto;
import com.demo.categoryservice.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {

    public CategoryDto toDto(Category from) {
        return new CategoryDto(
                from.getName(),
                from.getUuid(),
                from.getCreateDate(),
                from.getUpdateDate()
        );
    }
}

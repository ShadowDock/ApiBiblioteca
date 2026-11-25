package com.practiceTaks.ApiBiblioteca.dtos.mapper;

import com.practiceTaks.ApiBiblioteca.domain.Category;
import com.practiceTaks.ApiBiblioteca.dtos.request.CategoryRequest;
import com.practiceTaks.ApiBiblioteca.dtos.response.CategoryResponse;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.name());
        return category;
    }

    public CategoryResponse toResponse(Category category) {
        return new  CategoryResponse(
                category.getId(),
                category.getName()
        );
    }

    public void update(Category category, CategoryRequest categoryRequest) {
        category.setName(categoryRequest.name());
    }
}

package com.practiceTaks.ApiBiblioteca.service;


import com.practiceTaks.ApiBiblioteca.domain.Category;
import com.practiceTaks.ApiBiblioteca.dtos.mapper.CategoryMapper;
import com.practiceTaks.ApiBiblioteca.dtos.request.CategoryRequest;
import com.practiceTaks.ApiBiblioteca.dtos.response.CategoryResponse;
import com.practiceTaks.ApiBiblioteca.exception.ResourceNotFoundException;
import com.practiceTaks.ApiBiblioteca.repository.CategoryRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    public List<CategoryResponse> findAll() {
        // Transforma cada category em um response
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toResponse) // Com lambda (category -> categoryMapper.toResponse(category))
                .toList();
    }

    public CategoryResponse findById(Long id) {
        Category category = findCategoryOrThrow(id);
        return categoryMapper.toResponse(category);
    }

    @Transactional
    public CategoryResponse create(CategoryRequest categoryRequest) {
        Category category = categoryMapper.toEntity(categoryRequest);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toResponse(savedCategory);
    }

    @Transactional
    public CategoryResponse update(Long id, CategoryRequest categoryRequest) {
        Category category = findCategoryOrThrow(id);
        categoryMapper.update(category, categoryRequest);
        return categoryMapper.toResponse(category);
    }

    @Transactional
    public void delete(Long id) {
        Category category = findCategoryOrThrow(id);
        categoryRepository.delete(category);
    }

    private Category findCategoryOrThrow(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category " + id + "not found"));
    }
}

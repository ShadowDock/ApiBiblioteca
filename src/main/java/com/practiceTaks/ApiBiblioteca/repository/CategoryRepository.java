package com.practiceTaks.ApiBiblioteca.repository;

import com.practiceTaks.ApiBiblioteca.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

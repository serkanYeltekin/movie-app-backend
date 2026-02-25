package com.serkan.movieapp.dataAccess.abstracts;

import com.serkan.movieapp.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    boolean existsByCategoryName(String name); // spring jpa keywords
}

package com.serkan.movieapp.business.rules;

import com.serkan.movieapp.core.utilities.exceptions.BusinessException;
import com.serkan.movieapp.dataAccess.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CategoryBusinessRules {
    private CategoryRepository categoryRepository;

    public void chechIfCategoryNameExists(String categoryName) {
        if(this.categoryRepository.existsByCategoryName(categoryName)) {
            throw new BusinessException("Category with name " + categoryName + " already exists");
        }
    }
}

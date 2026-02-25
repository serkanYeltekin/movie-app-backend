package com.serkan.movieapp.business.abstracts;

import com.serkan.movieapp.business.requests.CreateCategoryRequest;
import com.serkan.movieapp.business.requests.UpdateCategoryRequest;
import com.serkan.movieapp.business.responses.GetAllCategoriesResponse;
import com.serkan.movieapp.business.responses.GetByIdCategoryResponse;
import com.serkan.movieapp.entities.concretes.Category;

import java.util.List;

public interface CategoryService {
    List<GetAllCategoriesResponse> getAll();
    GetByIdCategoryResponse getById(int id);
    void add(CreateCategoryRequest createCategoryRequest);
    void update(UpdateCategoryRequest updateCategoryRequest);
    void delete(int id);
}

package com.serkan.movieapp.business.concretes;

import com.serkan.movieapp.business.abstracts.CategoryService;
import com.serkan.movieapp.business.requests.CreateCategoryRequest;
import com.serkan.movieapp.business.requests.UpdateCategoryRequest;
import com.serkan.movieapp.business.responses.GetAllCategoriesResponse;
import com.serkan.movieapp.business.responses.GetByIdCategoryResponse;
import com.serkan.movieapp.business.rules.CategoryBusinessRules;
import com.serkan.movieapp.core.utilities.mappers.ModelMapperService;
import com.serkan.movieapp.dataAccess.abstracts.CategoryRepository;
import com.serkan.movieapp.entities.concretes.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service // bu sınıf bir business nesnesidir
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private CategoryRepository categoryRepository;
    private ModelMapperService modelMapperService;
    private CategoryBusinessRules categoryBusinessRules;

    @Override
    public List<GetAllCategoriesResponse> getAll() {

        List<Category> categories = categoryRepository.findAll();

        List<GetAllCategoriesResponse> categoriesResponse = categories.stream()
                .map(category -> this.modelMapperService.forResponse()
                        .map(category, GetAllCategoriesResponse.class)).collect(Collectors.toList());


        // iş kuralları buraya gelecek.
        return categoriesResponse;
    }

    @Override
    public GetByIdCategoryResponse getById(int id) {
        Category category = this.categoryRepository.findById(id).orElseThrow();

        GetByIdCategoryResponse response = this.modelMapperService.forResponse().map(category, GetByIdCategoryResponse.class);
        return response;
    }

    @Override
    public void add(CreateCategoryRequest createCategoryRequest) {

        this.categoryBusinessRules.chechIfCategoryNameExists(createCategoryRequest.getCategoryName()); // business rule

        Category category = this.modelMapperService.forRequest().map(createCategoryRequest, Category.class);

        this.categoryRepository.save(category);
    }

    @Override
    public void update(UpdateCategoryRequest updateCategoryRequest) {
        Category category = this.modelMapperService.forRequest().map(updateCategoryRequest, Category.class);
        this.categoryRepository.save(category);
    }

    @Override
    public void delete(int id) {
        this.categoryRepository.deleteById(id);
    }
}

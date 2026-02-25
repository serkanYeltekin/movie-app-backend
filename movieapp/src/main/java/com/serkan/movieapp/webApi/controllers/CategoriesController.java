package com.serkan.movieapp.webApi.controllers;

import com.serkan.movieapp.business.abstracts.CategoryService;
import com.serkan.movieapp.business.requests.CreateCategoryRequest;
import com.serkan.movieapp.business.requests.UpdateCategoryRequest;
import com.serkan.movieapp.business.responses.GetAllCategoriesResponse;
import com.serkan.movieapp.business.responses.GetByIdCategoryResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoriesController {

    private CategoryService categoryService;

    @GetMapping
    public List<GetAllCategoriesResponse> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdCategoryResponse getById(@PathVariable int id) {
        return categoryService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code =  HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateCategoryRequest createCategoryRequest) {
        categoryService.add(createCategoryRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateCategoryRequest updateCategoryRequest) {
        this.categoryService.update(updateCategoryRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.categoryService.delete(id);
    }
}

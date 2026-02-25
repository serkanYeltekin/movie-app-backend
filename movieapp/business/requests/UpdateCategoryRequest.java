package com.serkan.movieapp.business.requests;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryRequest {

    @NotNull
    private int id;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 20)
    private String categoryName;
}

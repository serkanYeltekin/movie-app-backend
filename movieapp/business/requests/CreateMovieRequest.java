package com.serkan.movieapp.business.requests;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMovieRequest {

    @NotNull
    @NotBlank
    @Size(min = 2, max = 20)
    private String name;

    @Min(1)
    @Max(10)
    @NotNull
    private int imdb;

    @NotNull
    private int directorId;

    @NotNull
    private int categoryId;
}

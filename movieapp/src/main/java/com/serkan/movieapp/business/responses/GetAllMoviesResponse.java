package com.serkan.movieapp.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllMoviesResponse {
    private int id;
    private double imdb;
    private String movieName;
    private String categoryName;
    private String directorNameSurname;
}

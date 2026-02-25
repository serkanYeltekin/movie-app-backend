package com.serkan.movieapp.business.abstracts;

import com.serkan.movieapp.business.requests.CreateMovieRequest;
import com.serkan.movieapp.business.requests.UpdateMovieRequest;
import com.serkan.movieapp.business.responses.GetAllMoviesResponse;

import java.util.List;

public interface MovieService {
    List<GetAllMoviesResponse> getAll();
    void add(CreateMovieRequest createMovieRequest);
    void update(UpdateMovieRequest updateMovieRequest);
}

package com.serkan.movieapp.webApi.controllers;

import com.serkan.movieapp.business.abstracts.MovieService;
import com.serkan.movieapp.business.requests.CreateMovieRequest;
import com.serkan.movieapp.business.requests.UpdateMovieRequest;
import com.serkan.movieapp.business.responses.GetAllMoviesResponse;
import com.serkan.movieapp.dataAccess.abstracts.MovieRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@AllArgsConstructor
public class MoviesController {
    private MovieService movieService;


    @GetMapping
    public List<GetAllMoviesResponse> getAll() {
        return movieService.getAll();
    }

    @PostMapping
    @ResponseStatus(code =  HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateMovieRequest createMovieRequest) {
        movieService.add(createMovieRequest);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateMovieRequest updateMovieRequest) {
        this.movieService.update(updateMovieRequest);
    }
}

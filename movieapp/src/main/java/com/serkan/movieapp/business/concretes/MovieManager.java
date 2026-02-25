package com.serkan.movieapp.business.concretes;

import com.serkan.movieapp.business.abstracts.CategoryService;
import com.serkan.movieapp.business.abstracts.MovieService;
import com.serkan.movieapp.business.requests.CreateMovieRequest;
import com.serkan.movieapp.business.requests.UpdateMovieRequest;
import com.serkan.movieapp.business.responses.GetAllMoviesResponse;
import com.serkan.movieapp.core.utilities.mappers.ModelMapperService;
import com.serkan.movieapp.dataAccess.abstracts.MovieRepository;
import com.serkan.movieapp.entities.concretes.Movie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieManager implements MovieService {

    private MovieRepository movieRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllMoviesResponse> getAll() {
          List<Movie> movies  = movieRepository.findAll();

          List<GetAllMoviesResponse> moviesResponse = movies.stream()
                  .map(movie -> this.modelMapperService.forResponse()
                          .map(movie, GetAllMoviesResponse.class)).collect(Collectors.toList());
          return moviesResponse;
    }

    @Override
    public void add(CreateMovieRequest createMovieRequest) {
        Movie movie = modelMapperService.forRequest().map(createMovieRequest, Movie.class);

        this.movieRepository.save(movie);
    }

    @Override
    public void update(UpdateMovieRequest updateMovieRequest) {
        Movie movie = modelMapperService.forRequest().map(updateMovieRequest, Movie.class);
        this.movieRepository.save(movie);
    }
}

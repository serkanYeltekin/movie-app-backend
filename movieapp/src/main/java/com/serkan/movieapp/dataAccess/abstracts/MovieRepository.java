package com.serkan.movieapp.dataAccess.abstracts;

import com.serkan.movieapp.entities.concretes.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}

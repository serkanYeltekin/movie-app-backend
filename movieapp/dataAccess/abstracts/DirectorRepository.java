package com.serkan.movieapp.dataAccess.abstracts;

import com.serkan.movieapp.entities.concretes.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Integer> {
}

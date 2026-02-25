package com.serkan.movieapp.business.abstracts;

import com.serkan.movieapp.business.requests.CreateDirectorRequest;
import com.serkan.movieapp.business.responses.GetAllDirectorsResponse;
import com.serkan.movieapp.entities.concretes.Director;

import java.util.List;

public interface DirectorService {
    List<GetAllDirectorsResponse> getAll();
    void add(CreateDirectorRequest createDirectorRequest);
}

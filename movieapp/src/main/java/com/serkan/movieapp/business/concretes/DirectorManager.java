package com.serkan.movieapp.business.concretes;

import com.serkan.movieapp.business.abstracts.DirectorService;
import com.serkan.movieapp.business.requests.CreateDirectorRequest;
import com.serkan.movieapp.business.responses.GetAllCategoriesResponse;
import com.serkan.movieapp.business.responses.GetAllDirectorsResponse;
import com.serkan.movieapp.core.utilities.mappers.ModelMapperService;
import com.serkan.movieapp.dataAccess.abstracts.DirectorRepository;
import com.serkan.movieapp.entities.concretes.Director;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DirectorManager implements DirectorService {

    DirectorRepository directorRepository;
    ModelMapperService modelMapperService;


    @Override
    public List<GetAllDirectorsResponse> getAll() {
        List<Director> directors = directorRepository.findAll();

        List<GetAllDirectorsResponse> DirectorResponse = directors.stream()
                .map(director -> this.modelMapperService.forResponse()
                        .map(director, GetAllDirectorsResponse.class)).collect(Collectors.toList());

        return DirectorResponse;
    }

    @Override
    public void add(CreateDirectorRequest createDirectorRequest) {
        Director director = modelMapperService.forRequest().map(createDirectorRequest, Director.class);

        this.directorRepository.save(director);
    }
}

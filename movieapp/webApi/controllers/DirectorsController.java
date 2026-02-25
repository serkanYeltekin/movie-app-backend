package com.serkan.movieapp.webApi.controllers;

import com.serkan.movieapp.business.abstracts.DirectorService;
import com.serkan.movieapp.business.requests.CreateDirectorRequest;
import com.serkan.movieapp.business.responses.GetAllDirectorsResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/directors")
@AllArgsConstructor
public class DirectorsController {

    private DirectorService directorService;

    @GetMapping
    public List<GetAllDirectorsResponse> getAll() {
        return directorService.getAll();
    }

    @PutMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateDirectorRequest createDirectorRequest){
        directorService.add(createDirectorRequest);
    }



}

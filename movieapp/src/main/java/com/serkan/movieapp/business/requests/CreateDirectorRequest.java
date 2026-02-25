package com.serkan.movieapp.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDirectorRequest {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 23)
    private String nameSurname;

}

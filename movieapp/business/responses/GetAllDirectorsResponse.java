package com.serkan.movieapp.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllDirectorsResponse {

    private int id;
    private String nameSurname;
}

package com.serkan.movieapp.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "directors") //
@Getter
@Setter
@AllArgsConstructor // parametreli constructer oluşturur
@NoArgsConstructor
@Entity
public class Director {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id'yi otomatik arttırır
    @Column(name = "id")
    private int id;

    @Column(name = "director_name_surname")
    private String directorNameSurname;

    @OneToMany(mappedBy = "director")
    private List<Movie> movies;

}

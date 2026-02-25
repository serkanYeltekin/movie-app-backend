package com.serkan.movieapp.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "categories") //
@Getter
@Setter
@AllArgsConstructor // parametreli constructer oluşturur
@NoArgsConstructor
@Entity
public class Category {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id'yi otomatik arttırır
    @Column(name = "id")
    private int id;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Movie> movies;
}

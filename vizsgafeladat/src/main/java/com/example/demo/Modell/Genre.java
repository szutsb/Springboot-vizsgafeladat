package com.example.demo.Modell;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genre_generator")
    @SequenceGenerator(name = "genre_generator", sequenceName = "genre_seq")
    private Long genreID;

    @Column(name = "genreName", nullable = false)
    @Size(min = 1, max = 50)
    private String genreName;
}

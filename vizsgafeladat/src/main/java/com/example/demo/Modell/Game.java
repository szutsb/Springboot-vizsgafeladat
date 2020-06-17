package com.example.demo.Modell;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_generator")
    @SequenceGenerator(name = "game_generator", sequenceName = "game_seq")
    private Long gameID;

    @Column(name = "gameTitle", nullable = false)
    @Size(min = 1, max = 100)
    private String gameTitle;

    @Column(name = "publisher", nullable = false)
    @Size(min = 1, max = 50)
    private String publisher;

    @Column(name = "esrbRating", nullable = false)
    private String esrbRating;

    @Column(name = "releaseDate", nullable = false)
    private Date releaseDate;

    public String getEsrbRating() {
        return esrbRating;
    }
}

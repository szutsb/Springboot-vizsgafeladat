package com.example.demo.Service;

import com.example.demo.Modell.Genre;
import com.example.demo.Repository.GenreRepository;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) { this.genreRepository = genreRepository;}

    public Genre createGenre(Genre g) { return genreRepository.save(g); }

    public List<Genre> getAllGenres() { return (List<Genre>) genreRepository.findAll(); }

    public Genre getGenreById(Long genreID){
        Optional<Genre> oGenre = genreRepository.findById(genreID);

        if(oGenre.isPresent()){
            return oGenre.get();
        }
        else {
            throw new NoResultException("Nincs ilyen műfaj");
        }

    }

    public Genre updateGenre(Genre g){ return genreRepository.save(g); }

    public void deleteGenre(Long genreID) { genreRepository.deleteById(genreID); }
}

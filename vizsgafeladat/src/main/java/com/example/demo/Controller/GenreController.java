package com.example.demo.Controller;

import com.example.demo.Modell.Genre;
import com.example.demo.Service.GenreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService) { this.genreService = genreService; }

    @PostMapping( path = "/addGenre")
    public Genre createGenre(@RequestBody Genre g) { return genreService.createGenre(g); }

    @GetMapping( path = "/getAllGenres")
    public List<Genre> getAllGenres() { return genreService.getAllGenres(); }

    @RequestMapping( method = RequestMethod.GET, value = "/getGenre/{id}")
    public Genre getGenreById(@PathVariable("id") Long genreID) { return genreService.getGenreById(genreID); }

    @PostMapping( path = "/updateGenre")
    public Genre updateGenre(@RequestBody Genre g) { return genreService.updateGenre(g); }

    @RequestMapping( method = RequestMethod.DELETE, value = "/deleteGenre/{id}")
    public void deleteGenre(@PathVariable("id") Long genreID) { genreService.deleteGenre(genreID); }
}

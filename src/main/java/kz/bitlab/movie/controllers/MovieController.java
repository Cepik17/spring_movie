package kz.bitlab.movie.controllers;

import kz.bitlab.movie.dtos.MovieCreate;
import kz.bitlab.movie.dtos.MovieUpdate;
import kz.bitlab.movie.dtos.MovieView;
import kz.bitlab.movie.models.Movie;
import kz.bitlab.movie.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public MovieView addMovie(@RequestBody MovieCreate movieCreate){
        return movieService.addMovie(movieCreate);
    }

    @GetMapping
    public List<MovieView> getMovies(){
        return movieService.getMovies();
    }

    @GetMapping("{id}")
    public MovieView getMovie(@PathVariable Long id){
        return movieService.getMovieById(id);
    }

    @PutMapping
    public MovieView editMovie(@RequestBody MovieUpdate movieUpdate){
        return movieService.editMovie(movieUpdate);
    }

    @DeleteMapping("{id}")
    public List<MovieView> deleteMovie(@PathVariable Long id){
        return movieService.deleteMovie(id);
    }
}

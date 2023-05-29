package kz.bitlab.movie.services;

import kz.bitlab.movie.dtos.MovieCreate;
import kz.bitlab.movie.dtos.MovieUpdate;
import kz.bitlab.movie.dtos.MovieView;
import kz.bitlab.movie.mappers.MovieMapper;
import kz.bitlab.movie.models.Movie;
import kz.bitlab.movie.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieView addMovie(MovieCreate movieCreate){
        Movie movie = MovieMapper.INSTANCE.toEntity(movieCreate);
        return MovieMapper.INSTANCE.toView(movieRepository.save(movie));
    }

    public List<MovieView> getMovies(){
        return MovieMapper.INSTANCE.toViewList(movieRepository.findAll());
    }

    public MovieView getMovieById(Long id){
        return MovieMapper.INSTANCE.toView(movieRepository.findById(id).orElseThrow());
    }

    public MovieView editMovie(MovieUpdate movieUpdate){
        Movie movie =MovieMapper.INSTANCE.toEntity(movieUpdate);
        return MovieMapper.INSTANCE.toView(movieRepository.save(movie));
    }

    public List<MovieView> deleteMovie(Long id){
        movieRepository.deleteById(id);
        return getMovies();
    }
}

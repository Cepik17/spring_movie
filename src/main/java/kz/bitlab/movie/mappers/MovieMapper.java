package kz.bitlab.movie.mappers;

import kz.bitlab.movie.dtos.MovieCreate;
import kz.bitlab.movie.dtos.MovieUpdate;
import kz.bitlab.movie.dtos.MovieView;
import kz.bitlab.movie.models.Movie;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(builder = @Builder(disableBuilder = true))
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    Movie toEntity(MovieCreate dto);
    Movie toEntity(MovieUpdate dto);

    MovieView toView(Movie movie);

    List<MovieView> toViewList(List<Movie> movies);

}

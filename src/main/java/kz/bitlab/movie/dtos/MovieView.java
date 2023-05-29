package kz.bitlab.movie.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieView {

    private Long id;
    private String name;
    private String description;
    private double rating;
    private int amountView;

}

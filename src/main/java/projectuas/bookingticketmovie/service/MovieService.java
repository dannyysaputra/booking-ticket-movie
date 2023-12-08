package projectuas.bookingticketmovie.service;

import projectuas.bookingticketmovie.data.entity.Movie;

import java.util.List;

public interface MovieService {
    // create operation
    Movie saveMovie(Movie movie);
    // read operation
    List<Movie> fetchMovieList();
    // delete operation
    Movie updateMovie(Movie movie, Long movieId);
    // delete operation
    void deleteMovieById(Long movieId);
}

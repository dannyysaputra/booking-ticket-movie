package projectuas.bookingticketmovie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import projectuas.bookingticketmovie.data.entity.Movie;
import projectuas.bookingticketmovie.data.repository.MovieRepository;
import projectuas.bookingticketmovie.service.MovieService;

import java.util.List;
import java.util.Optional;

public class MovieServiceImpl {
    @Autowired
    private MovieRepository movieRepository;

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> fetchMovieList() {
        return (List<Movie>) movieRepository.findAll();
    }
}

package projectuas.bookingticketmovie.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import projectuas.bookingticketmovie.data.entity.Movie;
import projectuas.bookingticketmovie.data.repository.MovieRepository;

@Controller
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    // handler method to handle homepage request
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("movies", movieRepository.findAll());
        return "index";
    }

    // handler method to handle movie details request
    @GetMapping("/movie-details")
    public String movieDetails() {
        return "movie-details";
    }

    @PostMapping("/add-movie")
    public String createMovie(@Valid Movie movie, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "failed";
        }

        movieRepository.save(movie);
        return "success";
    }
}

package projectuas.bookingticketmovie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovieController {

    @GetMapping("/movie-details")
    public String movieDetails() {
        return "movie-details";
    }

    // handler method to handle homepage request
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}

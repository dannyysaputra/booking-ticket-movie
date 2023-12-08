package projectuas.bookingticketmovie.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private String movieName;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer durationInMinute;

    @Column(nullable = false)
    private String trailerLink;

    @Column(nullable = false)
    private String moviePosterUrl;

    @Column(nullable = false)
    private String movieBackdropUrl;

    @Column(nullable = false)
    private String movieTags;

    @Column(nullable = false)
    private ArrayList<String> genres;

    public Movie(String movieName, String description, Integer durationInMinute, String trailerLink, String moviePosterUrl, String movieBackdropUrl, String movieTags, ArrayList<String> genres) {
        this.movieName = movieName;
        this.description = description;
        this.durationInMinute = durationInMinute;
        this.trailerLink = trailerLink;
        this.moviePosterUrl = moviePosterUrl;
        this.movieBackdropUrl = movieBackdropUrl;
        this.movieTags = movieTags;
        this.genres = genres;
    }
}

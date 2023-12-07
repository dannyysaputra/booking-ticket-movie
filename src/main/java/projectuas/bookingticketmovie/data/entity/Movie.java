package projectuas.bookingticketmovie.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MOVIE")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private String movieName;

    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private String moviePosterUrl;

    @Column(nullable = false)
    private String movieTags;
}

package projectuas.bookingticketmovie.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectuas.bookingticketmovie.data.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}

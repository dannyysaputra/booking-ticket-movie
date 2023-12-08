package projectuas.bookingticketmovie.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectuas.bookingticketmovie.data.entity.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {
}

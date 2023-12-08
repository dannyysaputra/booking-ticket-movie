package projectuas.bookingticketmovie.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectuas.bookingticketmovie.data.entity.Auditorium;

public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {
}

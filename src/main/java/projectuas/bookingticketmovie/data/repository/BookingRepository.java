package projectuas.bookingticketmovie.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectuas.bookingticketmovie.data.entity.Auditorium;

public interface BookingRepository extends JpaRepository<Auditorium, Long> {
}

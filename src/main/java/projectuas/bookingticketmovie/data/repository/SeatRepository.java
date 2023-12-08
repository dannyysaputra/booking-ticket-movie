package projectuas.bookingticketmovie.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectuas.bookingticketmovie.data.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}

package projectuas.bookingticketmovie.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectuas.bookingticketmovie.data.entity.SeatBooked;

public interface SeatBookedRepository extends JpaRepository<SeatBooked, Long> {
}

package projectuas.bookingticketmovie.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectuas.bookingticketmovie.data.entity.Screening;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {
}

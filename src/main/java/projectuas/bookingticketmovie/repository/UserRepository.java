package projectuas.bookingticketmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectuas.bookingticketmovie.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

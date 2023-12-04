package projectuas.bookingticketmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectuas.bookingticketmovie.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

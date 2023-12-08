package projectuas.bookingticketmovie.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectuas.bookingticketmovie.data.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

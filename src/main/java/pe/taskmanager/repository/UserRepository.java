package pe.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.taskmanager.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

package pl.dominisz.springintroduction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dominisz.springintroduction.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

  boolean existsById(Long id);
}

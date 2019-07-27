package pl.dominisz.springintroduction.repository;

import pl.dominisz.springintroduction.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
  User save(User user);

  Optional<User> findById(long id);

  List<User> findAll();

  boolean existsById(long id);
}

package pl.dominisz.springintroduction.repository;

import org.springframework.stereotype.Repository;
import pl.dominisz.springintroduction.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

  private List<User> users = new ArrayList<>();
  private long index = 1;

  @Override
  public User save(User user) {
    users.add(user);
    user.setId(index);
    index++;
    return user;
  }

  @Override
  public Optional<User> findById(long id) {
    return users.stream().filter(user -> user.getId() == id).findFirst();
  }

  @Override
  public List<User> findAll() {
    return users;
  }

  @Override
  public boolean existsById(long id) {
    return users.stream().anyMatch(user -> user.getId() == id);
  }
}

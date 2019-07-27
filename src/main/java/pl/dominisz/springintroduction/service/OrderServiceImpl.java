package pl.dominisz.springintroduction.service;

import org.springframework.stereotype.Service;
import pl.dominisz.springintroduction.exception.EntityNotFoundException;
import pl.dominisz.springintroduction.model.Order;
import pl.dominisz.springintroduction.model.User;
import pl.dominisz.springintroduction.repository.OrderRepository;
import pl.dominisz.springintroduction.repository.UserRepository;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;
  private final UserRepository userRepository;

  public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository) {
    this.orderRepository = orderRepository;
    this.userRepository = userRepository;
  }

  @Override
  public Order createOrderForUser(long id, Order order) {
    Optional<User> optionalUser = userRepository.findById(id);
    User user =
        optionalUser.orElseThrow(
            () -> new EntityNotFoundException("User with id " + id + " not found"));
    order.setUser(user);
    return orderRepository.save(order);
  }

  @Override
  public Order createOrderWithoutUser(Order order) {
    return null;
  }
}

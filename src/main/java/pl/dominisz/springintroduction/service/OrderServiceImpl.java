package pl.dominisz.springintroduction.service;

import org.springframework.stereotype.Service;
import pl.dominisz.springintroduction.exception.EntityNotFoundException;
import pl.dominisz.springintroduction.model.CreateOrderDto;
import pl.dominisz.springintroduction.model.Order;
import pl.dominisz.springintroduction.model.OrderDto;
import pl.dominisz.springintroduction.model.User;
import pl.dominisz.springintroduction.repository.OrderRepository;
import pl.dominisz.springintroduction.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;
  private final UserRepository userRepository;

  public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository) {
    this.orderRepository = orderRepository;
    this.userRepository = userRepository;
  }

  @Override
  public OrderDto createOrderForUser(long id, CreateOrderDto createOrderDto) {
    Optional<User> optionalUser = userRepository.findById(id);
    User user =
        optionalUser.orElseThrow(
            () -> new EntityNotFoundException("User with id " + id + " not found"));
    Order order = new Order();
    order.setDescription(createOrderDto.getDescription());
    order.setAmount(createOrderDto.getAmount());
    order.setUser(user);
    return convert(orderRepository.save(order));
  }

  private OrderDto convert(Order order) {
    OrderDto dto = new OrderDto();
    dto.setId(order.getId());
    dto.setDescription(order.getDescription());
    dto.setAmount(order.getAmount());
    return dto;
  }

  @Override
  public OrderDto createOrderWithoutUser(CreateOrderDto order) {
    return null;
  }

  @Override
  public List<OrderDto> findOrdersForUser(long id) {
    if (!userRepository.existsById(id)) {
      throw new EntityNotFoundException("User with id " + id + " not found");
    }
    return convert(orderRepository.findByUserId(id));
  }

  private List<OrderDto> convert(List<Order> orders) {
    return orders.stream().map(order -> convert(order)).collect(Collectors.toList());
  }
}

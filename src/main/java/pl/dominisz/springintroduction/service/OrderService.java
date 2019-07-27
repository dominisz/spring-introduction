package pl.dominisz.springintroduction.service;

import pl.dominisz.springintroduction.model.Order;

import java.util.List;

public interface OrderService {
  Order createOrderForUser(long id, Order order);

  Order createOrderWithoutUser(Order order);

  List<Order> findOrdersForUser(long id);
}

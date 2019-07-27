package pl.dominisz.springintroduction.service;

import pl.dominisz.springintroduction.model.CreateOrderDto;
import pl.dominisz.springintroduction.model.Order;
import pl.dominisz.springintroduction.model.OrderDto;

import java.util.List;

public interface OrderService {
  OrderDto createOrderForUser(long id, CreateOrderDto order);

  OrderDto createOrderWithoutUser(CreateOrderDto order);

  List<OrderDto> findOrdersForUser(long id);
}

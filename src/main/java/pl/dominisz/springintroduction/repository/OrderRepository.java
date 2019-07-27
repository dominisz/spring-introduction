package pl.dominisz.springintroduction.repository;

import pl.dominisz.springintroduction.model.Order;

import java.util.List;

public interface OrderRepository {

  Order save(Order order);

  List<Order> findByUserId(long id);
}

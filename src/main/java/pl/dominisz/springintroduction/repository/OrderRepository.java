package pl.dominisz.springintroduction.repository;

import pl.dominisz.springintroduction.model.Order;

public interface OrderRepository {

    Order save(Order order);
}

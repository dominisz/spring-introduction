package pl.dominisz.springintroduction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dominisz.springintroduction.model.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

  List<Order> findByUserId(Long id);
}

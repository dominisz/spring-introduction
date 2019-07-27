package pl.dominisz.springintroduction.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dominisz.springintroduction.model.Order;
import pl.dominisz.springintroduction.service.OrderService;

import java.util.List;

@RestController
public class OrderController {

  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping("/users/{id}/orders")
  public ResponseEntity<Order> createOrderForUser(@PathVariable long id, @RequestBody Order order) {
    return ResponseEntity.ok(orderService.createOrderForUser(id, order));
  }

  @PostMapping("/orders")
  public ResponseEntity<Order> createOrderWithoutUser(@RequestBody Order order) {
    return ResponseEntity.ok(orderService.createOrderWithoutUser(order));
  }

  @GetMapping("/users/{id}/orders")
  public ResponseEntity<List<Order>> findOrdersForUser(@PathVariable long id) {
    return ResponseEntity.ok(orderService.findOrdersForUser(id));
  }
}

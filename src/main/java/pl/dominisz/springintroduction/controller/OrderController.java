package pl.dominisz.springintroduction.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dominisz.springintroduction.model.CreateOrderDto;
import pl.dominisz.springintroduction.model.Order;
import pl.dominisz.springintroduction.model.OrderDto;
import pl.dominisz.springintroduction.service.OrderService;

import java.util.List;

@RestController
public class OrderController {

  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping("/users/{id}/orders")
  public ResponseEntity<OrderDto> createOrderForUser(
      @PathVariable long id, @RequestBody CreateOrderDto createOrderDto) {
    return ResponseEntity.ok(orderService.createOrderForUser(id, createOrderDto));
  }

  @PostMapping("/orders")
  public ResponseEntity<OrderDto> createOrderWithoutUser(@RequestBody CreateOrderDto createOrderDto) {
    return ResponseEntity.ok(orderService.createOrderWithoutUser(createOrderDto));
  }

  @GetMapping("/users/{id}/orders")
  public ResponseEntity<List<OrderDto>> findOrdersForUser(@PathVariable long id) {
    return ResponseEntity.ok(orderService.findOrdersForUser(id));
  }
}

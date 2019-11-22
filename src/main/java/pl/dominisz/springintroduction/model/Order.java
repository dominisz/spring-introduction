package pl.dominisz.springintroduction.model;

import java.util.List;
import java.util.UUID;

public class Order {

  private UUID id;
  private UUID userId;
  private String description;
  private List<OrderItem> orderItems;
}

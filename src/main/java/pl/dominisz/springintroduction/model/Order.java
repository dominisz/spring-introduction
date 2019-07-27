package pl.dominisz.springintroduction.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {

  private long id;
  private String description;
  private BigDecimal amount;
  private User user;
}

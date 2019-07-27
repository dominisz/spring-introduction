package pl.dominisz.springintroduction.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateOrderDto {

  private String description;
  private BigDecimal amount;
}

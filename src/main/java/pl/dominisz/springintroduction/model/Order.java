package pl.dominisz.springintroduction.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

  @Id
  @GeneratedValue
  private Long id;

  private String description;
  private BigDecimal amount;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
}

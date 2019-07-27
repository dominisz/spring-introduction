package pl.dominisz.springintroduction.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

  @Id @GeneratedValue private Long id;
  private String firstName;
  private String lastName;
  private String address;
  private String email;
  private String password;
  @Embedded private CreditCard creditCard;
  @OneToMany(mappedBy = "user")
  private List<Order> orders;
}

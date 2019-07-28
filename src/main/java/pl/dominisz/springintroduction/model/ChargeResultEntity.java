package pl.dominisz.springintroduction.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
public class ChargeResultEntity {

  @Id
  @GeneratedValue
  private Long id;
  private boolean exception;
  private boolean successful;
  private String message;
  private LocalDateTime timestamp;

  public ChargeResultEntity() {
    timestamp = LocalDateTime.now();
  }
}

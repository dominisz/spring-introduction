package pl.dominisz.springintroduction.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ReceiptDto {

  private Long id;
  private BigDecimal amount;
  private boolean successful;
  private String message;
}

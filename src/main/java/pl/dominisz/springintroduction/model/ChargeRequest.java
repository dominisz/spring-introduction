package pl.dominisz.springintroduction.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ChargeRequest {

  private String number;
  private String verificationCode;
  private BigDecimal amount;
}

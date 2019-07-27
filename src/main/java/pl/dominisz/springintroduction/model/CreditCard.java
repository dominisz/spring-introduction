package pl.dominisz.springintroduction.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class CreditCard {

  private String number;
  private String holder;
  private String verificationCode;
  private int month;
  private int year;
}

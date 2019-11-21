package pl.dominisz.springintroduction.service;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PayUCreditCardProcessor implements CreditCardProcessor {
  public PayUCreditCardProcessor() {
    System.out.println("PayUCreditCardProcessor created");
  }

  @Override
  public ChargeResult charge(CreditCard creditCard, BigDecimal amount) {
    return new ChargeResult();
  }
}

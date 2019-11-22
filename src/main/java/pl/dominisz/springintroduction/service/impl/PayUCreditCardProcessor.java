package pl.dominisz.springintroduction.service.impl;

import org.springframework.stereotype.Component;
import pl.dominisz.springintroduction.model.ChargeResult;
import pl.dominisz.springintroduction.model.CreditCard;
import pl.dominisz.springintroduction.service.CreditCardProcessor;

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

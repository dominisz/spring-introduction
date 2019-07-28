package pl.dominisz.springintroduction.service;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.dominisz.springintroduction.model.ChargeRequest;
import pl.dominisz.springintroduction.model.ChargeResult;
import pl.dominisz.springintroduction.model.CreditCard;

import java.math.BigDecimal;

@Component
public class PayUCreditCardProcessor implements CreditCardProcessor {

  @Override
  public ChargeResult charge(CreditCard creditCard, BigDecimal amount) {
    RestTemplate restTemplate = new RestTemplate();

    ChargeRequest chargeRequest = new ChargeRequest();
    chargeRequest.setNumber(creditCard.getNumber());
    chargeRequest.setVerificationCode(creditCard.getVerificationCode());
    chargeRequest.setAmount(amount);

    ChargeResult chargeResult =
        restTemplate.postForObject(
            "http://localhost:9090/charges", chargeRequest, ChargeResult.class);

    return chargeResult;
  }
}

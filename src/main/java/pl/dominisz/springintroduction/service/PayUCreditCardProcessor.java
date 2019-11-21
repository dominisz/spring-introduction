package pl.dominisz.springintroduction.service;

import java.math.BigDecimal;

public class PayUCreditCardProcessor implements CreditCardProcessor {
    @Override
    public ChargeResult charge(CreditCard creditCard, BigDecimal amount) {
        return new ChargeResult();
    }
}

package pl.dominisz.springintroduction.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.dominisz.creditcardmodel.ChargeResult;
import pl.dominisz.springintroduction.model.CreditCard;
import pl.dominisz.springintroduction.model.Order;
import pl.dominisz.springintroduction.model.Receipt;

import java.math.BigDecimal;

public class PayUBillingServiceTests {

  @Test
  public void shouldCreateSuccessfulReceipt() {
    Order order = new Order();
    order.setAmount(BigDecimal.TEN);
    CreditCard creditCard = new CreditCard();
    creditCard.setNumber("123456");
    creditCard.setHolder("owner");
    creditCard.setVerificationCode("123");
    creditCard.setMonth(1);
    creditCard.setYear(2020);

    CreditCardProcessor creditCardProcessor = Mockito.mock(CreditCardProcessor.class);
    TransactionLog transactionLog = Mockito.mock(TransactionLog.class);

    Mockito.when(creditCardProcessor.charge(creditCard, order.getAmount()))
        .thenReturn(new ChargeResult(true, ""));

    PayUBillingService payUBillingService =
        new PayUBillingService(creditCardProcessor, transactionLog);

    Receipt receipt = payUBillingService.chargeOrder(order, creditCard);

    Assertions.assertTrue(receipt.isSuccessful());
    Assertions.assertEquals(receipt.getAmount(), BigDecimal.TEN);
  }
}

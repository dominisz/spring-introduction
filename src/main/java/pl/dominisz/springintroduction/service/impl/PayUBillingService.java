package pl.dominisz.springintroduction.service.impl;

import org.springframework.stereotype.Component;
import pl.dominisz.springintroduction.exception.UnreachableException;
import pl.dominisz.springintroduction.model.ChargeResult;
import pl.dominisz.springintroduction.model.CreditCard;
import pl.dominisz.springintroduction.model.Order;
import pl.dominisz.springintroduction.model.Receipt;
import pl.dominisz.springintroduction.service.BillingService;
import pl.dominisz.springintroduction.service.CreditCardProcessor;
import pl.dominisz.springintroduction.service.DiscountCalculator;
import pl.dominisz.springintroduction.service.TransactionLog;

import java.math.BigDecimal;

@Component
public class PayUBillingService implements BillingService {

  private final CreditCardProcessor creditCardProcessor;
  private final DiscountCalculator discountCalculator;
  private final TransactionLog transactionLog;

  public PayUBillingService(
      CreditCardProcessor creditCardProcessor,
      DiscountCalculator discountCalculator,
      TransactionLog transactionLog) {
    this.creditCardProcessor = creditCardProcessor;
    this.discountCalculator = discountCalculator;
    this.transactionLog = transactionLog;
    System.out.println("PayUBillingService created");
  }

  @Override
  public Receipt chargeOrder(Order order, CreditCard creditCard) {
    try {
      BigDecimal discountedAmount = discountCalculator.getDiscount(order);
      ChargeResult result = creditCardProcessor.charge(creditCard, discountedAmount);
      transactionLog.logChargeResult(result);

      return result.isSuccessful()
          ? Receipt.forSuccessfulCharge(discountedAmount)
          : Receipt.forDeclinedCharge(result.getDeclineMessage());
    } catch (UnreachableException exception) {
      transactionLog.logConnectException(exception);
      return Receipt.forSystemFailure(exception.getMessage());
    }
  }
}

package pl.dominisz.springintroduction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PayUBillingService implements BillingService {

  @Autowired private CreditCardProcessor creditCardProcessor;

  @Autowired private DiscountCalculator discountCalculator;

  @Autowired private TransactionLog transactionLog;

  public PayUBillingService() {
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

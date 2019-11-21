package pl.dominisz.springintroduction.service;

import java.math.BigDecimal;

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

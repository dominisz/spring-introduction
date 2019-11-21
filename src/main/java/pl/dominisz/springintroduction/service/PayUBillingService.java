package pl.dominisz.springintroduction.service;

import java.math.BigDecimal;

public class PayUBillingService implements BillingService {

  @Override
  public Receipt chargeOrder(Order order, CreditCard creditCard) {
    CreditCardProcessor creditCardProcessor = new PayUCreditCardProcessor();
    DiscountCalculator discountCalculator = new WeekendDiscountCalculator();
    TransactionLog transactionLog = new DatabaseTransactionLog();

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

package pl.dominisz.springintroduction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PayUBillingService implements BillingService {

  private CreditCardProcessor creditCardProcessor;
  private DiscountCalculator discountCalculator;
  private TransactionLog transactionLog;

  public PayUBillingService() {
    System.out.println("PayUBillingService created");
  }

  @Autowired
  public void setCreditCardProcessor(CreditCardProcessor creditCardProcessor) {
    this.creditCardProcessor = creditCardProcessor;
    System.out.println("CreditCardProcessor injected");
  }

  @Autowired
  public void setDiscountCalculator(DiscountCalculator discountCalculator) {
    this.discountCalculator = discountCalculator;
    System.out.println("DiscountCalculator injected");
  }

  @Autowired
  public void setTransactionLog(TransactionLog transactionLog) {
    this.transactionLog = transactionLog;
    System.out.println("TransactionLog injected");
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

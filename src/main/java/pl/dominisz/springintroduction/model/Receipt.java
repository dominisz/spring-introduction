package pl.dominisz.springintroduction.model;

import java.math.BigDecimal;

public class Receipt {

  private BigDecimal amount;
  private String message;
  private boolean successful;

  private Receipt(BigDecimal amount, String message, boolean successful) {
    this.amount = amount;
    this.message = message;
    this.successful = successful;
  }

  public static Receipt forSuccessfulCharge(BigDecimal amount) {
    return new Receipt(amount, "Successful charge", true);
  }

  public static Receipt forDeclinedCharge(String message) {
    return new Receipt(BigDecimal.ZERO, message, false);
  }

  public static Receipt forSystemFailure(String message) {
    return new Receipt(BigDecimal.ZERO, message, false);
  }
}

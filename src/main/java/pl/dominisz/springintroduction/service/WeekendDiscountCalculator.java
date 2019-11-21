package pl.dominisz.springintroduction.service;

import java.math.BigDecimal;

public class WeekendDiscountCalculator implements DiscountCalculator {
  public WeekendDiscountCalculator() {
    System.out.println("WeekendDiscoutCalculator created");
  }

  @Override
  public BigDecimal getDiscount(Order order) {
    return null;
  }
}

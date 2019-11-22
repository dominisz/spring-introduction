package pl.dominisz.springintroduction.service.impl;

import pl.dominisz.springintroduction.model.Order;
import pl.dominisz.springintroduction.service.DiscountCalculator;

import java.math.BigDecimal;

public class WeekendDiscountCalculator implements DiscountCalculator {
  public WeekendDiscountCalculator() {
    System.out.println("WeekendDiscountCalculator created");
  }

  @Override
  public BigDecimal getDiscount(Order order) {
    return null;
  }
}

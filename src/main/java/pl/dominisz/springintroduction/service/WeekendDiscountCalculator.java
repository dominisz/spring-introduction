package pl.dominisz.springintroduction.service;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class WeekendDiscountCalculator implements DiscountCalculator {
  public WeekendDiscountCalculator() {
    System.out.println("WeekendDiscoutCalculator created");
  }

  @Override
  public BigDecimal getDiscount(Order order) {
    return null;
  }
}

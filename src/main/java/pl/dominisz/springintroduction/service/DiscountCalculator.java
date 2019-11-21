package pl.dominisz.springintroduction.service;

import java.math.BigDecimal;

public interface DiscountCalculator {
    BigDecimal getDiscount(Order order);
}

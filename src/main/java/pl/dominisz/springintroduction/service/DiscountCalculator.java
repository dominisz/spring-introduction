package pl.dominisz.springintroduction.service;

import pl.dominisz.springintroduction.model.Order;

import java.math.BigDecimal;

public interface DiscountCalculator {
    BigDecimal getDiscount(Order order);
}

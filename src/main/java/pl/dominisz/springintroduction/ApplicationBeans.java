package pl.dominisz.springintroduction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.dominisz.springintroduction.service.DiscountCalculator;
import pl.dominisz.springintroduction.service.WeekendDiscountCalculator;

@Configuration
public class ApplicationBeans {

  @Bean
  public DiscountCalculator createDiscountCalculator() {
    System.out.println("ApplicationBeans");
    return new WeekendDiscountCalculator();
  }
}

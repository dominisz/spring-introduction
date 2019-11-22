package pl.dominisz.springintroduction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.dominisz.springintroduction.service.DiscountCalculator;
import pl.dominisz.springintroduction.service.impl.WeekendDiscountCalculator;

@Configuration
public class ApplicationConfiguration {

  @Bean
  public DiscountCalculator createDiscountCalculator() {
    return new WeekendDiscountCalculator();
  }
}

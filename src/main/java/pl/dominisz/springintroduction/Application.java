package pl.dominisz.springintroduction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import pl.dominisz.springintroduction.service.BillingService;
import pl.dominisz.springintroduction.service.CreditCard;
import pl.dominisz.springintroduction.service.Order;
import pl.dominisz.springintroduction.service.Receipt;

@ComponentScan
public class Application {

  public static void main(String[] args) {
    ApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(Application.class);

    BillingService billingService = applicationContext.getBean(BillingService.class);

    Order order = new Order();
    CreditCard creditCard = new CreditCard();

    Receipt receipt = billingService.chargeOrder(order, creditCard);

    System.out.println(receipt);
  }
}

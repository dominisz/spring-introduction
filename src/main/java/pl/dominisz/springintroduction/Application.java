package pl.dominisz.springintroduction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.dominisz.springintroduction.service.*;

public class Application {

  public static void main(String[] args) {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

    BillingService billingService = applicationContext.getBean(BillingService.class);

    Order order = new Order();
    CreditCard creditCard = new CreditCard();

    Receipt receipt = billingService.chargeOrder(order, creditCard);

    System.out.println(receipt);
  }
}

package pl.dominisz.springintroduction;

import pl.dominisz.springintroduction.service.*;

public class Application {

  public static void main(String[] args) {

    BillingService billingService = new PayUBillingService();

    Order order = new Order();
    CreditCard creditCard = new CreditCard();

    Receipt receipt = billingService.chargeOrder(order, creditCard);

    System.out.println(receipt);
  }
}

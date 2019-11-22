package pl.dominisz.springintroduction.service.impl;

import org.springframework.stereotype.Component;
import pl.dominisz.springintroduction.exception.UnreachableException;
import pl.dominisz.springintroduction.model.ChargeResult;
import pl.dominisz.springintroduction.service.TransactionLog;

@Component
public class DatabaseTransactionLog implements TransactionLog {
  public DatabaseTransactionLog() {
    System.out.println("DatabaseTransactionLog created");
  }

  @Override
  public void logChargeResult(ChargeResult result) {}

  @Override
  public void logConnectException(UnreachableException exception) {}
}

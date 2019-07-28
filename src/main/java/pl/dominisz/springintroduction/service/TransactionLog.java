package pl.dominisz.springintroduction.service;

import pl.dominisz.creditcardmodel.ChargeResult;
import pl.dominisz.springintroduction.exception.UnreachableException;

public interface TransactionLog {
    void logChargeResult(ChargeResult result);

    void logConnectException(UnreachableException exception);
}

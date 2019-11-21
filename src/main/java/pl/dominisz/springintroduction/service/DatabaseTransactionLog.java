package pl.dominisz.springintroduction.service;

public class DatabaseTransactionLog implements TransactionLog {
    @Override
    public void logChargeResult(ChargeResult result) {

    }

    @Override
    public void logConnectException(UnreachableException exception) {

    }
}

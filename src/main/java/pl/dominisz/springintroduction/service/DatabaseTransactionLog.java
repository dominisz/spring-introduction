package pl.dominisz.springintroduction.service;

import org.springframework.stereotype.Component;
import pl.dominisz.springintroduction.exception.UnreachableException;
import pl.dominisz.springintroduction.model.ChargeResult;
import pl.dominisz.springintroduction.model.ChargeResultEntity;
import pl.dominisz.springintroduction.repository.ChargeResultEntityRepository;

@Component
public class DatabaseTransactionLog implements TransactionLog {

  private final ChargeResultEntityRepository chargeResultEntityRepository;

  public DatabaseTransactionLog(ChargeResultEntityRepository chargeResultEntityRepository) {
    this.chargeResultEntityRepository = chargeResultEntityRepository;
  }

  @Override
  public void logChargeResult(ChargeResult result) {
    ChargeResultEntity entity = new ChargeResultEntity();
    entity.setException(false);
    entity.setSuccessful(result.isSuccessful());
    entity.setMessage(result.getDeclineMessage());
    chargeResultEntityRepository.save(entity);
  }

  @Override
  public void logConnectException(UnreachableException exception) {
    ChargeResultEntity entity = new ChargeResultEntity();
    entity.setException(true);
    entity.setMessage(exception.getMessage());
    chargeResultEntityRepository.save(entity);
  }
}

package pl.dominisz.springintroduction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dominisz.springintroduction.model.ChargeResultEntity;

public interface ChargeResultEntityRepository extends JpaRepository<ChargeResultEntity, Long> {}

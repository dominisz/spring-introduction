package pl.dominisz.springintroduction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dominisz.springintroduction.model.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {}

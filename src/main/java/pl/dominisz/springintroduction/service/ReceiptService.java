package pl.dominisz.springintroduction.service;

import pl.dominisz.springintroduction.model.CreateReceiptDto;
import pl.dominisz.springintroduction.model.ReceiptDto;

import java.util.List;

public interface ReceiptService {
  List<ReceiptDto> findAll();

  ReceiptDto createReceipt(CreateReceiptDto createReceiptDto);
}

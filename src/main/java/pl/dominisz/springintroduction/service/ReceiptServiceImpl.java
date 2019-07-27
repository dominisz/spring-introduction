package pl.dominisz.springintroduction.service;

import org.springframework.stereotype.Service;
import pl.dominisz.springintroduction.model.CreateReceiptDto;
import pl.dominisz.springintroduction.model.Receipt;
import pl.dominisz.springintroduction.model.ReceiptDto;
import pl.dominisz.springintroduction.repository.ReceiptRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReceiptServiceImpl implements ReceiptService {

  private final BillingService billingService;
  private final ReceiptRepository receiptRepository;

  public ReceiptServiceImpl(BillingService billingService, ReceiptRepository receiptRepository) {
    this.billingService = billingService;
    this.receiptRepository = receiptRepository;
  }

  @Override
  public List<ReceiptDto> findAll() {
    return convert(receiptRepository.findAll());
  }

  private List<ReceiptDto> convert(List<Receipt> receipts) {
    return receipts.stream().map(receipt -> convert(receipt)).collect(Collectors.toList());
  }

  private ReceiptDto convert(Receipt receipt) {
    return null;
  }

  @Override
  public ReceiptDto createReceipt(CreateReceiptDto createReceiptDto) {
    return null;
  }
}

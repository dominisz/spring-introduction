package pl.dominisz.springintroduction.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pl.dominisz.springintroduction.exception.EntityNotFoundException;
import pl.dominisz.springintroduction.model.*;
import pl.dominisz.springintroduction.repository.OrderRepository;
import pl.dominisz.springintroduction.repository.ReceiptRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReceiptServiceImpl implements ReceiptService {

  private final BillingService billingService;
  private final ReceiptRepository receiptRepository;
  private final OrderRepository orderRepository;

  public ReceiptServiceImpl(
      BillingService billingService,
      ReceiptRepository receiptRepository,
      OrderRepository orderRepository) {
    this.billingService = billingService;
    this.receiptRepository = receiptRepository;
    this.orderRepository = orderRepository;
  }

  @Override
  public List<ReceiptDto> findAll() {
    return convert(receiptRepository.findAll());
  }

  private List<ReceiptDto> convert(List<Receipt> receipts) {
    return receipts.stream().map(receipt -> convert(receipt)).collect(Collectors.toList());
  }

  private ReceiptDto convert(Receipt receipt) {
    ReceiptDto dto = new ReceiptDto();
    BeanUtils.copyProperties(receipt, dto);
    return dto;
  }

  @Override
  public ReceiptDto createReceipt(CreateReceiptDto createReceiptDto) {
    Order order =
        orderRepository
            .findById(createReceiptDto.getOrderId())
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        "Order " + createReceiptDto.getOrderId() + "not found"));

    CreditCard creditCard = order.getUser().getCreditCard();

    Receipt receipt = billingService.chargeOrder(order, creditCard);

    return convert(receiptRepository.save(receipt));
  }
}

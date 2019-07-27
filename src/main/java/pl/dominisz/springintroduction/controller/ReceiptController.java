package pl.dominisz.springintroduction.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dominisz.springintroduction.model.CreateReceiptDto;
import pl.dominisz.springintroduction.model.ReceiptDto;
import pl.dominisz.springintroduction.service.ReceiptService;

import java.util.List;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {

    private final ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @GetMapping
    public ResponseEntity<List<ReceiptDto>> findAll() {
        return ResponseEntity.ok(receiptService.findAll());
    }

    @PostMapping
    public ResponseEntity<ReceiptDto> createReceipt(@RequestBody CreateReceiptDto createReceiptDto) {
        return ResponseEntity.ok(receiptService.createReceipt(createReceiptDto));
    }
}

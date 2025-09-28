package com.ryg.financetracker.controller;

import com.ryg.financetracker.model.TransactionDto;
import com.ryg.financetracker.service.FinancesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class FinancesController {

  private final FinancesService financesService;

  public FinancesController(FinancesService financesService) {
    this.financesService = financesService;
  }

  @GetMapping("/transactions")
  public Flux<TransactionDto> getTransactions() {
    return financesService.getAllTransactions();
  }

  @PostMapping("/transaction")
  public Mono<ResponseEntity<String>> addTransaction(@RequestBody TransactionDto dto) {
    return financesService
        .addTransaction(dto)
        .map(this::buildPostResponse)
        .onErrorReturn(
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error"));
  }

  private ResponseEntity<String> buildPostResponse(Boolean success) {
    if (success) {
      return ResponseEntity.status(HttpStatus.CREATED).body("Transaction added successfully");
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to process transaction");
    }
  }
}

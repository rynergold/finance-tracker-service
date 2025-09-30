package com.ryg.financetracker.service;

import com.ryg.financetracker.model.table.Transaction;
import com.ryg.financetracker.model.TransactionDto;
import com.ryg.financetracker.repository.FinancesRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FinancesService {

    private final FinancesRepository financesRepository;
    private final ConversionService conversionService;

    public FinancesService(FinancesRepository financesRepository,
                           ConversionService conversionService) {
        this.financesRepository = financesRepository;
        this.conversionService = conversionService;
    }

    public Flux<TransactionDto> getAllTransactions() {
        return financesRepository.findAll()
            .mapNotNull(transaction -> conversionService.convert(transaction, TransactionDto.class));
    }

    public Mono<Boolean> addTransaction(TransactionDto transactionDto) {
        return Mono.defer(() ->
                Mono.justOrEmpty(conversionService.convert(transactionDto, Transaction.class)))
            .flatMap(financesRepository::save)
            .thenReturn(true)
            .switchIfEmpty(Mono.just(false));
    }

  public Mono<Boolean> updateTransaction(Integer id, TransactionDto dto) {
    return financesRepository.findById(id)
      .flatMap(existingTransaction -> {
        existingTransaction.setTransactionDate(dto.getTransactionDate());
        existingTransaction.setTransactionType(dto.getTransactionType());
        existingTransaction.setCategoryId(dto.getCategoryId());
        existingTransaction.setAmount(dto.getAmount());
        existingTransaction.setDescription(dto.getDescription());

        return financesRepository.save(existingTransaction);
      })
      .map(saved -> true)
      .defaultIfEmpty(false);
  }

    public Mono<Boolean> deleteTransaction(Integer id) {
      return financesRepository.existsById(id)
        .flatMap(exists -> {
          if (exists) {
            return financesRepository.deleteById(id).thenReturn(true);
          } else {
            return Mono.just(false);
          }
        })
        .onErrorReturn(false);
    }
}

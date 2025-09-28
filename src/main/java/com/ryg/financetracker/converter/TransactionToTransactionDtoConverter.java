package com.ryg.financetracker.converter;

import com.ryg.financetracker.model.Transaction;
import com.ryg.financetracker.model.TransactionDto;
import jakarta.validation.constraints.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TransactionToTransactionDtoConverter implements Converter<Transaction, TransactionDto> {

    @Override
    public TransactionDto convert(@NotNull Transaction source) {
        try {
            return new TransactionDto(
                source.getTransactionDate(),
                source.getTransactionType(),
                source.getCategory(),
                source.getAmount(),
                source.getDescription()
            );
        } catch (final IllegalArgumentException exception) {
            return null;
        }
    }
}

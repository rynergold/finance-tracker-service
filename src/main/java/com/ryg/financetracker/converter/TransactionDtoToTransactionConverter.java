package com.ryg.financetracker.converter;

import com.ryg.financetracker.model.table.Transaction;
import com.ryg.financetracker.model.TransactionDto;
import jakarta.validation.constraints.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoToTransactionConverter implements Converter<TransactionDto, Transaction> {

    @Override
    public Transaction convert(@NotNull TransactionDto source) {
        try {
            Transaction transaction = new Transaction();
            transaction.setTransactionDate(source.getTransactionDate());
            transaction.setTransactionType(source.getTransactionType());
            transaction.setCategoryId(source.getCategoryId());
            transaction.setAmount(source.getAmount());
            transaction.setDescription(source.getDescription());
            return transaction;
        } catch (final IllegalArgumentException exception) {
            return null;
        }
    }
}

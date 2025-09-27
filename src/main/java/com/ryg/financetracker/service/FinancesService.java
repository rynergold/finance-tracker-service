package com.ryg.financetracker.service;

import com.ryg.financetracker.model.Finances;
import com.ryg.financetracker.repository.FinancesRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FinancesService {

    private final FinancesRepository financesRepository;

    public FinancesService(FinancesRepository financesRepository) {
        this.financesRepository = financesRepository;
    }

    public Mono<Finances> save(Finances transaction) {
        return financesRepository.save(transaction);
    }
}

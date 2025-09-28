package com.ryg.financetracker.controller;

import com.ryg.financetracker.model.Finances;
import com.ryg.financetracker.service.FinancesService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FinancesController {

    private final FinancesService financesService;
    /* We can't allow anything but
    the accepted object structure for a form enty
     */
    public FinancesController(FinancesService financesService) {
        this.financesService = financesService;
    }


    @PostMapping("/transaction")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Finances> addEntry(@RequestBody Finances transaction){
        return financesService.save(transaction);
    }
}

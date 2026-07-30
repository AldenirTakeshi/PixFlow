package com.takeshi.pixflow.infrastructure.adapters.in.web;

import com.takeshi.pixflow.application.usecase.CreateLedgerEntryUseCase;
import com.takeshi.pixflow.infrastructure.adapters.in.web.dto.CreateEntryRequest;
import com.takeshi.pixflow.infrastructure.adapters.out.repository.LedgerEntryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/v1/accounts")
public class AccountController {

    private final CreateLedgerEntryUseCase createLedgerEntryUseCase;
    private final LedgerEntryRepository ledgerEntryRepository;

    public AccountController(CreateLedgerEntryUseCase createLedgerEntryUseCase, LedgerEntryRepository ledgerEntryRepository) {
        this.createLedgerEntryUseCase = createLedgerEntryUseCase;
        this.ledgerEntryRepository = ledgerEntryRepository;
    }

    @PostMapping("/{id}/entries")
    public ResponseEntity<Void> createEntries(@PathVariable("id") String sourceAccountId, @RequestBody CreateEntryRequest request){
        createLedgerEntryUseCase.execute(sourceAccountId, request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}/balance")
    public ResponseEntity<BigDecimal> getBalance(@PathVariable("id") String accountId){
        BigDecimal balance = ledgerEntryRepository.getBalanceByAccountId(accountId);
        return ResponseEntity.ok(balance);
    }
}

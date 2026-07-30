package com.takeshi.pixflow.application.usecase;

import com.takeshi.pixflow.infrastructure.adapters.in.web.dto.CreateEntryRequest;
import com.takeshi.pixflow.infrastructure.adapters.out.entity.LedgerEntry;
import com.takeshi.pixflow.infrastructure.adapters.out.repository.LedgerEntryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CreateLedgerEntryUseCase {

    private final LedgerEntryRepository ledgerEntryRepository;

    public CreateLedgerEntryUseCase(LedgerEntryRepository ledgerEntryRepository) {
        this.ledgerEntryRepository = ledgerEntryRepository;
    }

    @Transactional
    public void execute(String sourceAccountId, CreateEntryRequest request){
        String transactionId = UUID.randomUUID().toString();

        LedgerEntry debitEntry = new LedgerEntry(
                UUID.randomUUID().toString(),
                sourceAccountId,
                transactionId,
                "DEBIT",
                request.amount()
        );

        LedgerEntry creditEntry = new LedgerEntry(
                UUID.randomUUID().toString(),
                request.destinationAccountId(),
                transactionId,
                "CREDIT",
                request.amount()
        );

        ledgerEntryRepository.save(debitEntry);
        ledgerEntryRepository.save(creditEntry);
    }
}

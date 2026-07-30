package com.takeshi.pixflow.infrastructure.adapters.out.repository;

import com.takeshi.pixflow.infrastructure.adapters.out.entity.LedgerEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface LedgerEntryRepository extends JpaRepository<LedgerEntry, String> {
    @Query(value = """
            SELECT COALESCE(SUM(CASE WHEN entry_type = 'CREDIT' THEN amount ELSE -amount END), 0)
            FROM ledger_entries
            WHERE account_id = :accountId
            """, nativeQuery = true)
    BigDecimal getBalanceByAccountId(@Param("accountId") String accountId);
}

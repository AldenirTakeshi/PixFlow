CREATE TABLE ledger_entries (
                                id             VARCHAR(36)                         NOT NULL,
                                account_id     VARCHAR(36)                         NOT NULL,
                                transaction_id VARCHAR(36)                         NOT NULL,
                                entry_type     VARCHAR(10)                         NOT NULL,
                                amount         DECIMAL(19, 2)                      NOT NULL,
                                created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,

                                CONSTRAINT pk_ledger_entries PRIMARY KEY (id),
                                CONSTRAINT fk_ledger_entries_account FOREIGN KEY (account_id) REFERENCES accounts(id),
                                CONSTRAINT chk_ledger_entries_type CHECK (entry_type IN ('DEBIT', 'CREDIT'))
);

CREATE INDEX idx_ledger_entries_account_id ON ledger_entries(account_id);
CREATE INDEX idx_ledger_entries_transaction_id ON ledger_entries(transaction_id);
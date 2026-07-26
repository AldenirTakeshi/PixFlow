CREATE TABLE accounts (
                          id VARCHAR(36) NOT NULL,
                          account_number VARCHAR(20) NOT NULL,
                          document VARCHAR(14) NOT NULL,
                          status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
                          created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

                          PRIMARY KEY (id),
                          CONSTRAINT uk_accounts_account_number UNIQUE (account_number),
                          CONSTRAINT uk_accounts_document UNIQUE (document)
);
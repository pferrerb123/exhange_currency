CREATE TABLE exchange_rate_transaction (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    source_currency VARCHAR(3) NOT NULL,
    target_currency VARCHAR(3) NOT NULL,
    amount DECIMAL(15, 2) NOT NULL,
    exchanged_amount DECIMAL(15, 2) NOT NULL,
    exchange_rate DECIMAL(10, 6) NOT NULL
);
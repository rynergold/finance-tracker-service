CREATE TABLE finances (
    id SERIAL PRIMARY KEY,
    transaction_date DATE DEFAULT CURRENT_DATE,
    transaction_type transaction_type_enum NOT NULL,
    category VARCHAR(50),
    amount DECIMAL(10,2) NOT NULL CHECK (amount > 0),
    description VARCHAR(255) not null
)
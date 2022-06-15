DROP TABLE IF EXISTS product;

CREATE TABLE product (
    id BIGSERIAL PRIMARY KEY,
    quantity INT NOT NULL,
    name VARCHAR(255) UNIQUE NOT NULL,
    expiry_date DATE NOT NULL
);


INSERT INTO author (name, biography) VALUES ('J.K. Rowling', 'British author, best known for the Harry Potter series.');
INSERT INTO author (name, biography) VALUES ('George R.R. Martin', 'American novelist and short story writer, known for A Song of Ice and Fire.');

INSERT INTO publisher (name, biography, country) VALUES ('Bloomsbury', 'British publishing house.', 'United Kingdom');
INSERT INTO publisher (name, biography, country) VALUES ('Bantam Books', 'American publishing house.', 'United States');

INSERT INTO books (author_id, publisher_id, title, isbn, genre, type, publisher_year, price, quantity) VALUES (1, 1, 'Harry Potter and the Philosophers Stone', '9780747532699', 'Fantasy', 'Hardcover', 1997, 20.00, 100);
INSERT INTO books (author_id, publisher_id, title, isbn, genre, type, publisher_year, price, quantity) VALUES (2, 2, 'A Game of Thrones', '9780553103540', 'Fantasy', 'Hardcover', 1996, 25.00, 50);

INSERT INTO customer (name, email, streetNumber, streetName, postalCode, State, Country, phoneNumber) VALUES ('John Doe', 'john.doe@example.com', 123, 'Main St', '12345', 'California', 'USA', '555-1234');
INSERT INTO customer (name, email, streetNumber, streetName, postalCode, State, Country, phoneNumber) VALUES ('Jane Smith', 'jane.smith@example.com', 456, 'Second St', '67890', 'New York', 'USA', '555-5678');

INSERT INTO carts (customer_id) VALUES (1);
INSERT INTO carts (customer_id) VALUES (2);

INSERT INTO cart_items (book_id, cart_id, quantity) VALUES (1, 1, 2);
INSERT INTO cart_items (book_id, cart_id, quantity) VALUES (2, 2, 1);

INSERT INTO "order" (customer_id, order_date, status, total) VALUES (1, '2024-01-01', 'Shipped', 40.00);
INSERT INTO "order" (customer_id, order_date, status, total) VALUES (2, '2024-01-02', 'Processing', 25.00);

INSERT INTO order_item (order_id, book_id, quantity) VALUES (1, 1, 2);
INSERT INTO order_item (order_id, book_id, quantity) VALUES (2, 2, 1);

INSERT INTO payment (order_id, payment_method, transaction_id, payment_status, payment_date) VALUES (1, 'Credit Card', 'TXN123456', TRUE, '2024-01-01');
INSERT INTO payment (order_id, payment_method, transaction_id, payment_status, payment_date) VALUES (2, 'PayPal', 'TXN789012', TRUE, '2024-01-02');

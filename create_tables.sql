DROP SEQUENCE author_author_id_seq CASCADE;
DROP SEQUENCE publisher_publisher_id_seq CASCADE;
DROP SEQUENCE books_book_id_seq CASCADE;
DROP SEQUENCE customer_customer_id_seq CASCADE;
DROP SEQUENCE cart_cart_id_seq CASCADE;
DROP SEQUENCE cart_item_cart_item_id_seq CASCADE;
DROP SEQUENCE order_order_id_seq CASCADE;
DROP SEQUENCE order_item_order_item_id_seq CASCADE;
DROP SEQUENCE payment_payment_id_seq CASCADE;

DROP TABLE IF EXISTS payment CASCADE;
DROP TABLE IF EXISTS order_item CASCADE;
DROP TABLE IF EXISTS "order" CASCADE;
DROP TABLE IF EXISTS cart_items CASCADE;
DROP TABLE IF EXISTS carts CASCADE;
DROP TABLE IF EXISTS books CASCADE;
DROP TABLE IF EXISTS publisher CASCADE;
DROP TABLE IF EXISTS author CASCADE;
DROP TABLE IF EXISTS customer CASCADE;




CREATE SEQUENCE author_author_id_seq START 1;
CREATE TABLE author (
    author_id bigint  PRIMARY KEY DEFAULT nextval('author_author_id_seq'),
    name VARCHAR(255) NOT NULL,
    biography TEXT
);

CREATE SEQUENCE publisher_publisher_id_seq START 1;
CREATE TABLE publisher (
    publisher_id bigint  PRIMARY KEY DEFAULT nextval('publisher_publisher_id_seq'),
    name VARCHAR(255) NOT NULL,
    biography TEXT,
    country VARCHAR(255) NOT NULL
);

CREATE SEQUENCE books_book_id_seq START 1;
CREATE TABLE books (
    book_id bigint  PRIMARY KEY DEFAULT nextval('books_book_id_seq'),
    author_id bigint  NOT NULL,
    publisher_id bigint  NOT NULL,
    title VARCHAR(255) NOT NULL,
    isbn VARCHAR(255) NOT NULL UNIQUE,
    genre VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    publisher_year bigint  NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    quantity bigint ,
    CONSTRAINT fk_author FOREIGN KEY(author_id) REFERENCES author(author_id) ON DELETE CASCADE,
    CONSTRAINT fk_publisher FOREIGN KEY(publisher_id) REFERENCES publisher(publisher_id) ON DELETE CASCADE
);

CREATE SEQUENCE customer_customer_id_seq START 1;
CREATE TABLE customer (
    customer_id bigint  PRIMARY KEY DEFAULT nextval('customer_customer_id_seq'),
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    streetNumber bigint  NOT NULL,
    streetName VARCHAR(255) NOT NULL,
    postalCode VARCHAR(20) NOT NULL,
    State VARCHAR(255) NOT NULL,
    Country VARCHAR(255) NOT NULL,
    phoneNumber VARCHAR(20) NOT NULL UNIQUE
);

CREATE SEQUENCE cart_cart_id_seq START 1;
CREATE TABLE carts (
    cart_id bigint  PRIMARY KEY DEFAULT nextval('cart_cart_id_seq'),
    customer_id bigint  NOT NULL UNIQUE,
    CONSTRAINT fk_customer FOREIGN KEY(customer_id) REFERENCES customer(customer_id) ON DELETE CASCADE
);

CREATE SEQUENCE cart_item_cart_item_id_seq START 1;
CREATE TABLE cart_items (
    cart_item_id bigint  PRIMARY KEY DEFAULT nextval('cart_item_cart_item_id_seq'),
    book_id bigint  NOT NULL,
    cart_id bigint ,
    quantity bigint  NOT NULL CHECK (quantity > 0),
    CONSTRAINT fk_book FOREIGN KEY(book_id) REFERENCES books(book_id) ON DELETE CASCADE,
    CONSTRAINT fk_cart FOREIGN KEY(cart_id) REFERENCES carts(cart_id) ON DELETE CASCADE
);

CREATE SEQUENCE order_order_id_seq START 1;
CREATE TABLE "order" (
    order_id bigint  PRIMARY KEY DEFAULT nextval('order_order_id_seq'),
    customer_id bigint ,
    order_date TIMESTAMP  NOT NULL,
    status VARCHAR(255) NOT NULL CHECK (status IN ('Processing', 'Shipped', 'Delivered', 'Cancelled')),
    total NUMERIC(10, 2) NOT NULL CHECK (total >= 0),
    CONSTRAINT fk_order_customer FOREIGN KEY(customer_id) REFERENCES customer(customer_id) ON DELETE SET NULL
);

CREATE SEQUENCE order_item_order_item_id_seq START 1;
CREATE TABLE order_item (
    order_item_id bigint  PRIMARY KEY DEFAULT nextval('order_item_order_item_id_seq'),
    order_id bigint ,
    book_id bigint ,
    quantity bigint  NOT NULL CHECK (quantity > 0),
    CONSTRAINT fk_order FOREIGN KEY(order_id) REFERENCES "order"(order_id) ON DELETE CASCADE,
    CONSTRAINT fk_order_book FOREIGN KEY(book_id) REFERENCES books(book_id) ON DELETE CASCADE
);

CREATE SEQUENCE payment_payment_id_seq START 1;
CREATE TABLE payment (
    payment_id bigint  PRIMARY KEY DEFAULT nextval('payment_payment_id_seq'),
    order_id bigint  NOT NULL UNIQUE,
    payment_method VARCHAR(255) NOT NULL,
    transaction_id VARCHAR(255) NOT NULL UNIQUE,
    payment_status BOOLEAN NOT NULL,
    payment_date TIMESTAMP  NOT NULL,
    CONSTRAINT fk_payment_order FOREIGN KEY(order_id) REFERENCES "order"(order_id) ON DELETE CASCADE
);

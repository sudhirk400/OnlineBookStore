CREATE TABLE Book (
    bookID SERIAL PRIMARY KEY,
    AuthorID INT NOT NULL,
    PublisherID INT NOT NULL,
    Title TEXT NOT NULL,
    ISBN TEXT UNIQUE NOT NULL,
    Genre TEXT NOT NULL,
    Type TEXT NOT NULL,
    PublicationYear INT CHECK (PublicationYear > 0),
    Price NUMERIC(10, 2) CHECK (Price >= 0),
    Condition TEXT CHECK (Condition IN ('New', 'Used'))
);

CREATE TABLE Publisher (
    publisherID SERIAL PRIMARY KEY,
    Country TEXT NOT NULL,
    bookID INT UNIQUE NOT NULL REFERENCES Book(bookID) ON DELETE CASCADE
);

CREATE TABLE Author (
    AuthorID SERIAL PRIMARY KEY,
    firstName TEXT NOT NULL,
    lastName TEXT NOT NULL,
    bookID INT UNIQUE NOT NULL REFERENCES Book(bookID) ON DELETE CASCADE
);

CREATE TABLE Inventory (
    bookID INT PRIMARY KEY REFERENCES Book(bookID) ON DELETE CASCADE,
    stockLevelUsed INT CHECK (stockLevelUsed >= 0) DEFAULT 0,
    stockLevelNew INT CHECK (stockLevelNew >= 0) DEFAULT 0
);

CREATE TABLE Customer (
    customerID SERIAL PRIMARY KEY,
    firstName TEXT NOT NULL,
    lastName TEXT NOT NULL,
    streetNumber INT CHECK (streetNumber > 0),
    streetName TEXT NOT NULL,
    postalCode TEXT NOT NULL,
    State TEXT NOT NULL,
    Country TEXT NOT NULL,
    phoneNumber TEXT UNIQUE NOT NULL CHECK (phoneNumber ~ '^\+?[0-9]+$')
);

CREATE TABLE Orders (
    orderID SERIAL PRIMARY KEY,
    customerID INT NOT NULL REFERENCES Customer(customerID) ON DELETE CASCADE,
    orderDate DATE NOT NULL DEFAULT CURRENT_DATE,
    Subtotal NUMERIC(10, 2) CHECK (Subtotal >= 0),
    Shipping NUMERIC(10, 2) CHECK (Shipping >= 0),
    Total NUMERIC(10, 2) CHECK (Total = Subtotal + Shipping)
);

CREATE TABLE OrderItem (
    orderID INT NOT NULL REFERENCES Orders(orderID) ON DELETE CASCADE,
    bookID INT NOT NULL REFERENCES Book(bookID) ON DELETE CASCADE,
    Quantity INT NOT NULL CHECK (Quantity > 0),
    Price NUMERIC(10, 2) NOT NULL CHECK (Price >= 0),
    PRIMARY KEY (orderID, bookID)
);

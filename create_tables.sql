CREATE TABLE Book (
    bookID INT PRIMARY KEY,
    AuthorID INT,
    PublisherID INT,
    Title TEXT,
    ISBN TEXT,
    Genre TEXT,
    Type TEXT,
    PublicationYear INT,
    Price NUMERIC(10, 2),
    Condition TEXT
);

CREATE TABLE Publisher (
    publisherID INT PRIMARY KEY,
    Country TEXT,
    bookID INT REFERENCES Book(bookID)
);

CREATE TABLE Author (
    AuthorID INT PRIMARY KEY,
    firstName TEXT,
    lastName TEXT,
    bookID INT REFERENCES Book(bookID)
);

CREATE TABLE Inventory (
    bookID INT PRIMARY KEY REFERENCES Book(bookID),
    stockLevelUsed INT,
    stockLevelNew INT
);

CREATE TABLE Customer (
    customerID INT PRIMARY KEY,
    firstName TEXT,
    lastName TEXT,
    streetNumber INT,
    streetName TEXT,
    postalCode TEXT,
    State TEXT,
    Country TEXT,
    phoneNumber TEXT
);

CREATE TABLE Orders (
    orderID INT PRIMARY KEY,
    customerID INT REFERENCES Customer(customerID),
    orderDate DATE,
    Subtotal NUMERIC(10, 2),
    Shipping NUMERIC(10, 2),
    Total NUMERIC(10, 2)
);

CREATE TABLE OrderItem (
    orderID INT,
    bookID INT REFERENCES Book(bookID),
    Quantity INT,
    Price NUMERIC(10, 2),
    PRIMARY KEY (orderID, bookID)
);

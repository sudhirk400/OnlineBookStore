CREATE TABLE Books (
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

CREATE TABLE Publishers (
    publisherID INT PRIMARY KEY,
    Country TEXT,
    bookID INT REFERENCES Books(bookID)
);

CREATE TABLE Authors (
    AuthorID INT PRIMARY KEY,
    firstName TEXT,
    lastName TEXT,
    bookID INT REFERENCES Books(bookID)
);

CREATE TABLE Inventory (
    bookID INT PRIMARY KEY REFERENCES Books(bookID),
    stockLevelUsed INT,
    stockLevelNew INT
);

CREATE TABLE Customers (
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
    customerID INT REFERENCES Customers(customerID),
    orderDate DATE,
    Subtotal NUMERIC(10, 2),
    Shipping NUMERIC(10, 2),
    Total NUMERIC(10, 2)
);

CREATE TABLE OrderItem (
    OrderID INT,
    bookID INT REFERENCES Books(bookID),
    Quantity INT,
    Price NUMERIC(10, 2),
    PRIMARY KEY (OrderID, bookID)
);



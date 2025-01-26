
INSERT INTO Book (bookID, AuthorID, PublisherID, Title, ISBN, Genre, Type, PublicationYear, Price, Condition)
VALUES 
(1, 1, 1, 'Title 1', 'ISBN1', 'Genre 1', 'Fiction', 2001, 10.23, 'New'),
(2, 2, 2, 'Title 2', 'ISBN2', 'Genre 2', 'Non-Fiction', 2002, 20.46, 'Used'),
(3, 3, 3, 'Title 3', 'ISBN3', 'Genre 3', 'Fiction', 2003, 30.69, 'Used'),
(4, 4, 4, 'Title 4', 'ISBN4', 'Genre 4', 'Non-Fiction', 2004, 40.92, 'New'),
(5, 5, 5, 'Title 5', 'ISBN5', 'Genre 5', 'Fiction', 2005, 50.15, 'Used'),
(6, 6, 6, 'Title 6', 'ISBN6', 'Genre 1', 'Non-Fiction', 2006, 60.38, 'New'),
(7, 7, 7, 'Title 7', 'ISBN7', 'Genre 2', 'Fiction', 2007, 70.61, 'Used'),
(8, 8, 8, 'Title 8', 'ISBN8', 'Genre 3', 'Non-Fiction', 2008, 80.84, 'New'),
(9, 9, 9, 'Title 9', 'ISBN9', 'Genre 4', 'Fiction', 2009, 90.07, 'Used'),
(10, 10, 10, 'Title 10', 'ISBN10', 'Genre 5', 'Non-Fiction', 2010, 100.30, 'New');

INSERT INTO Publisher (publisherID, Country, bookID)
VALUES 
(1, 'USA', 1),
(2, 'India', 2),
(3, 'UK', 3),
(4, 'USA', 4),
(5, 'India', 5),
(6, 'UK', 6),
(7, 'USA', 7),
(8, 'India', 8),
(9, 'UK', 9),
(10, 'USA', 10);
 
INSERT INTO Author (AuthorID, firstName, lastName, bookID)
VALUES 
(1, 'AuthorFirst1', 'AuthorLast1', 1),
(2, 'AuthorFirst2', 'AuthorLast2', 2),
(3, 'AuthorFirst3', 'AuthorLast3', 3),
(4, 'AuthorFirst4', 'AuthorLast4', 4),
(5, 'AuthorFirst5', 'AuthorLast5', 5),
(6, 'AuthorFirst6', 'AuthorLast6', 6),
(7, 'AuthorFirst7', 'AuthorLast7', 7),
(8, 'AuthorFirst8', 'AuthorLast8', 8),
(9, 'AuthorFirst9', 'AuthorLast9', 9),
(10, 'AuthorFirst10', 'AuthorLast10', 10);
 
INSERT INTO Inventory (bookID, stockLevelUsed, stockLevelNew)
VALUES 
(1, 15, 10),
(2, 18, 12),
(3, 20, 8),
(4, 14, 9),
(5, 16, 11),
(6, 13, 7),
(7, 22, 15),
(8, 19, 14),
(9, 21, 16),
(10, 17, 10);

INSERT INTO Customer (customerID, firstName, lastName, streetNumber, streetName, postalCode, State, Country, phoneNumber)
VALUES 
(1, 'FirstName1', 'LastName1', 101, 'Street1', 'PIN101', 'Assam', 'India', '+911234567890'),
(2, 'FirstName2', 'LastName2', 102, 'Street2', 'PIN102', 'Gujarat', 'India', '+911234567891'),
(3, 'FirstName3', 'LastName3', 103, 'Street3', 'PIN103', 'Karnataka', 'India', '+911234567892'),
(4, 'FirstName4', 'LastName4', 104, 'Street4', 'PIN104', 'Province4', 'India', '+911234567893'),
(5, 'FirstName5', 'LastName5', 105, 'Street5', 'PIN105', 'Gujarat', 'India', '+911234567894'),
(6, 'FirstName6', 'LastName6', 106, 'Street6', 'PIN106', 'Kerala', 'India', '+911234567895'),
(7, 'FirstName7', 'LastName7', 107, 'Street7', 'PIN107', 'Assam', 'India', '+911234567896'),
(8, 'FirstName8', 'LastName8', 108, 'Street8', 'PIN108', 'Kerala', 'India', '+911234567897'),
(9, 'FirstName9', 'LastName9', 109, 'Street9', 'PIN109', 'Karnataka', 'India', '+911234567898'),
(10, 'FirstName10', 'LastName10', 110, 'Street10', 'PIN110', 'Kerala', 'India', '+911234567899');

INSERT INTO Orders (orderID, customerID, orderDate, Subtotal, Shipping, Total)
VALUES 
(1, 1, '2025-01-01', 50.00, 5.00, 55.00),
(2, 2, '2025-01-02', 60.00, 6.00, 66.00),
(3, 3, '2025-01-03', 70.00, 7.00, 77.00),
(4, 4, '2025-01-04', 80.00, 8.00, 88.00),
(5, 5, '2025-01-05', 90.00, 9.00, 99.00),
(6, 6, '2025-01-06', 100.00, 10.00, 110.00),
(7, 7, '2025-01-07', 110.00, 11.00, 121.00),
(8, 8, '2025-01-08', 120.00, 12.00, 132.00),
(9, 9, '2025-01-09', 130.00, 13.00, 143.00),
(10, 10, '2025-01-10', 140.00, 14.00, 154.00);

INSERT INTO OrderItem (OrderID, bookID, Quantity, Price)
VALUES 
(1, 1, 2, 25.00),
(2, 2, 3, 20.00),
(3, 3, 1, 50.00),
(4, 4, 5, 10.00),
(5, 5, 2, 25.00),
(6, 6, 4, 20.00),
(7, 7, 3, 30.00),
(8, 8, 1, 40.00),
(9, 9, 5, 15.00),
(10, 10, 2, 50.00);

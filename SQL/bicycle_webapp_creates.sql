DROP TABLE IF EXISTS CartItems;
DROP TABLE IF EXISTS Products;
DROP TABLE IF EXISTS ShoppingCarts;
DROP TABLE IF EXISTS Customers;

CREATE TABLE IF NOT EXISTS `Customers` (
  `Customer_Id` int(11) NOT NULL AUTO_INCREMENT,
  `First_Name` varchar(50) NOT NULL,
  `Last_Name` varchar(50) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  PRIMARY KEY (`Customer_Id`)
  );

CREATE TABLE IF NOT EXISTS `ShoppingCarts` (
  `Cart_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Customer_Id` int(11) NOT NULL,
  PRIMARY KEY (`Cart_Id`),
  FOREIGN KEY (`Customer_Id`) REFERENCES Customers(`Customer_Id`)
  );

CREATE TABLE IF NOT EXISTS `Products` (
  `Product_Code` int(11) NOT NULL AUTO_INCREMENT,
  `Product_Name` varchar(50) NOT NULL,
  `Product_Description` varchar(100) NOT NULL,
  `Product_Price` int(5) NOT NULL,
  PRIMARY KEY (`Product_Code`)
  );

CREATE TABLE IF NOT EXISTS `CartItems` (
  `Customer_Id` int(11) NOT NULL,
  `Product_Code` int(11) NOT NULL,
  `Product_Quantity` int(5) NOT NULL,
  FOREIGN KEY (`Customer_Id`) REFERENCES Customers(`Customer_Id`),
  FOREIGN KEY (`Product_Code`) REFERENCES Products(`Product_Code`)
  );

INSERT INTO Customers VALUES 
  (null, "Alex",  "Kiernan",  "admin",  "pass"),
  (null, "Rian",  "Jolley",   "jolz",   "pass"),
  (null, "Abdul", "Hakeem",   "dollah", "pass"),
  (null, "Greg",  "Gietka",   "coder",  "pass");

INSERT INTO ShoppingCarts VALUES
  (null, 1),
  (null, 2),
  (null, 3),
  (null, 4);

INSERT INTO Products VALUES
  (null, "Raleigh Road Bike", "11 speed road bike, perfect for commuting", 750),
  (null, "Dolan Fixed Gear", "75 inch gear ratio, great for the velodrome", 500);
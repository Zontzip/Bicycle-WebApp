DROP TABLE user;
DROP TABLE bicycle;

CREATE TABLE IF NOT EXISTS `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(50) NOT NULL,
  `LAST_NAME` varchar(50) NOT NULL,
  `USERNAME` varchar(20) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  PRIMARY KEY  (`ID`)
  );

CREATE TABLE IF NOT EXISTS `bicycle` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(50) NOT NULL,
  `productDescription` varchar(100) NOT NULL,
  `productPrice` int(5) NOT NULL,
  PRIMARY KEY  (`ID`)
  );

INSERT INTO user VALUES 
  (null, "Alex",  "Kiernan",  "admin",  "pass"),
  (null, "Rian",  "Jolley",   "jolz",   "pass"),
  (null, "Abdul", "Hakeem",   "dollah", "pass"),
  (null, "Greg",  "Gietka",   "coder",  "pass");

INSERT INTO bicycle VALUES
  (null, "Raleigh Road Bike", "11 speed road bike, perfect for commuting", 750),
  (null, "Dolan Fixed Gear", "75 inch gear ratio, great for the velodrome", 500);

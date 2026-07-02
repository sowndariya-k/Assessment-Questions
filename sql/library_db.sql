CREATE SCHEMA `LIBRARY MANAGEMENT SYSTEM`;
USE `LIBRARY MANAGEMENT SYSTEM`;

-- members table structure
CREATE TABLE `members` (
  `member_id` int NOT NULL ,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `dob` date,
  `email` varchar(255) NOT NULL UNIQUE,
  `phone` varchar(20) DEFAULT NULL,
  `street` VARCHAR(255) DEFAULT NULL,
  `city` VARCHAR(100) DEFAULT NULL,
  `state` VARCHAR(50) DEFAULT 'Tamil Nadu',
  `zip_code` VARCHAR(10) DEFAULT NULL,
  `membership_type` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`member_id`),
  CONSTRAINT chk_membership_type CHECK (`membership_type` IN ('Basic', 'Premium', 'VIP'))
) ;

INSERT INTO `members` VALUES
(1, 'Ram','Kumar', '2000-06-15', 'ram.kumar@email.com', '1234567890', '12 Anna Street', 'Chennai', 'Tamil Nadu', '600002', 'Basic'),
(2, 'Priya','S', '2003-03-22', 'priya.s@email.com', '6374867255', '45 Gandhi Nagar', 'Coimbatore', 'Tamil Nadu', '640001', 'Premium'),
(3,'Kavin','Kumar', '2005-04-04', 'kavin@gmail.com', '9443228559', 'ABC street', 'Salem',  'Tamil Nadu', '637504', 'VIP');

SELECT * FROM members;

-- categ ories table structure
CREATE TABLE `CATEGORIES`(
   `category_id` INT ,
   `category_name` VARCHAR(150) NOT NULL UNIQUE,
   `description` VARCHAR(500) DEFAULT NULL,
   PRIMARY KEY(`category_id`)
) ;

INSERT INTO `CATEGORIES` VALUES
(1, 'Drama','story books'),
(2, 'Science','Books related to physics, chemistry and biology'),
(3, 'History','History book'),
(4, 'Technology','Books on computer science');

SELECT * FROM `CATEGORIES`;


DROP TABLE IF EXISTS `BOOKS`;
-- books table structure
CREATE TABLE `BOOKS`(
   `book_id` INT ,
   `title` VARCHAR(255) NOT NULL ,
   `author` VARCHAR(200) NOT NULL,
   `isbn` VARCHAR(20) NOT NULL UNIQUE,
   `publisher` VARCHAR(200),
   `pub_year` INT ,
   `price` DECIMAL(10,2) NOT NULL,
   `total_copies` int NOT NULL DEFAULT(1),
   `category_id` INT NOT NULL,
   PRIMARY KEY (`book_id`),
   FOREIGN KEY (`category_id`) REFERENCES `CATEGORIES`(`category_id`)
   ) ;
   
INSERT INTO `BOOKS` VALUES
(1, 'The AAA','jerry','978-0062315007', 'SCOPUS',1988, 399.00, 5, 4),
(2, 'History','Stephen','978-0553380163', 'IEEE',1988, 499.00, 3, 3),
(3, 'Atomic habits','Henry','978-0330396110', 'ICCS',2007, 799.00, 4, 2);

SELECT * FROM `BOOKS`;

DROP TABLE IF EXISTS `BORROWS`;
   -- borrow table structure 
   CREATE TABLE `BORROWS`(
   `borrow_id` INT ,
   `member_id` INT NOT NULL,
   `book_id` INT NOT NULL,
   `borrow_date` DATE NOT NULL,
   `due_date` DATE NOT NULL,
   `return_date` DATE ,
   `status` VARCHAR(20),
   FOREIGN KEY (`member_id`) REFERENCES `members`(`member_id`),
   FOREIGN KEY (`book_id`) REFERENCES `BOOKS`(`book_id`),
   PRIMARY KEY (`borrow_id`),
   CONSTRAINT chk_status CHECK (`status` IN ('Borrowed','Returned','Overdue'))
   ) ;
   
INSERT INTO `BORROWS` VALUES
(1, 1, 1, '2025-01-05', '2025-01-19', '2025-01-18', 'Returned'),
(2, 2, 3, '2025-01-10', '2025-01-24', NULL,'Borrowed'),
(3, 3, 2, '2025-01-12', '2025-01-29', '2025-01-28','Overdue');

SELECT * FROM `BORROWS`;

DROP TABLE IF EXISTS `FINES`;
-- fines table structure
   CREATE TABLE  `FINES`(
   `fine_id` INT ,
   `borrow_id` INT NOT NULL,
   `member_id` INT NOT NULL,
   `fine_amount` DECIMAL(2) NOT NULL,
   `paid_amount` DECIMAL(2) DEFAULT(0),
   `fine_date` DATE NOT NULL,
   `payment_status` VARCHAR(20) NOT NULL ,
   FOREIGN KEY (`borrow_id`) REFERENCES `BORROWS`(`borrow_id`),
   FOREIGN KEY (`member_id`) REFERENCES `members`(`member_id`),
   PRIMARY KEY (`fine_id`),
   CONSTRAINT chk_payment_status CHECK (`payment_status` IN ('Paid','Unpaid','Waived'))
) ;   

INSERT INTO `FINES` VALUES
(1, 1, 1,30.00, 30.00,'2025-01-29','Paid'),
(2, 2, 2,20.00, 0.00,'2025-01-25','Unpaid'),
(3, 3, 3,75.00, 40.00,'2025-02-04','Waived');

SELECT * FROM `FINES`;
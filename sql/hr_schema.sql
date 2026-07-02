CREATE SCHEMA HR;
USE HR;
CREATE TABLE countries (
  country_id CHAR(2) PRIMARY KEY,
  country_name VARCHAR(100),
  region_id INT
);

INSERT INTO countries VALUES
('US','United States',1),
('IN','India',2),
('UK','United Kingdom',1);

SELECT *FROM countries;

CREATE TABLE locations (
  location_id  INT PRIMARY KEY,
  street VARCHAR(100),
  city  VARCHAR(100),
  country_id CHAR(2),
  FOREIGN KEY (country_id) REFERENCES countries(country_id)
);

INSERT INTO locations VALUES
(1, '100 Main St', 'New York','US'),
(2, '200 Oak Ave', 'Chicago','US'),
(3, '10 MG Road', 'Chennai','IN'),
(4, '20 Park Lane','Mumbai','IN'),
(5, '5 Baker Street','London','UK');

SELECT country_id, COUNT(city) AS number_of_cities
FROM locations
GROUP BY country_id;


CREATE TABLE employees (
  employee_id  INT PRIMARY KEY,
  first_name VARCHAR(100),
  last_name  VARCHAR(100),
  email VARCHAR(100),
  hire_date DATE,
  job_id  VARCHAR(20),
  salary  DECIMAL(10,2),
  commission_pct DECIMAL(5,2)  DEFAULT NULL,
  department_id  INT,
  FOREIGN KEY (job_id) REFERENCES jobs(job_id),
  FOREIGN KEY (department_id) REFERENCES departments(department_id)
);

INSERT INTO employees VALUES
(1, 'Arjun', 'K','arjun@email.com','1995-03-10', 'IT_PROG',9000.00, NULL,  10),
(2, 'Priya','S', 'priya@email.com','1997-06-15', 'SA_REP',11000.00, 0.25,  80),
(3, 'Karthik','D', 'karthik@email.com','1996-11-30', 'SA_REP',7500.00, 0.15,  80);

-- department table 
CREATE TABLE departments (
  department_id INT PRIMARY KEY,
  department_name VARCHAR(100),
  location_id INT,
  FOREIGN KEY (location_id) REFERENCES locations(location_id)
);

INSERT INTO departments VALUES
(10, 'HR', 1),
(50, 'Shipping',3),
(80, 'Sales',4),
(90, 'Finance',2);


SELECT *FROM employees WHERE salary * 1.25 > 10000;


SELECT first_name, last_name, TIMESTAMPDIFF(YEAR, hire_date, NOW()) AS years_of_experience FROM employees
WHERE TIMESTAMPDIFF(YEAR, hire_date, NOW()) > 27;

SELECT *FROM employees WHERE commission_pct IS NULL AND salary BETWEEN 5000 AND 10000
AND department_id NOT IN (50, 80);
  
  
CREATE TABLE jobs (
  job_id VARCHAR(20)  PRIMARY KEY,
  job_title  VARCHAR(100),
  min_salary DECIMAL(10,2),
  max_salary DECIMAL(10,2)
);

INSERT INTO jobs VALUES
(1,'Programmer',4000,10000),
(2,'Sales Rep',6000,12000),
(3,'Finance',3000,8000),
(4,'President',20000,40000);

SELECT job_id, AVG(salary) AS average_salary FROM employees GROUP BY job_id HAVING AVG(salary) > 10000;
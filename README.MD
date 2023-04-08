http://localhost:8080/api/customers?limit=5&offset=0
http://localhost:8080/api/customer/1
http://localhost:8080/api/customer/1/orders


Task 3

create table orders( id INT NOT NULL PRIMARY KEY, order_date DATE, shipping_date DATE, ship_name VARCHAR(50), shipping_fees DECIMAL(10,2), employee_id INT, FOREIGN KEY(employee_id) REFERENCES employees(id) );

 insert into orders values (1,'2022-01-03','2022-03-01','Sunny','9.99',1), (2,'2022-01-04','2022-03-02','Moon','10.99',3), (3,'2022-01-05','2022-03-03','Dream','11.00',4), (4,'2022-01-06','2022-03-04','Wonder','5.99',5), (5,'2022-01-07','2022-03-05','Titanic','3.99',2);

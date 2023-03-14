-- Products
insert into products(name, price, category, image_url) values
	('Pant A', '10.13', 'Pants', '/assets/products/pant_a.jpg'),
	('Pant B', '12.44', 'Pants', '/assets/products/pant_b.jpg'),
	('Pant C', '28.88', 'Pants', '/assets/products/pant_c.jpg'),
	('Dress A', '76.33', 'Dresses', '/assets/products/dress_a.jpg'),
	('Jacket A', '36.34', 'Jackets', '/assets/products/jacket_a.jpg'),
	('Jacket B', '42.58', 'Jackets', '/assets/products/jacket_b.jpg'),
	('Sweater A', '25.23', 'Sweaters', '/assets/products/sweater_a.jpg'),
	('Sweater B', '26.48', 'Sweaters', '/assets/products/sweater_b.jpg'),
	('Sweater C', '18.78', 'Sweaters', '/assets/products/sweater_c.jpg');

-- Orders
insert into orders(date, status) values
	('2023-01-01', 'delivered'),
	('2023-01-02', 'delivered'),
	('2023-01-04', 'delivered'),
	('2023-01-04', 'delivered'),
	('2023-01-06', 'delivered'),
	('2023-01-07', 'approved'),
	('2023-01-09', 'approved'),
	('2023-01-09', 'placed');

-- Order Items
insert into order_items(order_id, product_id, quantity) values
	(1, 1, 2),
	(1, 3, 1),
	(1, 8, 1),

	(2, 2, 1),
	(2, 4, 1),

	(3, 1, 1),
	(3, 2, 1),
	(3, 4, 2),
	(3, 9, 3),

	(4, 5, 1),
	(4, 6, 1),

	(5, 9, 3),

	(6, 3, 1),
	(6, 8, 1),
	(6, 9, 1),

	(7, 1, 2),
	(7, 2, 3),
	(7, 3, 1),
	(7, 4, 1),
	(7, 7, 5),
	(7, 8, 2),

	(8, 2, 1),
	(8, 6, 1),
	(8, 8, 1);

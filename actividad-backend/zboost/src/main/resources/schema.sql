create table products (
	id int auto_increment,
	name varchar(50),
	price decimal(4,2),
	category varchar(50),
	image_url varchar(120),
	primary key(id)
);

create table orders (
	id int auto_increment,
	date date,
	status varchar(50),
	primary key(id)
);

create table order_items (
	id int auto_increment,
	order_id int,
	product_id int,
	quantity int,
	primary key(id),
	foreign key(order_id) references orders(id),
	foreign key(product_id) references products(id)
);

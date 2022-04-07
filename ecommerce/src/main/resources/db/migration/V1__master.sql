Create table ecom_cart(
    id int primary key not null,
    item_id int,
    quantity double precision,
    per_item_price double precision,
    total_item_price double precision
);

Create table items(
    id int primary key not null,
    name varchar(255),
    description varchar(255),
    price double precision,
    weight double precision
);

Create table weight_distance(
    id int primary key not null,
    min_weight double precision,
    max_weight double precision,
    min_distane double precision,
    max_distance double precision,
    price double precision
);


select price from weight_distance where ? between min_weight and max_weight and ? between min_distane and max_distance



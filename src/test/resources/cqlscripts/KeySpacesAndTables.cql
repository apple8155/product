CREATE KEYSPACE IF NOT exists domain
WITH replication = {'class':'SimpleStrategy', 'replication_factor':3}

;

CREATE TABLE IF NOT exists domain.product_details(
product_id int PRIMARY KEY,
product_name text,
vendor text,
instock varint,
vendor_contact varint
);

INSERT INTO domain.product_details (product_id, product_name, vendor, instock, vendor_contact) VALUES (1, 'KidAddress', '231', 1, 89)

;


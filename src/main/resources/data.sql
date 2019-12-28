INSERT INTO products (name, price, created_at, stock, iva, enable) VALUES('Panasonic Pantalla LCD', 259990, NOW(),2,4,1);
INSERT INTO products (name, price, created_at, stock, iva, enable) VALUES('Sony Camara digital DSC-W320B', 123490, NOW(),2,5,1);
INSERT INTO products (name, price, created_at, stock, iva, enable) VALUES('Apple iPod shuffle', 1499990, NOW(),2,3,1);
INSERT INTO products (name, price, created_at, stock, iva, enable) VALUES('Sony Notebook Z110', 37990, NOW(),2,2,1);
INSERT INTO products (name, price, created_at, stock, iva, enable) VALUES('Hewlett Packard Multifuncional F2280', 69990, NOW(),2,3,1);
INSERT INTO products (name, price, created_at, stock, iva, enable) VALUES('Bianchi Bicicleta Aro 26', 69990, NOW(),2,4,1);
INSERT INTO products (name, price, created_at, stock, iva, enable) VALUES('Mica Comoda 5 Cajones', 299990, NOW(),2,5,1);

INSERT INTO `users` (username, password, enable) VALUES ('andres','$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG',1);
INSERT INTO `users` (username, password, enable) VALUES ('admin','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS',1);

INSERT INTO `authorities` (user_id, authority) VALUES (1,'ROLE_USER');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_ADMIN');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_USER');

INSERT INTO clients (name, lastname, direction, phone, email, identification, created_at) VALUES('Pedro', 'Perez', 'fffffffff','2323223222','juan@gmail.com','23323333223',NOW());
INSERT INTO clients (name, lastname, direction, phone, email, identification, created_at) VALUES('James', 'Perez', 'fffffffff','2323223222','juan@gmail.com','23323333223',NOW());
INSERT INTO clients (name, lastname, direction, phone, email, identification, created_at) VALUES('Richard', 'Perez', 'fffffffff','2323223222','juan@gmail.com','23323333223',NOW());
INSERT INTO clients (name, lastname, direction, phone, email, identification, created_at) VALUES('Janie', 'Perez', 'fffffffff','2323223222','juan@gmail.com','23323333223',NOW());
INSERT INTO clients (name, lastname, direction, phone, email, identification, created_at) VALUES('Linus', 'Perez', 'fffffffff','2323223222','juan@gmail.com','23323333223',NOW());
INSERT INTO clients (name, lastname, direction, phone, email, identification, created_at) VALUES('Johnny', 'Perez', 'fffffffff','2323223222','juan@gmail.com','23323333223',NOW());



INSERT INTO invoices (description, observation, client_id, created_at, user_id) VALUES('Factura equipos de oficina', null, 1, NOW(),1);
INSERT INTO invoice_items (quatity, invoice_id, product_id, itbis, price) VALUES(1, 1, 1, 4, 259990);
INSERT INTO invoice_items (quatity, invoice_id, product_id, itbis, price) VALUES(2, 1, 4,1,123490);
-- INSERT INTO invoice_items (quatity, invoice_id, product_id) VALUES(1, 1, 5);
-- INSERT INTO invoice_items (quatity, invoice_id, product_id) VALUES(1, 1, 7);
-- INSERT INTO invoices (description, observation, client_id, created_at,user_id) VALUES('Factura Bicicleta', 'Alguna nota importante!', 1, NOW(),1);
-- INSERT INTO invoice_items (quatity, invoice_id, product_id) VALUES(3, 2, 6);

INSERT INTO global_config(company_name, company_phone, company_address, company_nit, company_email, invoice_footer) values('xxxxx c.a','334344323','xxxxxxxxxx','d3344f3f4f43','company@gmail.com','the footer')

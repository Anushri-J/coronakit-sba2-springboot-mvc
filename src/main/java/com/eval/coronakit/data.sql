insert into users (username, password, enabled, email,contact) values ('admin','{noop}admin',1,'admin@mail.com', '1234567890');
insert into authorities (username, authority) values ('admin','ROLE_ADMIN');
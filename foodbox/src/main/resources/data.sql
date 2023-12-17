/*Inserting data under role*/
INSERT INTO user_roles(roletype) values ('admin');
INSERT INTO user_roles(roletype) values ('customer');
commit;
/*Creating the admin user*/
INSERT INTO users (address,email,firstname,lastname,password,phonenumber,roleid,username) 
SELECT 'India','admin@foodbox.com','admin','admin','admin@foodbox','1234567891','1','admin'
where not exists(select * from users where username='admin');

INSERT INTO products VALUES (1, "/image/product.jpeg", "Pizza", 200.00, 800, 4.5, 5, "Delicious Italian Pizza",null,null,null);

COMMIT;


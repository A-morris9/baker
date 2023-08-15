BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER');

INSERT INTO cakes (title, description, price, style, size, isavailable, image) VALUES ('Mercury', 'closest to the sun', 24, 'sheet', 'large', true, 'url');
INSERT INTO cakes (title, description, price, style, size, isavailable, image) VALUES ('Mercury', 'hottest planet', 21, 'layer', 'medium', true, 'url');
INSERT INTO cakes (title, description, price, style, size, isavailable, image) VALUES ('Mercury', 'the red planet', 22, 'cupcakes', 'small', false, 'url');

INSERT INTO fillings (description, cost, inventoryamount, isavailable) VALUES ('chocolate', 12, 500, true);
INSERT INTO fillings (description, cost, inventoryamount, isavailable) VALUES ('vanilla', 12, 500, true);
INSERT INTO fillings (description, cost, inventoryamount, isavailable) VALUES ('caramel', 12, 500, true);

INSERT INTO flavors (description, cost, inventoryamount, isavailable) VALUES ('chocolate', 12, 500, true);
INSERT INTO flavors (description, cost, inventoryamount, isavailable) VALUES ('vanilla', 12, 500, true);
INSERT INTO flavors (description, cost, inventoryamount, isavailable) VALUES ('caramel', 12, 500, true);

INSERT INTO orders (cakeid, status, customerfirstname, customerlastname, streetnumber, streetname, city, state, zip, phonenumber, orderdate, pickupdate, writing, writingfee, totalamount) VALUES (1, 'Pending', 'Edward', 'Kelly', 123, 'Robley', 'Cincinnati', 'Ohio', 45223, '555-5555', '2023-08-15 12:34:56', '2023-08-18 12:34:56', 'blah', 5, 30);
INSERT INTO orders (cakeid, status, customerfirstname, customerlastname, streetnumber, streetname, city, state, zip, phonenumber, orderdate, pickupdate, writing, writingfee, totalamount) VALUES (1, 'Pending', 'Bill', 'Clinton', 456, 'Pennsylvania', 'Washington', 'DC', 11111, '555-5555', '2023-08-15 12:34:56', '2023-08-18 12:34:56', 'blah', 5, 30);
INSERT INTO orders (cakeid, status, customerfirstname, customerlastname, streetnumber, streetname, city, state, zip, phonenumber, orderdate, pickupdate, writing, writingfee, totalamount) VALUES (1, 'Pending', 'John', 'Adams', 789, 'Constitution', 'Boston', 'Massachusetts', 12222, '555-5555', '2023-08-15 12:34:56', '2023-08-18 12:34:56', 'blah', 5, 30);

INSERT INTO frostings (description, cost, inventoryamount, isavailable) VALUES ('chocolate', 12, 500, true);
INSERT INTO frostings (description, cost, inventoryamount, isavailable) VALUES ('vanilla', 12, 500, true);
INSERT INTO frostings (description, cost, inventoryamount, isavailable) VALUES ('caramel', 12, 500, true);

COMMIT TRANSACTION;

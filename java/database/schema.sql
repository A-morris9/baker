BEGIN TRANSACTION;

DROP TABLE IF EXISTS cakes_properties;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS properties;
DROP TABLE IF EXISTS cakes;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password_hash VARCHAR(200) NOT NULL,
    role VARCHAR(50) NOT NULL
);

CREATE TABLE cakes (
    CakeID SERIAL PRIMARY KEY,
    Title VARCHAR(255) NOT NULL,
    Description TEXT NOT NULL,
    Price DECIMAL(10, 2) NOT NULL,
    Style VARCHAR(255) NOT NULL,
    Size VARCHAR(255) NOT NULL,
    Availability BOOLEAN NOT NULL,
    Image VARCHAR(255) NOT NULL
);

CREATE TABLE properties (
    PropertiesID SERIAL PRIMARY KEY,
    Flavor VARCHAR(50) NOT NULL,
    Frosting VARCHAR(50) NOT NULL,
    Filling VARCHAR(50) NOT NULL,
    Availability BOOLEAN
);

CREATE TABLE cakes_properties (
    CakePropertiesID SERIAL PRIMARY KEY,
    CakeID INT REFERENCES Cakes(CakeID),
    PropertiesID INT REFERENCES properties(PropertiesID),
    Quantity DECIMAL(10, 2),
    UnitOfMeasure VARCHAR(50),
    Availability BOOLEAN
);

CREATE TABLE orders (
    OrderID SERIAL PRIMARY KEY,
    CakeID INT REFERENCES cakes(CakeID),
    CustomerName VARCHAR(255),
    DeliveryAddress VARCHAR(255),
    PhoneNumber VARCHAR(20),
    OrderDate DATE,
    PickupDate TIMESTAMP,
    CustomerWantsWriting BOOLEAN,
    Writing TEXT,
    WritingFee DECIMAL(10, 2),
    TotalAmount DECIMAL(10, 2)
);


COMMIT TRANSACTION;

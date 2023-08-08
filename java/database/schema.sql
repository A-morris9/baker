BEGIN TRANSACTION;

DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS flavors;
DROP TABLE IF EXISTS frostings;
DROP TABLE IF EXISTS fillings;
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

CREATE TABLE flavors (
    FlavorID SERIAL PRIMARY KEY,
    Name VARCHAR(50) NOT NULL,
    Cost DECIMAL(10, 2) NOT NULL,
    InventoryAmount INT NOT NULL,
    Availability BOOLEAN NOT NULL,
    CakeID INT REFERENCES cakes(CakeID)
);

CREATE TABLE frostings (
    FrostingID SERIAL PRIMARY KEY,
    Name VARCHAR(50) NOT NULL,
    Cost DECIMAL(10, 2) NOT NULL,
    InventoryAmount INT NOT NULL,
    Availability BOOLEAN NOT NULL,
    CakeID INT REFERENCES cakes(CakeID)
);

CREATE TABLE fillings (
    FillingID SERIAL PRIMARY KEY,
    Name VARCHAR(50) NOT NULL,
    Cost DECIMAL(10, 2) NOT NULL,
    InventoryAmount INT NOT NULL,
    Availability BOOLEAN NOT NULL,
    CakeID INT REFERENCES cakes(CakeID)
);

CREATE TABLE cake_flavors (
    CakeFlavorID SERIAL PRIMARY KEY,
    CakeID INT REFERENCES cakes(CakeID),
    FlavorID INT REFERENCES flavors(FlavorID)
);

CREATE TABLE cakes_fillings (
    CakeFillingID SERIAL PRIMARY KEY,
    CakeID INT REFERENCES cakes(CakeID),
    FillingID INT REFERENCES fillings(FillingID)
);

CREATE TABLE cakes_frostings (
    CakeFrostingID SERIAL PRIMARY KEY,
    CakeID INT REFERENCES cakes(CakeID),
    FrostingID INT REFERENCES frostings(FrostingID)
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

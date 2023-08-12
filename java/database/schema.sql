BEGIN TRANSACTION;

DROP TABLE IF EXISTS cakes_fillings;
DROP TABLE IF EXISTS cakes_frostings;
DROP TABLE IF EXISTS cakes_flavors;
--DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS category;
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

CREATE TABLE category (
    CategoryID SERIAL PRIMARY KEY,
    Description VARCHAR(50) NOT NULL
);
INSERT INTO category (Description)
VALUES
    ('Layer'),
    ('Sheet'),
    ('Cup-cake');

CREATE TABLE cakes (
    CakeID SERIAL PRIMARY KEY,
    Title VARCHAR(255),
    Description TEXT,
    Price DECIMAL(10, 2) NOT NULL,
    Style VARCHAR(255) NOT NULL,
    Size VARCHAR(255) NOT NULL,
    isAvailable BOOLEAN NOT NULL DEFAULT false,
    isStandard BOOLEAN NOT NULL DEFAULT false,
    isDeleted BOOLEAN NOT NULL DEFAULT false,
    CategoryID INT REFERENCES category(CategoryID) DEFAULT 1,
    Image TEXT
);


CREATE TABLE flavors (
    FlavorID SERIAL PRIMARY KEY,
    Description VARCHAR(50) NOT NULL,
    Cost DECIMAL(10, 2) NOT NULL,
    InventoryAmount INT NOT NULL,
    isAvailable BOOLEAN NOT NULL
);

CREATE TABLE frostings (
    FrostingID SERIAL PRIMARY KEY,
    Description VARCHAR(50) NOT NULL,
    Cost DECIMAL(10, 2) NOT NULL,
    InventoryAmount INT NOT NULL,
    isAvailable BOOLEAN NOT NULL
);

CREATE TABLE fillings (
    FillingID SERIAL PRIMARY KEY,
    Description VARCHAR(50) NOT NULL,
    Cost DECIMAL(10, 2) NOT NULL,
    InventoryAmount INT NOT NULL,
    isAvailable BOOLEAN NOT NULL
);

CREATE TABLE cakes_flavors (
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

--CREATE Type order_status AS ENUM('Pending', 'Canceled', 'Ready', 'Complete');
CREATE TABLE orders (
    OrderID SERIAL PRIMARY KEY,
    CakeID INT REFERENCES cakes(CakeID),
    status VARCHAR(15) NOT NULL DEFAULT 'Pending',
    customerFirstName VARCHAR(255),
    customerLastName VARCHAR(255),
    streetNumber INT,
    streetName VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(255),
    zip VARCHAR(255),
    PhoneNumber VARCHAR(20),
    OrderDate TIMESTAMP,
    PickupDate TIMESTAMP,
    Writing TEXT,
    WritingFee DECIMAL(10, 2),
    TotalAmount DECIMAL(10, 2)
);

COMMIT TRANSACTION;

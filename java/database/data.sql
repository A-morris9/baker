BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO cakes (Name, Description, Image, Price, Availability)
VALUES
    ('Classic Chocolate Cake', 'Moist chocolate cake with rich chocolate frosting.', 'chocolate_cake.jpg', 25.00, true),
    ('Vanilla Celebration Cake', 'Fluffy vanilla cake with colorful sprinkles and vanilla buttercream.', 'vanilla_cake.jpg', 30.00, true),
    ('Strawberry Shortcake', 'Light sponge cake layered with fresh strawberries and whipped cream.', 'strawberry_shortcake.jpg', 28.00, true),
    ('Red Velvet Delight', 'Delicious red velvet cake with cream cheese frosting.', 'red_velvet_cake.jpg', 28.00, true),
    ('Lemon Blueberry Bliss', 'Zesty lemon cake with blueberry filling and lemon frosting.', 'lemon_blueberry_cake.jpg', 26.00, true),
    ('Coconut Dream Cake', 'Coconut-flavored cake with coconut cream and shredded coconut topping.', 'coconut_cake.jpg', 24.00, true),
    ('Decadent Dark Chocolate Cake', 'Indulgent dark chocolate cake with chocolate ganache and raspberry filling.', 'dark_chocolate_cake.jpg', 32.00, true),
    ('Carrot Cake Delight', 'Moist carrot cake with cream cheese frosting and chopped walnuts.', 'carrot_cake.jpg', 27.00, true),
    ('Tiramisu Torte', 'Elegant tiramisu-flavored cake with coffee-soaked layers and mascarpone filling.', 'tiramisu_cake.jpg', 30.00, true),
    ('Mint Chocolate Chip Cake', 'Refreshing mint-flavored cake with chocolate chip filling and mint frosting.', 'mint_chocolate_chip_cake.jpg', 29.00, true);


    INSERT INTO ingredients (Name, UnitOfMeasure, Cost, StockQuantity, Availability, Style, Size, Flavor, Frosting, Filling)
    VALUES
        ('Chocolate', 'grams', 0.15, 1000, true, 'Chocolate', 'NA', 'Chocolate', 'NA', 'NA'),
        ('Vanilla', 'grams', 0.10, 1200, true, 'Vanilla', 'NA', 'Vanilla', 'NA', 'NA'),
        ('Strawberries', 'count', 0.25, 50, true, 'Fruit', 'Medium', 'Strawberry', 'NA', 'NA'),
        ('Cream Cheese', 'grams', 0.30, 800, true, 'Cream Cheese', 'NA', 'NA', 'Cream Cheese', 'NA'),
        ('Lemon Zest', 'teaspoon', 0.05, 500, true, 'Citrus', 'Small', 'Lemon', 'NA', 'NA'),
        ('Coconut Cream', 'grams', 0.20, 600, true, 'Coconut', 'NA', 'NA', 'NA', 'Coconut Cream'),
        ('Dark Chocolate', 'grams', 0.18, 1100, true, 'Chocolate', 'NA', 'Dark Chocolate', 'NA', 'NA'),
        ('Carrots', 'grams', 0.12, 700, true, 'Vegetable', 'NA', 'NA', 'NA', 'Carrot'),
        ('Coffee', 'teaspoon', 0.08, 900, true, 'Coffee', 'NA', 'Coffee', 'NA', 'NA'),
        ('Mint Leaves', 'count', 0.07, 1000, true, 'Mint', 'NA', 'Mint', 'NA', 'NA');

    INSERT INTO cakes_ingredients (CakeID, IngredientID, Quantity, UnitOfMeasure, Availability)
    VALUES
        (1, 1, 300, 'grams', true), -- Classic Chocolate Cake: Chocolate
        (1, 2, 100, 'grams', true), -- Classic Chocolate Cake: Vanilla
        (1, 4, 150, 'grams', true), -- Classic Chocolate Cake: Cream Cheese

        (2, 2, 200, 'grams', true), -- Vanilla Celebration Cake: Vanilla
        (2, 3, 10, 'count', true),  -- Vanilla Celebration Cake: Strawberries
        (2, 4, 200, 'grams', true), -- Vanilla Celebration Cake: Cream Cheese

        (3, 2, 150, 'grams', true), -- Strawberry Shortcake: Vanilla
        (3, 3, 15, 'count', true),  -- Strawberry Shortcake: Strawberries
        (3, 4, 150, 'grams', true), -- Strawberry Shortcake: Cream Cheese

        (4, 1, 250, 'grams', true), -- Red Velvet Delight: Chocolate
        (4, 2, 150, 'grams', true), -- Red Velvet Delight: Vanilla
        (4, 4, 200, 'grams', true), -- Red Velvet Delight: Cream Cheese

        (5, 2, 100, 'grams', true), -- Lemon Blueberry Bliss: Vanilla
        (5, 5, 2, 'teaspoon', true), -- Lemon Blueberry Bliss: Lemon Zest
        (5, 3, 20, 'count', true),   -- Lemon Blueberry Bliss: Blueberries
        (5, 4, 200, 'grams', true),  -- Lemon Blueberry Bliss: Cream Cheese

        (6, 2, 200, 'grams', true), -- Coconut Dream Cake: Vanilla
        (6, 6, 200, 'grams', true), -- Coconut Dream Cake: Coconut Cream

        (7, 1, 300, 'grams', true), -- Decadent Dark Chocolate Cake: Chocolate
        (7, 7, 200, 'grams', true), -- Decadent Dark Chocolate Cake: Dark Chocolate
        (7, 4, 150, 'grams', true), -- Decadent Dark Chocolate Cake: Cream Cheese
        (7, 8, 10, 'count', true),   -- Decadent Dark Chocolate Cake: Raspberries

        (8, 2, 100, 'grams', true), -- Carrot Cake Delight: Vanilla
        (8, 8, 150, 'grams', true), -- Carrot Cake Delight: Carrots
        (8, 4, 200, 'grams', true), -- Carrot Cake Delight: Cream Cheese
        (8, 9, 10, 'count', true),   -- Carrot Cake Delight: Walnuts

        (9, 10, 2, 'teaspoon', true), -- Tiramisu Torte: Coffee
        (9, 4, 150, 'grams', true),   -- Tiramisu Torte: Cream Cheese

        (10, 1, 150, 'grams', true), -- Mint Chocolate Chip Cake: Chocolate
        (10, 10, 5, 'count', true);

COMMIT TRANSACTION;

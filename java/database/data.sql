BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO cakes (Title, Description, Price, Style, Size, Availability, Image)
VALUES
    ('Classic Chocolate Cake', 'Moist chocolate cake with rich chocolate frosting.', 25.00, 'Sheet Cake', 'Medium', true, 'https://img.taste.com.au/qrA0oF1O/taste/2016/11/classic-chocolate-cake-46019-1.jpeg'),
    ('Velvety Vanilla Delight', 'Smooth vanilla cake with luscious vanilla buttercream.', 22.00, 'Sheet Cake', 'Medium', true, 'velvety_vanilla_cake.jpg'),
    ('Zesty Lemon Burst', 'Tangy lemon-flavored cake with zesty lemon glaze.', 20.00, 'Citrus', 'Small', true, 'zesty_lemon_cake.jpg'),
    ('Berry Bliss', 'Mixed berry cake with layers of fresh berries and berry compote.', 28.00, 'Fruit', 'Large', true, 'berry_bliss_cake.jpg'),
    ('Decadent Red Velvet', 'Rich red velvet cake with cream cheese frosting.', 26.00, 'Red Velvet', 'Medium', true, 'decadent_red_velvet_cake.jpg'),
    ('Caramel Pecan Indulgence', 'Caramel-flavored cake topped with candied pecans.', 23.00, 'Caramel', 'Small', true, 'caramel_pecan_cake.jpg'),
    ('Coconut Cream Paradise', 'Coconut-infused cake with creamy coconut frosting and shredded coconut.', 24.00, 'Coconut', 'Medium', true, 'coconut_cream_cake.jpg'),
    ('Mocha Madness', 'Coffee and chocolate cake with mocha buttercream.', 27.00, 'Mocha', 'Large', true, 'mocha_madness_cake.jpg'),
    ('Strawberry Shortcake', 'Light vanilla cake with fresh strawberries and whipped cream.', 21.00, 'Fruit', 'Small', true, 'strawberry_shortcake.jpg'),
    ('Tiramisu Temptation', 'Classic tiramisu cake with layers of coffee-soaked ladyfingers and mascarpone.', 25.00, 'Coffee', 'Medium', true, 'tiramisu_temptation_cake.jpg');

INSERT INTO flavors (Name, Cost, InventoryAmount, Availability, CakeID)
VALUES
    ('Chocolate', 0.10, 1000, true, 1),   -- Classic Chocolate Cake
    ('Vanilla', 0.08, 1200, true, 2),     -- Velvety Vanilla Delight
    ('Lemon', 0.05, 800, true, 3),        -- Zesty Lemon Burst
    ('Mixed Berry', 0.12, 600, true, 4),  -- Berry Bliss
    ('Red Velvet', 0.15, 1000, true, 5),  -- Decadent Red Velvet
    ('Caramel', 0.12, 900, true, 6),      -- Caramel Pecan Indulgence
    ('Coconut', 0.10, 700, true, 7),      -- Coconut Cream Paradise
    ('Mocha', 0.12, 800, true, 8),        -- Mocha Madness
    ('Strawberry', 0.10, 600, true, 9),   -- Strawberry Shortcake
    ('Coffee', 0.12, 1000, true, 10);     -- Tiramisu Temptation

INSERT INTO frostings (Name, Cost, InventoryAmount, Availability, CakeID)
VALUES
    ('Chocolate', 0.10, 900, true, 1),    -- Classic Chocolate Cake
    ('Vanilla', 0.08, 1100, true, 2),      -- Velvety Vanilla Delight
    ('Cream Cheese', 0.12, 950, true, 2),  -- Decadent Red Velvet
    ('Coconut Cream', 0.12, 750, true, 7),-- Coconut Cream Paradise
    ('Mocha', 0.12, 800, true, 8),        -- Mocha Madness
    ('Whipped Cream', 0.10, 600, true, 9),-- Strawberry Shortcake
    ('Mascarpone', 0.15, 1000, true, 10); -- Tiramisu Temptation

INSERT INTO fillings (Name, Cost, InventoryAmount, Availability, CakeID)
VALUES
    ('Raspberry Bliss', 0.15, 5, true, 1),
    ('Chocolate Ganache', 0.15, 7, true, 2),
    ('Creamy Caramel', 0.10, 3, true, 3),
    ('Strawberry Heaven', 0.15, 2, true, 1);

COMMIT TRANSACTION;

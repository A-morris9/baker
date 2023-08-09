BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO cakes (Title, Description, Price, Style, Size, Availability, Image)
VALUES
    ('Classic Chocolate Cake', 'Moist chocolate cake with rich chocolate frosting.', 25.00, 'Sheet Cake', 'Medium', true, 'https://img.taste.com.au/qrA0oF1O/taste/2016/11/classic-chocolate-cake-46019-1.jpeg'),
    ('Velvety Vanilla Delight', 'Smooth vanilla cake with luscious vanilla buttercream.', 22.00, 'Sheet Cake', 'Medium', true, 'https://cdn11.bigcommerce.com/s-w6rae6i8cu/images/stencil/1280x1280/products/115/785/PDP_lifestyle__0007_CELEB_9__96988__08613.1662993858.jpg?c=1'),
    ('Zesty Lemon Burst', 'Tangy lemon-flavored cake with zesty lemon glaze.', 20.00, 'Citrus', 'Small', true, 'https://www.kingarthurbaking.com/sites/default/files/styles/featured_image/public/2023-07/Mango-Float-Ice-Cream-Cake_1611_0.jpg?itok=4S7MGaeo'),
    ('Berry Bliss', 'Mixed berry cake with layers of fresh berries and berry compote.', 28.00, 'Fruit', 'Large', true, 'https://ginsbergs.com/wp-content/uploads/2021/07/Berry-Bliss-NoBake-Cheesecake_600x450.jpg'),
    ('Decadent Red Velvet', 'Rich red velvet cake with cream cheese frosting.', 26.00, 'Red Velvet', 'Medium', true, 'https://www.foodnetwork.com/content/dam/images/food/fullset/2004/1/23/1/ss1d26_red_velvet_cake.jpg'),
    ('Caramel Pecan Indulgence', 'Caramel-flavored cake topped with candied pecans.', 23.00, 'Caramel', 'Small', true, 'https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhV25gBFFf2YjSxPSCIm6rzmvMNuqZfXVcCf0ELJv5hnh_ibfyBaVpzML-XHCmt9T0CPsJ7ameSCOiBMuQ8tR2Qm1nXhIzm8Mu3bcLAa6G7Lt9KKyjTTyl1jROIzji1VBCkOK1jZzhkQY43vD6kQIK4bGpyYoAH68-PbcZByEYUbeH_rIIWML5BPWrxKzk/s2048/german-chocolate-cake-2.jpg'),
    ('Coconut Cream Paradise', 'Coconut-infused cake with creamy coconut frosting and shredded coconut.', 24.00, 'Coconut', 'Medium', true, 'https://mommypotamus.com/wp-content/uploads/Coconut-Cream-Cake-Recipe.jpg'),
    ('Mocha Madness', 'Coffee and chocolate cake with mocha buttercream.', 27.00, 'Mocha', 'Large', true, 'https://livforcake.com/wp-content/uploads/2015/08/mocha_cake_black-1.jpg'),
    ('Strawberry Shortcake', 'Light vanilla cake with fresh strawberries and whipped cream.', 21.00, 'Fruit', 'Small', true, 'https://stylesweet.com/wp-content/uploads/2022/06/Summer_Category-500x500.jpg'),
    ('Tiramisu Temptation', 'Classic tiramisu cake with layers of coffee-soaked ladyfingers and mascarpone.', 25.00, 'Coffee', 'Medium', true, 'https://soghaqatar.com/resources/assets/images/product_images/1584085851.temptations-tiramisu-cake-01.jpg');

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

INSERT INTO cakes_frostings (CakeID, FrostingID)
VALUES
    (1, 1),  -- CakeID 1 with FrostingID 1
    (2, 2),  -- CakeID 2 with FrostingID 2
    (3, 3),  -- CakeID 3 with FrostingID 3
    (4, 1),  -- CakeID 4 with FrostingID 1
    (5, 4)  -- CakeID 5 with FrostingID 4
    -- Add more associations here
;

INSERT INTO cakes_fillings (CakeID, FillingID)
VALUES
    (1, 1),  -- CakeID 1 with FillingID 1
    (2, 2),  -- CakeID 2 with FillingID 2
    (3, 3),  -- CakeID 3 with FillingID 3
    (4, 1),  -- CakeID 4 with FillingID 1
    (5, 4)  -- CakeID 5 with FillingID 4
    -- Add more associations here
;
INSERT INTO cake_flavors (CakeID, FlavorID)
VALUES
    (1, 1),  -- CakeID 1 with FlavorID 1
    (2, 2),  -- CakeID 2 with FlavorID 2
    (3, 3),  -- CakeID 3 with FlavorID 3
    (4, 1),  -- CakeID 4 with FlavorID 1
    (5, 4)  -- CakeID 5 with FlavorID 4
    -- Add more associations here
;
COMMIT TRANSACTION;

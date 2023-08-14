BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO cakes (Title, Description, Price, Style, Size, isAvailable, Image)
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
    ('Tiramisu Temptation', 'Classic tiramisu cake with layers of coffee-soaked ladyfingers and mascarpone.', 25.00, 'Coffee', 'Medium', true, 'https://soghaqatar.com/resources/assets/images/product_images/1584085851.temptations-tiramisu-cake-01.jpg'),
    ('Raspberry White Chocolate Dream', 'Delicate white chocolate cake with raspberry filling.', 29.00, 'Fruit', 'Medium', true, 'https://i0.wp.com/loskitchenco.com/wp-content/uploads/2020/02/IMG_1159-4.jpg?resize=1024%2C819&ssl=1'),
    ('Hazelnut Heaven', 'Decadent hazelnut cake with Nutella-infused frosting.', 28.00, 'Nut', 'Large', true, 'https://cutterandsquidge.com/cdn/shop/products/90920211125_cutterandsquidge1291_1000x1000_crop_center.jpg?v=1642076489'),
    ('Pumpkin Spice Elegance', 'Spiced pumpkin cake with cream cheese frosting.', 23.00, 'Seasonal', 'Medium', true, 'https://hips.hearstapps.com/hmg-prod/images/pumpkin-cakes-1561151560.jpg?crop=1.00xw:0.758xh;0,0.142xh&resize=1200:*'),
    ('Luscious Lavender Lemon', 'Lavender-infused lemon cake with lavender glaze.', 25.00, 'Citrus', 'Small', true, 'https://natashaskitchen.com/wp-content/uploads/2018/07/Lemon-Blackberry-Cake-5-600x800.jpg'),
    ('Cherry Almond Delight', 'Almond-flavored cake with cherry compote and almond slices.', 24.00, 'Fruit', 'Large', true, 'https://joylovefood.com/wp-content/uploads/2014/12/Cherry-Almond-Coffee-Cake-2.jpg'),
    ('Mango Tango', 'Tropical mango cake with layers of fresh mango slices.', 26.00, 'Fruit', 'Medium', true, 'https://zhangcatherine.com/wp-content/uploads/2022/01/PC270068-Edit-768x1024.jpg'),
    ('Cookies and Cream Fantasy', 'Cookies and cream-flavored cake with crushed cookie pieces.', 22.00, 'Chocolate', 'Small', true, 'https://www.kingarthurbaking.com/sites/default/files/styles/featured_image/public/2021-03/Cookies-N-Cream-Cake_-3.jpg?itok=Rs68ZQmL'),
    ('Blueberry Bliss', 'Blueberry-infused cake with blueberry compote and cream cheese frosting.', 27.00, 'Fruit', 'Large', true, 'https://pic.warmoven.in/catalog/product/cache/e4dbbe88580d6bb18ca174b8700f08f3/image/2342ece4/blueberry-bliss-cake.jpg'),
    ('Cinnamon Swirl Sensation', 'Cinnamon-swirled cake with cream cheese drizzle.', 21.00, 'Seasonal', 'Small', true, 'https://livforcake.com/wp-content/uploads/2019/09/cinnamon-roll-cake-2-2.jpg'),
    ('Pistachio Passion', 'Pistachio-flavored cake with pistachio buttercream and chopped pistachios.', 23.00, 'Nut', 'Medium', true, 'https://www.stylenest.co.uk/wp-content/uploads/2015/10/Post-A94A8573.jpg'),
    ('Matcha Green Tea Delight', 'Fluffy matcha-infused cake with matcha buttercream.', 26.50, 'Specialty', 'Medium', true, 'https://thesavorycipolla.com/wp-content/uploads/2023/04/Matcha-cake-thumbnail-768x768.jpg'),
    ('Choco-Berry Explosion', 'Decadent chocolate cake with layers of mixed berries.', 29.00, 'Chocolate', 'Large', true, 'https://inbloombakery.com/wp-content/uploads/2021/05/Chocolate-Berry-Cake-13.jpg'),
    ('Pineapple Upside-Down Bliss', 'Classic pineapple upside-down cake with caramelized pineapple topping.', 24.50, 'Fruit', 'Medium', true, 'https://omgchocolatedesserts.com/wp-content/uploads/2016/03/Pineapple-Upside-Down-Cake-2.jpg'),
    ('Almond Raspberry Romance', 'Almond cake layered with raspberry jam and almond buttercream.', 27.50, 'Nut', 'Small', true, 'https://livforcake.com/wp-content/uploads/2019/07/bakewell-cake-2.jpg');


INSERT INTO flavors (Description, Cost, InventoryAmount, isAvailable)
VALUES
    ('Chocolate', 0.10, 1000, true),   -- Classic Chocolate Cake
    ('Vanilla', 0.08, 1200, true),     -- Velvety Vanilla Delight
    ('Lemon', 0.05, 800, true),        -- Zesty Lemon Burst
    ('Mixed Berry', 0.12, 600, true),  -- Berry Bliss
    ('Red Velvet', 0.15, 1000, true),  -- Decadent Red Velvet
    ('Caramel', 0.12, 900, true),      -- Caramel Pecan Indulgence
    ('Coconut', 0.10, 700, true),      -- Coconut Cream Paradise
    ('Mocha', 0.12, 800, true),        -- Mocha Madness
    ('Strawberry', 0.10, 600, true),   -- Strawberry Shortcake
    ('Coffee', 0.12, 1000, true);     -- Tiramisu Temptation

INSERT INTO frostings (Description, Cost, InventoryAmount, isAvailable)
VALUES
    ('Chocolate', 0.10, 900, true),    -- Classic Chocolate Cake
    ('Vanilla', 0.08, 1100, true),      -- Velvety Vanilla Delight
    ('Cream Cheese', 0.12, 950, true),  -- Decadent Red Velvet
    ('Coconut Cream', 0.12, 750, true),-- Coconut Cream Paradise
    ('Mocha', 0.12, 800, true),        -- Mocha Madness
    ('Whipped Cream', 0.10, 600, true),-- Strawberry Shortcake
    ('Mascarpone', 0.15, 1000, true); -- Tiramisu Temptation

INSERT INTO fillings (Description, Cost, InventoryAmount, isAvailable)
VALUES
    ('Raspberry Bliss', 0.15, 5, true),
    ('Chocolate Ganache', 0.15, 7, true),
    ('Creamy Caramel', 0.10, 3, true),
    ('Strawberry Heaven', 0.15, 2, true);

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
INSERT INTO cakes_flavors (CakeID, FlavorID)
VALUES
    (1, 1),  -- CakeID 1 with FlavorID 1
    (2, 2),  -- CakeID 2 with FlavorID 2
    (3, 3),  -- CakeID 3 with FlavorID 3
    (4, 1),  -- CakeID 4 with FlavorID 1
    (5, 4)  -- CakeID 5 with FlavorID 4
    -- Add more associations here
;
COMMIT TRANSACTION;

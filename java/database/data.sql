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

COMMIT TRANSACTION;

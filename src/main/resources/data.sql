-- Characters
INSERT INTO character ("full_name", "alias", "gender", "picture") VALUES ('Peter Parker', 'Spider-Man', 'Man', 'https://www.thedigitalfix.com/wp-content/uploads/2022/05/tobey-maguire-spider-verse.jpg'); --1
INSERT INTO character ("full_name", "alias", "gender", "picture") VALUES ('Jar Jar Binks', '', 'Male', 'https://static.wikia.nocookie.net/starwars/images/0/02/Jar_Jar_SWSB.png/revision/latest?cb=20160910034613'); --1

-- Franchises
INSERT INTO franchise ("franchise_name", "description") VALUES ('Marvel', 'Multiverse of super heroes.'); --1
INSERT INTO franchise ("franchise_name", "description") VALUES ('Nostalgia', 'Old movies we like.'); --2

-- Movies
INSERT INTO movie ("title", "genre", realese_year, "director", "picture", "trailer", franchise_id) VALUES ('Spider-Man: 2', 'Action', 2004, 'Sam Raimi', 'https://m.media-amazon.com/images/M/MV5BMzY2ODk4NmUtOTVmNi00ZTdkLTlmOWYtMmE2OWVhNTU2OTVkXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_.jpg', 'https://www.youtube.com/watch?v=1s9Yln0YwCw', 1); --1
INSERT INTO movie ("title", "genre", realese_year, "director", "picture", "trailer", franchise_id) VALUES ('Avatar', 'Action, Adventure, Fantasy, Sci-Fi', 2009, 'James Cameron', 'https://m.media-amazon.com/images/I/61OUGpUfAyL._AC_SY741_.jpg', 'https://www.youtube.com/watch?v=5PSNL1qE6VY', 2); --2
INSERT INTO movie ("title", "genre", realese_year, "director", "picture", "trailer", franchise_id) VALUES ('Ratatouille', 'Animation, Adventure, Family, Comedy, Fantasy', 2007, 'Brad Bird', 'http://cdn.shopify.com/s/files/1/0037/8008/3782/products/IMG_2309-439163.jpg?v=1611688243', 'https://www.youtube.com/watch?v=NgsQ8mVkN8w', 2); --3

-- Many to Many (One character in multiple movies)
INSERT INTO movie_character (movie_id, character_id) VALUES (1,1); --1
INSERT INTO movie_character (movie_id, character_id) VALUES (3,1); --2

-- Many to Many (One movie with multiple characters)
INSERT INTO movie_character (movie_id, character_id) VALUES (1,2); --1
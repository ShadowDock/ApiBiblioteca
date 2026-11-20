INSERT INTO author (name, nationality, birth_date) VALUES
('Machado de Assis', 'Brasileiro', '1839-06-21'),
('J.R.R Tolkien', 'British', '1892-01-03'),
('George Orwell', 'British', '1903-06-25');

INSERT INTO category (name) VALUES
('Romance'),
('Classic'),
('Fantasy'),
('Distopia');

INSERT INTO book (title, isbn, published_year, author_id) VALUES
('Dom Casmurro',                     '9788535910663', '1899', '1'),
('Memórias Póstumas de Brás Cubas',  '9788535911664', 1881, 1),  -- id 2, Machado
('The Hobbit',                       '9780547928227', 1937, 2),  -- id 3, Tolkien
('The Lord of the Rings',            '9780544003415', 1954, 2),  -- id 4, Tolkien
('1984',                             '9780451524935', 1949, 3);  -- id 5, Orwell

INSERT INTO book_category (book_id, category_id) VALUES
(1,1), (1,2),
(2, 1), (2, 2),
(3, 3),
(4,3), (4,2),
(5,4), (5,2);

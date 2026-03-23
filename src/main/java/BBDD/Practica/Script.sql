CREATE DATABASE tienda_libros;
USE tienda_libros;
-- Tabla autores
CREATE TABLE autores (
id INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(100),
pais VARCHAR(50)
);
-- Tabla libros
CREATE TABLE libros (
id INT AUTO_INCREMENT PRIMARY KEY,
titulo VARCHAR(150),
precio DECIMAL(6,2),
id_autor INT,
FOREIGN KEY (id_autor) REFERENCES autores(id)
);
-- Insertar autores
INSERT INTO autores (nombre, pais) VALUES
('Gabriel García Márquez', 'Colombia'),
('J.K. Rowling', 'Reino Unido'),
('George Orwell', 'Reino Unido');
-- Insertar libros
INSERT INTO libros (titulo, precio, id_autor) VALUES
('Cien años de soledad', 19.99, 1),
('Harry Potter y la piedra filosofal', 25.50, 2),
('1984', 15.00, 3);
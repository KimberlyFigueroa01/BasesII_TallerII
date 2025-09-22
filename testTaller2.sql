CREATE TABLE Editorial (
    id_editorial NUMBER PRIMARY KEY,
    nombre       VARCHAR2(100) NOT NULL,
    pais         VARCHAR2(50)
);


CREATE TABLE Libro (
    id_libro     NUMBER PRIMARY KEY,
    titulo       VARCHAR2(150) NOT NULL,
    anio_publicacion NUMBER(4),
    id_editorial NUMBER NOT NULL,
    CONSTRAINT fk_libro_editorial FOREIGN KEY (id_editorial) REFERENCES Editorial(id_editorial)
);


CREATE TABLE Ejemplar (
    id_ejemplar NUMBER PRIMARY KEY,
    codigo_barra VARCHAR2(30) NOT NULL,
    estado       VARCHAR2(20),
    id_libro     NUMBER NOT NULL,
    CONSTRAINT fk_ejemplar_libro FOREIGN KEY (id_libro) REFERENCES Libro(id_libro)
);

-- Insertar editoriales
INSERT INTO Editorial (id_editorial, nombre, pais) VALUES (1, 'Alfaguara', 'España');
INSERT INTO Editorial (id_editorial, nombre, pais) VALUES (2, 'Planeta', 'México');
INSERT INTO Editorial (id_editorial, nombre, pais) VALUES (3, 'Penguin Random House', 'Argentina');

-- Insertar libros (referenciando editoriales existentes)
INSERT INTO Libro (id_libro, titulo, anio_publicacion, id_editorial) VALUES (1, 'Cien años de soledad', 1967, 1);
INSERT INTO Libro (id_libro, titulo, anio_publicacion, id_editorial) VALUES (2, 'La sombra del viento', 2001, 2);
INSERT INTO Libro (id_libro, titulo, anio_publicacion, id_editorial) VALUES (3, 'Rayuela', 1963, 3);

-- Insertar ejemplares (referenciando libros existentes)
INSERT INTO Ejemplar (id_ejemplar, codigo_barra, estado, id_libro) VALUES (1, 'CB1001', 'Disponible', 1);
INSERT INTO Ejemplar (id_ejemplar, codigo_barra, estado, id_libro) VALUES (2, 'CB1002', 'Prestado', 1);
INSERT INTO Ejemplar (id_ejemplar, codigo_barra, estado, id_libro) VALUES (3, 'CB2001', 'Disponible', 2);
INSERT INTO Ejemplar (id_ejemplar, codigo_barra, estado, id_libro) VALUES (4, 'CB3001', 'Disponible', 3);

COMMIT;
SELECT * FROM EJEMPLAR;
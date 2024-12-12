-- Crear la base de datos
CREATE DATABASE GestionEventos;

/*Se crea un usuario para la base de datos llamado "usuario_prueba" y tiene la contraseña "Usuario_Clave."*/
create user 'usuario_eventos'@'%' identified by 'Admin123.';

/*Se asignan los prvilegios sobr ela base de datos TechShop al usuario creado */
grant all privileges on GestionEventos.* to 'usuario_eventos'@'%';
flush privileges;

USE GestionEventos;

-- Crear la tabla de roles
CREATE TABLE roles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

-- Crear la tabla de usuarios
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_completo VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    rol_id INT NOT NULL,
    FOREIGN KEY (rol_id) REFERENCES roles(id) ON DELETE CASCADE
);

-- Crear la tabla de eventos
CREATE TABLE eventos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    capacidad INT NOT NULL
);

-- Crear la tabla de reservas
CREATE TABLE reservas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    evento_id INT NOT NULL,
    fecha_reserva TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
    FOREIGN KEY (evento_id) REFERENCES eventos(id) ON DELETE CASCADE
);

-- Insertar datos iniciales en la tabla de roles
INSERT INTO roles (nombre) VALUES ('ADMINISTRADOR'), ('CLIENTE');

-- Insertar un administrador inicial
INSERT INTO usuarios (nombre_completo, email, password, rol_id)
VALUES ('Admin General', 'admineventos.com', '$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.', 1); -- Cambia la contraseña encriptada con bcrypt.
--Pass 123

-- Insertar eventos iniciales (opcional)
INSERT INTO eventos (nombre, descripcion, tipo, fecha_inicio, fecha_fin, capacidad)
VALUES 
    ('Concierto Rock', 'Un concierto de música rock.', 'Concierto', '2024-12-15', '2024-12-15', 500),
    ('Conferencia Tech', 'Evento de tecnología y startups.', 'Conferencia', '2024-12-20', '2024-12-21', 300),
    ('Taller de Fotografía', 'Aprende técnicas avanzadas de fotografía.', 'Taller', '2024-12-10', '2024-12-10', 50);

-- Verificar estructura
SHOW TABLES;

SELECT * FROM EVENTOS;

SELECT * FROM RESERVAS;

SELECT * FROM ROLES;

SELECT * FROM USUARIOS;

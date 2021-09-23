-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-08-2021 a las 22:13:15
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `productosmisiontic1`
--
CREATE DATABASE IF NOT EXISTS `productosmisiontic1` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `productosmisiontic1`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE `categoria` (
  `idCategoriaPk` int(11) NOT NULL,
  `nombreCategoria` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- RELACIONES PARA LA TABLA `categoria`:
--

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`idCategoriaPk`, `nombreCategoria`) VALUES
(1, 'Viveres'),
(2, 'Lacteos'),
(3, 'Carnicos'),
(4, 'Aseo'),
(5, 'Miscelaneos'),
(6, 'Bebidas'),
(7, 'Panaderia'),
(8, 'Papeleria');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

DROP TABLE IF EXISTS `producto`;
CREATE TABLE `producto` (
  `idProductoPk` int(11) NOT NULL,
  `nombreProducto` varchar(50) NOT NULL,
  `cantidadProducto` int(11) NOT NULL,
  `precioProducto` int(11) DEFAULT NULL,
  `idCategoriaFk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- RELACIONES PARA LA TABLA `producto`:
--   `idCategoriaFk`
--       `categoria` -> `idCategoriaPk`
--

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProductoPk`, `nombreProducto`, `cantidadProducto`, `precioProducto`, `idCategoriaFk`) VALUES
(1, 'Arroz', 100, 5800, 1),
(2, 'Leche', 40, 3500, 2),
(3, 'BonnYour', 25, 2500, 2),
(4, 'Costillas Zenu', 12, 9000, 3),
(5, 'Axion loza', 7, 9500, 4),
(6, 'Bimbo Tajado M', 10, 6500, 7),
(7, 'Pinza cabello', 12, 3000, 5),
(8, 'Pan Cascarita', 18, 2500, 7),
(9, 'QuesoMozarella', 12, 9000, 2),
(10, 'Huevos Carton', 7, 6500, 1),
(11, 'Arepas', 10, 6500, 1),
(12, 'Hilo colores', 12, 3000, 5);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`idCategoriaPk`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProductoPk`),
  ADD KEY `idCategoriaFk` (`idCategoriaFk`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `idCategoriaPk` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProductoPk` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`idCategoriaFk`) REFERENCES `categoria` (`idCategoriaPk`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

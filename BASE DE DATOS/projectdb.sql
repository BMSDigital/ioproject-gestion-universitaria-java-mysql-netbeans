

-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-11-2015 a las 06:33:26
-- Versión del servidor: 5.6.17-log
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `projectdb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignatura`
--

CREATE TABLE IF NOT EXISTS `asignatura` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `descripcion` varchar(160) NOT NULL,
  `h_teoricas` int(11) NOT NULL,
  `h_practicas` int(11) NOT NULL,
  `dur_teoricas` int(11) NOT NULL,
  `dur_practicas` int(11) NOT NULL,
  `uni_credito` int(2) NOT NULL,
  `cod_semestre` int(11) NOT NULL,
  `cod_carrera` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Volcado de datos para la tabla `asignatura`
--

INSERT INTO `asignatura` (`id`, `nombre`, `descripcion`, `h_teoricas`, `h_practicas`, `dur_teoricas`, `dur_practicas`, `uni_credito`, `cod_semestre`, `cod_carrera`) VALUES
(8, 'Cálculo', 'Introducción al Cálculo', 2, 0, 3, 1, 5, 1, 1),
(10, 'Inglés I', '', 2, 0, 3, 1, 3, 1, 1),
(11, 'CALCULO II', 'EEEEEEEEEEEED', 3, 0, 5, 1, 5, 2, 1),
(12, 'GGG', '', 3, 1, 2, 3, 1, 1, 1),
(13, 'GGG', '', 3, 1, 2, 3, 1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asigxespe`
--

CREATE TABLE IF NOT EXISTS `asigxespe` (
  `cod_carrera` varchar(10) NOT NULL,
  `codigo` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asigxsecc`
--

CREATE TABLE IF NOT EXISTS `asigxsecc` (
  `cod_asignatura` varchar(10) NOT NULL,
  `cod_seccion` varchar(10) NOT NULL,
  `cod_aula` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aula`
--

CREATE TABLE IF NOT EXISTS `aula` (
  `cod_aula` varchar(10) NOT NULL,
  `ubicacion` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bitacora`
--

CREATE TABLE IF NOT EXISTS `bitacora` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(15) NOT NULL,
  `fecha` varchar(20) NOT NULL,
  `hora` varchar(20) NOT NULL,
  `descripcion` varchar(40) NOT NULL,
  `resultado` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=81 ;

--
-- Volcado de datos para la tabla `bitacora`
--

INSERT INTO `bitacora` (`id`, `nombre`, `fecha`, `hora`, `descripcion`, `resultado`) VALUES
(43, 'oku', '2/11/2015', '19:56:43', 'Inicio de sesión en el sistema', 'Éxito'),
(44, 'oku', '2/11/2015', '20:7:2', 'Inicio de sesión en el sistema', 'Éxito'),
(45, 'oku', '2/11/2015', '20:27:28', 'Inicio de sesión en el sistema', 'Éxito'),
(46, 'oku', '2/11/2015', '21:12:14', 'Inicio de sesión en el sistema', 'Éxito'),
(47, 'oku', '4/11/2015', '0:0:12', 'Inicio de sesión en el sistema', 'Éxito'),
(48, 'oku', '4/11/2015', '0:8:1', 'Inicio de sesión en el sistema', 'Éxito'),
(49, 'oku', '4/11/2015', '0:11:27', 'Inicio de sesión en el sistema', 'Éxito'),
(50, 'oku', '5/11/2015', '11:4:31', 'Inicio de sesión en el sistema', 'Éxito'),
(51, 'oku', '5/11/2015', '12:7:19', 'Inicio de sesión en el sistema', 'Éxito'),
(52, 'oku', '5/11/2015', '12:20:47', 'Inicio de sesión en el sistema', 'Éxito'),
(53, 'oku', '5/11/2015', '12:21:4', 'Registro de usuario', 'Éxito'),
(54, 'yenderson', '5/11/2015', '12:21:34', 'Inicio de sesión en el sistema', 'Éxito'),
(55, 'oku', '9/11/2015', '8:12:21', 'Inicio de sesión en el sistema', 'Éxito'),
(56, 'OKU', '9/11/2015', '8:14:1', 'Inicio de sesión en el sistema', 'Éxito'),
(57, 'OKU', '9/11/2015', '8:18:49', 'Inicio de sesión en el sistema', 'Éxito'),
(58, 'OKU', '9/11/2015', '8:19:42', 'Registro de usuario', 'Éxito'),
(59, 'ADRIANA', '9/11/2015', '8:21:53', 'Inicio de sesión en el sistema', 'Éxito'),
(60, 'ADRIANA', '9/11/2015', '8:36:7', 'Registro de asignatura', 'Éxito'),
(61, 'ADRIANA', '9/11/2015', '8:38:52', 'Registro de asignatura', 'Éxito'),
(62, 'ADRIANA', '9/11/2015', '8:38:59', 'Registro de asignatura', 'Éxito'),
(63, 'ADRIANA', '9/11/2015', '8:44:16', 'Registro de profesor', 'Éxito'),
(64, 'ADRIANA', '9/11/2015', '8:45:53', 'Cambio de Status de profesor', 'Éxito'),
(65, 'ADRIANA', '9/11/2015', '8:46:3', 'Cambio de Status de profesor', 'Éxito'),
(66, 'adriana', '9/11/2015', '23:23:58', 'Inicio de sesión en el sistema', 'Éxito'),
(67, 'adriana', '9/11/2015', '23:25:15', 'Registro de usuario', 'FallóNo se pudo procesar la sentencia ( Erreur de syntaxe pr'),
(68, 'adriana', '9/11/2015', '23:27:22', 'Registro de usuario', 'FallóNo se pudo procesar la sentencia ( Erreur de syntaxe pr'),
(69, 'adriana', '9/11/2015', '23:32:40', 'Inicio de sesión en el sistema', 'Éxito'),
(70, 'adriana', '9/11/2015', '23:33:12', 'Registro de usuario', 'FallóNo se pudo procesar la sentencia ( Erreur de syntaxe pr'),
(71, 'adriana', '9/11/2015', '23:55:0', 'Inicio de sesión en el sistema', 'Éxito'),
(72, 'adriana', '9/11/2015', '23:55:30', 'Registro de usuario', 'Éxito'),
(73, 'adriana', '10/11/2015', '0:25:50', 'Inicio de sesión en el sistema', 'Éxito'),
(74, 'adriana', '10/11/2015', '0:27:45', 'Registro de usuario', 'Éxito'),
(75, 'YENDERSON', '10/11/2015', '0:29:48', 'Inicio de sesión en el sistema', 'Éxito'),
(76, 'YENDERSON', '10/11/2015', '0:34:21', 'Inicio de sesión en el sistema', 'Éxito'),
(77, 'YENDERSON', '10/11/2015', '0:34:37', 'Registro de usuario', 'Éxito'),
(78, 'YENDERSON', '10/11/2015', '0:44:16', 'Inicio de sesión en el sistema', 'Éxito'),
(79, 'yenderson', '10/11/2015', '0:49:15', 'Inicio de sesión en el sistema', 'Éxito'),
(80, 'yenderson', '10/11/2015', '0:59:14', 'Inicio de sesión en el sistema', 'Éxito');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bloque`
--

CREATE TABLE IF NOT EXISTS `bloque` (
  `cod/bloque` varchar(10) NOT NULL,
  `entrada` varchar(10) NOT NULL,
  `salida` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carrera`
--

CREATE TABLE IF NOT EXISTS `carrera` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `carrera`
--

INSERT INTO `carrera` (`id`, `nombre`) VALUES
(1, 'ING. SISTEMAS'),
(2, 'ING. ELECTRICA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudad`
--

CREATE TABLE IF NOT EXISTS `ciudad` (
  `cod_ciudad` varchar(10) NOT NULL,
  `desc_ciudad` varchar(100) NOT NULL,
  PRIMARY KEY (`cod_ciudad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle`
--

CREATE TABLE IF NOT EXISTS `detalle` (
  `id_factura` int(11) NOT NULL,
  `id_servicio` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`id_factura`,`id_servicio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `detalle`
--

INSERT INTO `detalle` (`id_factura`, `id_servicio`, `cantidad`) VALUES
(14, 6, 2),
(14, 7, 1),
(15, 4, 3),
(15, 6, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `direccion`
--

CREATE TABLE IF NOT EXISTS `direccion` (
  `cod_direccion` varchar(10) NOT NULL,
  `estado` varchar(50) NOT NULL,
  `ciudad` varchar(50) NOT NULL,
  `parroquia` varchar(50) NOT NULL,
  `municipio` varchar(20) NOT NULL,
  `calle` varchar(70) NOT NULL,
  `dirrecion` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidad`
--

CREATE TABLE IF NOT EXISTS `especialidad` (
  `cod_carrera` varchar(10) NOT NULL,
  `desc_carrera` varchar(160) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

CREATE TABLE IF NOT EXISTS `estado` (
  `cod_estado` varchar(10) NOT NULL,
  `desc_edo` varchar(100) NOT NULL,
  PRIMARY KEY (`cod_estado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE IF NOT EXISTS `factura` (
  `cod_factura` int(15) NOT NULL AUTO_INCREMENT,
  `id_cliente` int(11) NOT NULL,
  `monto_total` float NOT NULL,
  `fecha_fact` varchar(15) NOT NULL,
  `status_factura` varchar(15) NOT NULL,
  PRIMARY KEY (`cod_factura`,`id_cliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`cod_factura`, `id_cliente`, `monto_total`, `fecha_fact`, `status_factura`) VALUES
(1, 7351906, 250, '0000-00-00', 'A'),
(2, 1, 13.44, '2013-06-21', 'A'),
(3, 1, 112, '2013-06-21', 'A'),
(4, 1, 13.44, '2013/6/21', 'A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hijos`
--

CREATE TABLE IF NOT EXISTS `hijos` (
  `cedula` varchar(8) NOT NULL,
  `nomb_hijo` varchar(30) NOT NULL,
  `fecha_nac` varchar(10) NOT NULL,
  `sexo` varchar(8) NOT NULL,
  `ci_hijo` varchar(8) NOT NULL,
  `cant_hijo` int(11) NOT NULL,
  `grado_inst` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horario`
--

CREATE TABLE IF NOT EXISTS `horario` (
  `cod_horario` int(11) NOT NULL AUTO_INCREMENT,
  `cod_bloque` varchar(10) NOT NULL,
  `dia` date NOT NULL,
  `codigo` varchar(10) NOT NULL,
  PRIMARY KEY (`cod_horario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jornada`
--

CREATE TABLE IF NOT EXISTS `jornada` (
  `cod_jornada` int(11) NOT NULL AUTO_INCREMENT,
  `cod_aul` varchar(12) NOT NULL,
  `dia` date NOT NULL,
  `h_entrada` varchar(5) NOT NULL,
  `h_salida` varchar(5) NOT NULL,
  `cedula` varchar(10) NOT NULL,
  `semana` int(11) NOT NULL,
  `observacion` varchar(160) NOT NULL,
  PRIMARY KEY (`cod_jornada`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `localidad`
--

CREATE TABLE IF NOT EXISTS `localidad` (
  `cod_geografico` varchar(11) NOT NULL,
  `cod_estado` varchar(11) NOT NULL,
  `cod_ciudad` varchar(11) NOT NULL,
  `cod_municipio` varchar(11) NOT NULL,
  `cod_parroquia` varchar(11) NOT NULL,
  PRIMARY KEY (`cod_geografico`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `municipio`
--

CREATE TABLE IF NOT EXISTS `municipio` (
  `cod_municipio` varchar(11) NOT NULL,
  `desc_mcpio` varchar(100) NOT NULL,
  PRIMARY KEY (`cod_municipio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `novedad`
--

CREATE TABLE IF NOT EXISTS `novedad` (
  `cod_aula` varchar(10) NOT NULL,
  `cod_seccion` varchar(10) NOT NULL,
  `codigo` varchar(10) NOT NULL,
  `cedula` varchar(10) NOT NULL,
  `observacion` varchar(160) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nucleos`
--

CREATE TABLE IF NOT EXISTS `nucleos` (
  `cod_nucleo` varchar(12) NOT NULL,
  `sede` varchar(50) NOT NULL,
  `cod_geografico` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `parroquia`
--

CREATE TABLE IF NOT EXISTS `parroquia` (
  `cod_parroq` varchar(11) NOT NULL,
  `desc_parroq` varchar(100) NOT NULL,
  PRIMARY KEY (`cod_parroq`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor`
--

CREATE TABLE IF NOT EXISTS `profesor` (
  `cedula` varchar(10) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `apellido` varchar(60) NOT NULL,
  `sexo` varchar(10) NOT NULL,
  `edo_civil` varchar(10) NOT NULL,
  `fecha_nac` varchar(15) NOT NULL,
  `nacionalidad` varchar(20) NOT NULL,
  `sanguineo` varchar(10) NOT NULL,
  `celular` varchar(15) NOT NULL,
  `fijo` varchar(15) NOT NULL,
  `correo` varchar(40) NOT NULL,
  `cta_bancaria` varchar(20) NOT NULL,
  `ent_bancaria` varchar(30) NOT NULL,
  `profesion` varchar(20) NOT NULL,
  `titulos` varchar(40) NOT NULL,
  `especialidades` varchar(40) NOT NULL,
  `catedras` varchar(256) NOT NULL,
  `tipo_contrato` varchar(10) NOT NULL,
  `fecha_ingreso` varchar(15) NOT NULL,
  `status` char(1) NOT NULL,
  PRIMARY KEY (`cedula`),
  KEY `cedula` (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `profesor`
--

INSERT INTO `profesor` (`cedula`, `nombre`, `apellido`, `sexo`, `edo_civil`, `fecha_nac`, `nacionalidad`, `sanguineo`, `celular`, `fijo`, `correo`, `cta_bancaria`, `ent_bancaria`, `profesion`, `titulos`, `especialidades`, `catedras`, `tipo_contrato`, `fecha_ingreso`, `status`) VALUES
('1515', 'asd', 'asd', 'MASCULINO', 'SOLTERO', '19/06/94', '--', '--', 'null', '0416-32', 'null', 'null', 'BANESCO', 'www', 'ww', 'eee', 'asdasdxxx', 'TV', '15/05/06', 'a'),
('2121', 'adsa', 'asd', 'MASCULINO', 'SOLTERO', '19/06/94', '--', '--', '0251-32', '0416-3232', 'ad@HOTMAIL.COM', 'null', 'BANESCO', 'asd', 'asd', 'asd', 'asd', 'TV', '19/06/94', 'a'),
('23489190', 'ANA', 'PEREZ', 'FEMENINO', 'DIVORCIADO', '8/09/99', '--', 'A+', '0251-9876546', '0416-9875432', 'GHJIUJ@HOTMAIL.COM', 'null', 'CARIBE', 'INGENIERO CIVIL', 'DF', 'SWRR', 'CALCULO III', 'MT', '25/04/99', 'e');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profxasig`
--

CREATE TABLE IF NOT EXISTS `profxasig` (
  `cedula` varchar(8) NOT NULL,
  `codigo` varchar(10) NOT NULL,
  `cod_horario` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `region`
--

CREATE TABLE IF NOT EXISTS `region` (
  `cod_region` varchar(10) NOT NULL,
  `nomb_region` varchar(20) NOT NULL,
  PRIMARY KEY (`cod_region`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seccion`
--

CREATE TABLE IF NOT EXISTS `seccion` (
  `cod_seccion` varchar(10) NOT NULL,
  `semestre` varchar(10) NOT NULL,
  `cod_carrera` varchar(10) NOT NULL,
  `cod_turno` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `semestre`
--

CREATE TABLE IF NOT EXISTS `semestre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `cod_carrera` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `semestre`
--

INSERT INTO `semestre` (`id`, `nombre`, `cod_carrera`) VALUES
(1, 'PRIMER SEMESTRE', 1),
(2, 'SEGUNDO SEMESTRE', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE IF NOT EXISTS `servicio` (
  `id_servicio` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `precio` float NOT NULL,
  `descripcion` varchar(158) NOT NULL,
  PRIMARY KEY (`id_servicio`),
  UNIQUE KEY `nombre_2` (`nombre`),
  KEY `nombre` (`nombre`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Volcado de datos para la tabla `servicio`
--

INSERT INTO `servicio` (`id_servicio`, `nombre`, `precio`, `descripcion`) VALUES
(1, '//Seleccione//', 0, ''),
(2, 'Volantes', 2.5, 'volante de publicidad'),
(3, 'tarjetas', 5, 'tarjetas de presentacion'),
(4, 'diseño ', 250, 'diseño de publicidad'),
(5, 'Pendon Pequeño', 120, 'Tamaño 25x10'),
(6, 'Pendon Grande', 300, 'Tamaño 60x30'),
(7, 'Pendon Mediano', 200, 'Tamaño 45x20 '),
(8, 'pantalon', 100, 'cuero'),
(9, 'panela', 15, 'producto comestible');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tabla`
--

CREATE TABLE IF NOT EXISTS `tabla` (
  `nombre` varchar(20) NOT NULL,
  `cedula` varchar(20) NOT NULL,
  `entero` int(11) NOT NULL,
  PRIMARY KEY (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tabla`
--

INSERT INTO `tabla` (`nombre`, `cedula`, `entero`) VALUES
('hola', 'mundo', 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turno`
--

CREATE TABLE IF NOT EXISTS `turno` (
  `cod_turno` varchar(10) NOT NULL,
  `desc_turno` varchar(150) NOT NULL,
  PRIMARY KEY (`cod_turno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `passw` varchar(20) NOT NULL,
  `tipo` int(11) NOT NULL,
  `nombres` varchar(40) NOT NULL,
  `apellidos` varchar(40) NOT NULL,
  `email` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `passw`, `tipo`, `nombres`, `apellidos`, `email`) VALUES
(1, 'oku', '3205', 1, '', '', ''),
(2, 'yenderson', '12345', 0, '', '', ''),
(3, 'ADRIANA', '1213', 0, '', '', ''),
(6, 'yenderson', '123456', 2, 'yenderson josean', 'lopez barreto', 'yenderson_de_gonzalez_011213@hotmail.com'),
(7, '', '', 1, '', '', '');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
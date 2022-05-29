CREATE DATABASE  IF NOT EXISTS `eldenringcalculator` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `eldenringcalculator`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: eldenringcalculator
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `buildclasses`
--

DROP TABLE IF EXISTS `buildclasses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `buildclasses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `level` int NOT NULL,
  `dexterity` int NOT NULL,
  `strength` int NOT NULL,
  `intelect` int NOT NULL,
  `faith` int NOT NULL,
  `arcane` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buildclasses`
--

LOCK TABLES `buildclasses` WRITE;
/*!40000 ALTER TABLE `buildclasses` DISABLE KEYS */;
INSERT INTO `buildclasses` VALUES (1,'Heroe',7,9,16,7,8,11),(2,'Bandido',5,13,9,9,8,14),(3,'Astrologo',6,12,8,16,7,9),(4,'Guerrero',8,16,10,10,8,9),(5,'Prisionero',9,14,11,14,6,9),(6,'Confesor',10,12,12,9,14,9),(7,'Miserable',1,10,10,10,10,10),(8,'Vagante',9,13,14,9,9,7),(9,'Profeta',7,10,11,7,16,10),(10,'Samurai',9,12,15,9,8,8);
/*!40000 ALTER TABLE `buildclasses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `builds`
--

DROP TABLE IF EXISTS `builds`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `builds` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(250) DEFAULT NULL,
  `buildclass` int NOT NULL,
  `level` int NOT NULL DEFAULT '0',
  `dexterity` int NOT NULL DEFAULT '0',
  `strength` int NOT NULL DEFAULT '0',
  `intelect` int NOT NULL DEFAULT '0',
  `faith` int NOT NULL DEFAULT '0',
  `arcane` int NOT NULL DEFAULT '0',
  `weapon1` bigint DEFAULT NULL,
  `weapon2` bigint DEFAULT NULL,
  `createdby` bigint NOT NULL,
  `created` date NOT NULL,
  `state` bigint NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `fk_weapon1` (`weapon1`),
  KEY `fk_weapon2` (`weapon2`),
  KEY `build_FK` (`buildclass`),
  KEY `build_FK_1` (`createdby`),
  KEY `build_FK_2` (`state`),
  CONSTRAINT `build_FK` FOREIGN KEY (`buildclass`) REFERENCES `buildclasses` (`id`),
  CONSTRAINT `build_FK_1` FOREIGN KEY (`createdby`) REFERENCES `users` (`id`),
  CONSTRAINT `build_FK_2` FOREIGN KEY (`state`) REFERENCES `buildstates` (`id`),
  CONSTRAINT `fk_weapon1` FOREIGN KEY (`weapon1`) REFERENCES `weapons` (`id`),
  CONSTRAINT `fk_weapon2` FOREIGN KEY (`weapon2`) REFERENCES `weapons` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `builds`
--

LOCK TABLES `builds` WRITE;
/*!40000 ALTER TABLE `builds` DISABLE KEYS */;
INSERT INTO `builds` VALUES (103,'Vamos allá',1,47,27,16,16,8,24,1,6,1,'2022-04-25',1),(104,'muertin',10,30,33,15,9,8,8,1,1,2,'2022-04-25',1),(105,'hola',1,90,31,16,29,24,34,4,2,1,'2022-04-25',1),(106,'el mago ole ole',1,85,9,16,31,34,39,29,NULL,1,'2022-04-25',1),(107,'vivin',1,64,40,42,7,8,11,9,8,2,'2022-04-25',1),(109,'la parcaa',1,79,33,28,7,26,29,14,15,2,'2022-04-25',2),(110,'',1,64,9,38,7,43,11,10,24,2,'2022-04-25',2),(111,'la build del admin',1,451,99,99,99,99,99,18,20,1,'2022-04-25',1),(112,'ratita',9,68,27,34,28,16,10,17,11,3,'2022-04-25',1),(113,'Meelia',1,101,9,16,40,36,44,29,9,3,'2022-04-25',1),(114,'Cercenadora de trasgos',3,56,41,29,16,7,9,1,20,3,'2022-04-25',1),(115,'Uma',1,64,9,16,7,39,37,24,24,3,'2022-04-25',1),(116,'a puñetazos',1,90,9,99,7,8,11,NULL,NULL,3,'2022-04-25',1),(117,'Uma',1,64,9,16,7,39,37,24,24,3,'2022-04-25',2),(118,'No se que mas crear',6,10,12,12,9,14,9,5,5,1,'2022-04-25',1),(119,'Real madrid',1,53,34,37,7,8,11,23,23,1,'2022-04-25',1),(120,'Real madrid',1,53,34,37,7,8,11,23,23,1,'2022-04-25',2),(121,'la build del admin pro',1,451,99,99,99,99,99,18,20,1,'2022-04-25',1),(129,'prueba',4,12,20,10,10,8,9,8,53,2,'2022-05-02',1),(145,'muertin2',7,8,13,10,14,10,10,23,23,2,'2022-05-02',1),(149,'holllaaa',4,16,20,10,10,12,9,24,57,2,'2022-05-29',1);
/*!40000 ALTER TABLE `builds` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `buildstates`
--

DROP TABLE IF EXISTS `buildstates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `buildstates` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buildstates`
--

LOCK TABLES `buildstates` WRITE;
/*!40000 ALTER TABLE `buildstates` DISABLE KEYS */;
INSERT INTO `buildstates` VALUES (1,'PUBLICO'),(2,'PRIVADO');
/*!40000 ALTER TABLE `buildstates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ADMIN'),(2,'USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `username` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin@eldenringcalculator.com','admin','$2a$12$4ya6wPRiQqsixzgeF/c.PeOBFeIfwMkHGmE88OBmyMwruGQMbqiOu'),(2,'ivanciudad98@gmail.com','ivan','$2a$12$OiXCbraQZZT7eSKcMGNabOcH1BPD8Ij3pdyx3SRkfCUZpl5rQ0Iuu'),(3,'aaron@mail.com','aaron','$2a$12$ZlLrynHYS7iOyRvJXiVPHOc0cbz7aVe.dmJebvdVr7J/irKBAuAMW'),(70,'prueba@gmail.com','demo','$2a$10$QnA8L/ApJvqsa6V1K4Y/9./1UX6e12SRlyaSuHNKTrpoLlrtPITcC'),(71,'pablito@mail.com','elrompecoños','$2a$10$b0i214ZhJs8SA4dMdRZaJOIF6Rjwzj2yB/8K2OTPXvmEoZcpzGj.u'),(72,'prueba@mail.com','pruebavelocidad','$2a$10$e60NJi0gsFjsID0nDumNq.GuchGz2dwV4sAW9yBoI7ygOalbMsRWe'),(73,'agusciudad@hotmail.com','agus','$2a$10$b34aO/3Q2PljK1Io9BiQyuplcZSIigRJt8HHjK6lMDKKdqR0wNX2G');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_roles` (
  `user` bigint NOT NULL,
  `role` bigint NOT NULL,
  KEY `user_role_FK` (`role`),
  KEY `user_role_FK_1` (`user`),
  CONSTRAINT `user_role_FK` FOREIGN KEY (`role`) REFERENCES `roles` (`id`),
  CONSTRAINT `user_role_FK_1` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (1,1),(1,2),(2,2),(3,2),(70,2),(71,2),(72,2),(73,2);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weapons`
--

DROP TABLE IF EXISTS `weapons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `weapons` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '-',
  `photo` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '-',
  `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '-',
  `weaponType` bigint NOT NULL,
  `dexReq` int NOT NULL DEFAULT '0',
  `strengReq` int NOT NULL DEFAULT '0',
  `intReq` int NOT NULL DEFAULT '0',
  `faithReq` int NOT NULL DEFAULT '0',
  `arcaneReq` int NOT NULL DEFAULT '0',
  `dexScaling` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '-',
  `strengScaling` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '-',
  `intScaling` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '-',
  `faithScaling` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '-',
  `arcaneScaling` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '-',
  `weight` float DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idweapon_UNIQUE` (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `weapon_FK` (`weaponType`),
  CONSTRAINT `weapon_FK` FOREIGN KEY (`weaponType`) REFERENCES `weapontypes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weapons`
--

LOCK TABLES `weapons` WRITE;
/*!40000 ALTER TABLE `weapons` DISABLE KEYS */;
INSERT INTO `weapons` VALUES (1,'Uchigatana','noPhoto.png','Una katana con una larga hoja curva de un solo filo.\r\nUn arma única empuñada por los samuráis de la Tierra de los Juncos.\r\n\r\nLa hoja, con su diseño ondulado, cuenta con una nitidez extraordinaria, y sus ataques cortantes provocan la pérdida de sangre.',1,15,11,0,0,0,'D','D','-','-','-',5.5),(2,'Sangre de rios','noPhoto.png','Arma de Okina, espadachín del País de los Juncos.',1,18,12,0,0,20,'D','B','-','-','D',6.5),(4,'Reduvia','Reduvia.png','Daga dentada con una hoja rizada distintiva.\r\nLlevado por los nobles servidores del Señor de la Sangre.\r\n\r\nEsta daga desgarra la carne al entrar, infligiendo pérdida de sangre con una eficacia repugnante. Un testimonio orgulloso del éxito de su diseño vicioso, esta arma está siempre cubierta de sangre.',8,13,5,0,0,13,'D','E','-','-','D',2.5),(5,'Cuchillo de cristal','CuchilloCristal.png','Un cuchillo hecho afilando cristal duro.\r\nArma distintiva de los mineros de glintstone.\r\n\r\nSe utiliza como herramienta para extraer destellos de rocas rotas y, como tal, una débil magia envuelve la hoja.',8,12,8,9,0,0,'D','D','D','-','-',2),(6,'Arco de cuerno','ArcoCuerno.png','Arco largo hecho de cuerno de animal. Esgrimido por los maestros cazadores de los seguidores ancestrales.\r\n\r\nImbuye flechas disparadas con daño mágico.\r\nRevela su verdadero valor cuando se usan flechas infundidas con magia.',9,14,10,12,0,0,'D','E','-','-','-',6),(7,'Velo lunar','VeloLuna.png','Katana forjada de glintstone.\r\nObra maestra de un artífice de la palabra Sellian.\r\n\r\nLa luz envuelve la hoja cuando está envainada, lo que explica su apodo Moonveil.',2,18,12,23,0,0,'D','E','C','-','-',6.5),(8,'Escudo redondo de hierro','EscRedHierr.png','Un escudo redondo pequeño ordinario hecho de metal. Más pesado que un escudo de madera, pero cuenta con una mayor negación de daño.\r\n\r\nFinamente equilibrado, este escudo es fácil de usar.',11,0,8,0,0,0,'-','E','-','-','-',3),(9,'Escudo de latón','EscLaton.png','En el lado más grande para escudo de tamaño mediano, la cara ha sido\r\ncubierto de latón.\r\n\r\nComúnmente empleado en el Destrozamiento.',11,0,16,0,0,0,'-','D','-','-','-',7),(10,'Gran escudo dorado','EscDor.png','Escudo grande de metal recubierto de oro. Llevado por caballeros leales a\r\nGodrick.\r\n\r\nEl tinte rojo en la capa de oro refleja la materia primordial que\r\nse convirtió en el Erdtree. El color del anhelo de regreso a casa.',11,0,36,0,0,0,'-','D','-','-','-',17.5),(11,'Claymore','Claymore.png','Una gran espada con una hoja larga y recta. Esta espada pesada generalmente se empuña con las dos manos, pero para aquellos con suficiente fuerza, una es suficiente.\r\n\r\nAdemás de los fuertes ataques de barrido, también puede realizar un fuerte golpe de penetración, lo que la convierte en un arma versátil.',1,13,16,0,0,0,'D','D','-','-','-',9),(12,'Hoja negra de gargola','Gargola.png','Espadón de bronce empuñado por Valiant Gargoyle reparado con cera de cadáver ennegrecida. Inflige daño sagrado.\r\n\r\nTal es la marca de aquellos que sirven a Maliketh, la Espada Negra.',1,10,18,0,22,0,'E','D','-','D','-',11.5),(13,'Espada del señor de Alabastro','Alabaster.png','Espadón forjado a partir de un mineral meteórico blanco azulado.\r\nLa hoja oculta magia que manipula la gravedad.\r\n\r\nUn arma exclusiva de los Señores de Alabastro, una raza de antiguos con\r\npiel de piedra que se decía que habían resucitado cuando un meteorito\r\ngolpeado hace mucho tiempo.',1,12,16,18,0,0,'E','D','D','-','-',8),(14,'Guadaña','Guada.png','Guadaña grande con una hoja larga y delgada. Diseñada para cosechar, esta arma es capaz de infligir una rápida pérdida de sangre mientras se desliza a través de la guardia del enemigo.\r\n\r\nEn manos de un portador muy diestro, es capaz de infundir miedo en el corazón de cualquier enemigo.',3,14,14,0,0,0,'C','E','-','-','-',7.5),(15,'Guadaña Aurea','GuadaAurea.png','Guadaña de guerra de los Cleanrot Knights que lucharon junto a Malenia, Blade of Miquella.\r\n\r\nEsta era el arma de los comandantes del ejército de Malenia, y la hoja de medio halo inflige daño sagrado.',3,16,13,0,15,0,'D','D','-','E','-',8.5),(16,'Guadaña de tumbas','GuadaTumb.png','Gran guadaña compuesta por una hoja grande unida a un palo torcido. Arma empuñada por los ancianos guardianes de tumbas que atienden los cementerios olvidados a lo largo de las Tierras Intermedias. Se dice que esta arma sirvió como amuleto contra los malos espíritus en la antigüedad.',3,13,17,0,0,0,'D','D','-','-','-',9.5),(17,'Hacha de guerra','BattleAxe.png','Una hoja gruesa y pesada unida a un mango. Un arma versátil y estándar.\r\nCapaces de realizar poderosos ataques gracias a la pesada hoja, estas armas también son apreciadas por sus poderosos ataques de carga.',4,8,12,0,0,0,'D','D','-','-','-',4.5),(18,'Hoja Ondulada','HojaOndu.png','Arma única empuñada por jóvenes albinaúricos, esta espada es\r\nmodelado a partir de las ondas que se cree que son el origen de su\r\nespecies.\r\n\r\nSu poder de ataque se mejora enormemente con el atributo arcano de uno.',4,11,11,0,0,20,'-','-','-','-','A',4.5),(19,'Hacha de Rosus','HachaRosus.png','El ujier de la muerte, Rosus, que muestra el camino a las catacumbas a lo largo de las Tierras Intermedias, está representado en este hacha ritual.\r\n\r\nLos muertos se extravían fácilmente y siempre han tenido una gran necesidad de una mano que los guíe.',4,10,18,18,0,0,'E','D','D','-','-',5.5),(20,'Colmillo de sabueso','ColmilloSab.png','Espadón curvo con una hoja suavemente ondulada empuñada por\r\nCaballeros sabuesos.\r\n\r\nUna hoja temible capaz de ataques aéreos brutales.',5,17,18,0,0,0,'C','D','-','-','-',11.5),(21,'Espada maldita de Morgott','Morgott.png','Hoja retorcida de tonalidad cambiante utilizada por Morgott, el Rey del Presagio.\r\n\r\nLa sangre acusada de la que Morgott se retractó y selló se reformó en esta espada.',5,35,14,0,0,17,'C','E','-','-','D',7.5),(22,'Vara de cristal','VaraCris.png','Bastón hecho de cristal puro; un hecho imposible para un humano. Mejora la hechicería de Crystalian.\r\n\r\nLa débil cognición de Crystalian se conoce como la \"sabiduría de la piedra\". Este bastón solo puede ser usado por aquellos con un intelecto lo suficientemente alto como para captar tal sabiduría.',10,0,8,48,0,0,'-','D','B','-','-',4.5),(23,'Katar','Katar.png','Diseño de daga importada con un mango bastante único. La hoja se puede balancear como la extensión del puño.',6,10,8,0,0,0,'D','D','-','-','-',2.5),(24,'Cestus','Cestus.png','Arma para luchar con los puños, hecha de tiras de cuero con remaches de hierro.\r\nAl equiparla a dos manos, se coloca un cestus en cada mano.',6,8,8,0,0,0,'D','D','-','-','-',9),(25,'Lanza','Lanza.png','Arma compuesta por una hoja unida a un mango largo.\r\n\r\nEs un arma perforante de largo alcance que puede empuñarse detrás de la seguridad de un escudo elevado. Muy efectivo contra enemigos montados.',7,15,12,0,0,0,'D','E','-','-','-',4.5),(26,'Girandole del inquisidor','Girandole.png','Instrumento de tortura usado en nobles detrás de la cortina en el\r\nVolcano Manor del Monte Gelmir.\r\n\r\nSus numerosas púas perforan la carne, luego chamuscan las heridas con\r\nfuego. El olor a sangre quemada induce a la desesperación en la víctima. A\r\ncandelabro concebido por una mente completa.',7,15,18,0,16,0,'D','D','-','D','-',7.5),(27,'Arco de serpiente','ArcoSerpiente.png','Malformed bow in the shape of a pair of poisonous snakes. Imbues arrows with poison through pagan magic, revealing its true worth when used with poison-infused arrows.\r\nUsed by assassins known as the Formless Serpents.',9,15,8,0,0,11,'D','E','D','-','-',3.5),(28,'Arco negro','ArcoNegro.png','Arco largo tallado en madera negra para parecerse a una espada. Uno de los arcos más difíciles de dominar.\r\n\r\nEl cuerpo en forma de cuchilla del arco es ligero y corta el aire.\r\nAunque es un arco largo, se puede manejar de manera similar a un arco corto.',9,20,9,0,0,0,'D','E','-','-','-',4),(29,'Vara de astrologo','VaraAst.png','Bastón de los astrólogos. Una piedra brillante está incrustada en la punta, lo que le permite usarse como catalizador para hechicerías.\r\n\r\nLos hechizos deben memorizarse primero en un sitio de gracia perdida, y se debe equipar un bastón para lanzarlos.',10,0,7,16,0,0,'-','E','C','-','-',3),(30,'Cetro regio de cario','CetroReg.png','Cetro mágico de Rennala, Reina de la Luna Llena. La piedra brillante se conoce como Carian Blue, que realza las hechicerías de luna llena.\r\n\r\nSolo aquellos con la más alta inteligencia pueden empuñar este, el mejor de todos los bastones de brillo.',10,10,8,60,0,0,'E','E','B','-','-',3),(31,'Vara de piedra billante azur','VaraBrillAzur.png','Bastón del hechicero primigenio Azur. Solo aquellos que han vislumbrado lo que hay más allá de la sabiduría de la piedra pueden empuñarla.\r\nReduce el tiempo de lanzamiento de todos los hechizos, pero consume FP adicional.',10,0,10,52,0,0,'-','D','B','-','-',4),(53,'estavezsi','noPhoto.png','no ase daño',2,0,0,0,0,0,'-','-','-','-','-',0),(54,'Pepino','noPhoto.png','El poder de Picker Riiiiiiiiick.\n\nEs el arma con más peso.',5,23,10,10,2,20,'S','-','D','-','A',9),(55,'Mosquito','noPhoto.png','Me ha picao un mosquito',8,1,1,1,1,1,'C','B','-','-','B',1),(56,'mysql','noPhoto.png','',2,0,0,0,0,0,'-','-','-','-','-',2),(57,'gvzfddg','noPhoto.png','',4,0,0,0,0,0,'-','-','-','-','-',2),(58,'prtyr','noPhoto.png','dfsdfadfafad',4,0,0,24,0,0,'C','A','-','-','-',2),(61,'Uchigatana2','noPhoto.png','',2,0,0,0,0,0,'-','-','-','-','-',2),(62,'Uchigatana3','noPhoto.png','',3,0,0,0,0,0,'-','-','-','-','-',2),(63,'Hola','noPhoto.png','',1,0,0,0,0,0,'-','-','-','-','-',1),(64,'Platano','noPhoto.png','',3,2,50,23,50,10,'-','S','A','-','B',1),(65,'Arma Demo','noPhoto.png','',4,0,43,12,0,23,'C','-','-','-','-',1),(66,'Super Arma de demo','noPhoto.png','',1,40,0,34,0,0,'B','-','-','-','-',1),(67,'Ultra Demo','noPhoto.png','',1,0,23,0,0,12,'-','B','-','-','-',1),(68,'Pruebita','noPhoto.png','',1,0,0,0,23,34,'A','-','-','-','-',1),(69,'Arma Prueba','noPhoto.png','',1,0,23,23,0,0,'-','-','B','B','-',1),(70,'DemoNoArma','b2278012-d466-4e64-9f4e-26e08f04ddf7_eclipseIDE.png','',1,21,24,0,0,0,'-','-','A','-','-',1),(71,'AdminPrueba','4f498cb2-539d-4634-8c64-38a9e6d105c9_eclipseIDE.png','',1,0,23,34,0,0,'-','-','-','A','-',1),(74,'Uchigatana22','noPhoto.png','',1,23,0,0,0,0,'-','-','-','-','-',1),(76,'holala','e0556867-be37-464f-b98b-ccf9c20a778e_mistborn.jpg','wsdasdadasdasdadssa',4,2,0,0,5,12,'B','-','-','C','-',2),(77,'holila','189c7bb5-e29c-4180-a7b2-9d0e48063f9c_mistborn.jpg','',4,23,0,0,0,0,'A','-','-','-','-',1);
/*!40000 ALTER TABLE `weapons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weapontypes`
--

DROP TABLE IF EXISTS `weapontypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `weapontypes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weapontypes`
--

LOCK TABLES `weapontypes` WRITE;
/*!40000 ALTER TABLE `weapontypes` DISABLE KEYS */;
INSERT INTO `weapontypes` VALUES (1,'ESPADON'),(2,'KATANA'),(3,'GUADAÑA'),(4,'HACHA'),(5,'ESPADON CURVO'),(6,'GARRAS'),(7,'LANZA'),(8,'DAGA'),(9,'ARCO'),(10,'VARA'),(11,'SHIELD');
/*!40000 ALTER TABLE `weapontypes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-29 13:17:30

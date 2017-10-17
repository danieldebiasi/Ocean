-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: ocean
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cidades`
--

DROP TABLE IF EXISTS `cidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cidades` (
  `cod_cidade` int(11) NOT NULL,
  `cidade` text NOT NULL,
  `estado` tinytext NOT NULL,
  PRIMARY KEY (`cod_cidade`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidades`
--

LOCK TABLES `cidades` WRITE;
/*!40000 ALTER TABLE `cidades` DISABLE KEYS */;
INSERT INTO `cidades` VALUES (220,'Aracaju','Sergipe'),(228,'Florianópolis','Santa Catarina'),(229,'Fortaleza','Ceará'),(231,'João Pessoa','Paraíba'),(232,'Macapá','Amapá'),(233,'Maceió','Alagoas'),(235,'Natal','Rio Grande do Norte'),(239,'Recife','Pernambuco'),(241,'Rio de Janeiro','Rio de Janeiro'),(242,'Salvador','Bahia'),(243,'São Luís','Maranhão'),(246,'Vitória','Espírito Santo'),(267,'Acaraú','Ceará'),(341,'Alcântara','Maranhão'),(345,'Alcobaça','Bahia'),(430,'Amapá','Amapá'),(447,'Amontada','Ceará'),(468,'Anchieta','Espírito Santo'),(486,'Angra dos Reis','Rio de Janeiro'),(524,'Apicum-Açu','Maranhão'),(535,'Aquiraz','Ceará'),(541,'Aracati','Ceará'),(549,'Aracruz','Espírito Santo'),(565,'Araioses','Maranhão'),(583,'Araquari','Santa Catarina'),(585,'Araranguá','Santa Catarina'),(593,'Araruama','Rio de Janeiro'),(612,'Areia Branca','Rio Grande do Norte'),(628,'Armação dos Búzios','Rio de Janeiro'),(634,'Arraial do Cabo','Rio de Janeiro'),(666,'Augusto Corrêa','Pará'),(690,'Bacuri','Maranhão'),(696,'Baía da Traição','Paraíba'),(697,'Baía Formosa','Rio Grande do Norte'),(707,'Balneário Arroio do Silva','Santa Catarina'),(708,'Balneário Barra do Sul','Santa Catarina'),(709,'Balneário Camboriú','Santa Catarina'),(710,'Balneário Gaivota','Santa Catarina'),(711,'Balneário Pinhal','Rio Grande do Sul'),(753,'Barra de Santo Antônio','Alagoas'),(756,'Barra de São Miguel','Alagoas'),(772,'Barra dos Coqueiros','Sergipe'),(776,'Barra Velha','Santa Catarina'),(784,'Barreirinhas','Maranhão'),(785,'Barreiros','Pernambuco'),(794,'Barroquinha','Ceará'),(808,'Beberibe','Ceará'),(827,'Belmonte','Bahia'),(851,'Bertioga','São Paulo'),(861,'Biguaçu','Santa Catarina'),(939,'Bombinhas','Santa Catarina'),(975,'Bragança','Pará'),(1005,'Brejo Grande','Sergipe'),(1056,'Cabedelo','Paraíba'),(1058,'Cabo de Santo Agostinho','Pernambuco'),(1059,'Cabo Frio','Rio de Janeiro'),(1116,'Caiçara do Norte','Rio Grande do Norte'),(1120,'Cairu','Bahia'),(1131,'Cajueiro da Praia','Piauí'),(1135,'Calçoene','Amapá'),(1146,'Camaçari','Bahia'),(1164,'Camocim','Ceará'),(1220,'Campos dos Goytacazes','Rio de Janeiro'),(1232,'Cananéia','São Paulo'),(1240,'Canavieiras','Bahia'),(1242,'Candeias','Bahia'),(1249,'Cândido Mendes','Maranhão'),(1257,'Canguaretama','Rio Grande do Norte'),(1279,'Capão da Canoa','Rio Grande do Sul'),(1315,'Caraguatatuba','São Paulo'),(1322,'Carapebus','Rio de Janeiro'),(1329,'Caravelas','Bahia'),(1378,'Carutapera','Maranhão'),(1386,'Cascavel','Ceará'),(1390,'Casimiro de Abreu','Rio de Janeiro'),(1426,'Caucaia','Ceará'),(1433,'Ceará-Mirim','Rio Grande do Norte'),(1434,'Cedral','Maranhão'),(1486,'Chaves','Pará'),(1501,'Cidreira','Rio Grande do Sul'),(1551,'Conceição da Barra','Espírito Santo'),(1576,'Conde','Paraíba'),(1577,'Conde','Bahia'),(1652,'Coruripe','Alagoas'),(1694,'Cruz','Ceará'),(1739,'Curuçá','Pará'),(1740,'Cururupu','Maranhão'),(1855,'Duque de Caxias','Rio de Janeiro'),(1890,'Entre Rios','Bahia'),(1925,'Esplanada','Bahia'),(1928,'Estância','Sergipe'),(1951,'Extremoz','Rio Grande do Norte'),(1986,'Feliz Deserto','Alagoas'),(1991,'Fernando de Noronha','Pernambuco'),(2050,'Fortim','Ceará'),(2085,'Fundão','Espírito Santo'),(2091,'Galinhos','Rio Grande do Norte'),(2100,'Garopaba','Santa Catarina'),(2131,'Godofredo Viana','Maranhão'),(2134,'Goiana','Pernambuco'),(2155,'Governador Celso Ramos','Santa Catarina'),(2182,'Grossos','Rio Grande do Norte'),(2198,'Guamaré','Rio Grande do Norte'),(2205,'Guapimirim','Rio de Janeiro'),(2231,'Guarapari','Espírito Santo'),(2233,'Guaraqueçaba','Paraná'),(2239,'Guaratuba','Paraná'),(2245,'Guarujá','São Paulo'),(2253,'Guimarães','Maranhão'),(2283,'Humberto de Campos','Maranhão'),(2338,'Icapuí','Ceará'),(2339,'Içara','Santa Catarina'),(2342,'Icatu','Maranhão'),(2359,'Igarassu','Pernambuco'),(2362,'Igrapiúna','Bahia'),(2367,'Iguape','São Paulo'),(2376,'Ilha Comprida','São Paulo'),(2378,'Ilha Grande','Piauí'),(2380,'Ilhabela','São Paulo'),(2381,'Ilhéus','Bahia'),(2388,'Imbé','Rio Grande do Sul'),(2390,'Imbituba','Santa Catarina'),(2449,'Ipojuca','Pernambuco'),(2502,'Itaboraí','Rio de Janeiro'),(2507,'Itacaré','Bahia'),(2517,'Itaguaí','Rio de Janeiro'),(2535,'Itajaí','Santa Catarina'),(2542,'Ilha de Itamaracá','Pernambuco'),(2557,'Itanhaém','São Paulo'),(2567,'Itaparica','Bahia'),(2574,'Itapema','Santa Catarina'),(2575,'Itapemirim','Espírito Santo'),(2585,'Itapipoca','Ceará'),(2595,'Itapoá','Santa Catarina'),(2601,'Itaporanga d\'Ajuda','Sergipe'),(2615,'Itarema','Ceará'),(2646,'Ituberá','Bahia'),(2667,'Jaboatão dos Guararapes','Pernambuco'),(2705,'Jaguaripe','Bahia'),(2708,'Jaguaruna','Santa Catarina'),(2719,'Jandaíra','Bahia'),(2726,'Japaratinga','Alagoas'),(2784,'Jijoca de Jericoacoara','Ceará'),(2917,'Laguna','Santa Catarina'),(2950,'Lauro de Freitas','Bahia'),(2985,'Linhares','Espírito Santo'),(3002,'Lucena','Paraíba'),(3007,'Luís Correia','Piauí'),(3008,'Luís Domingues','Maranhão'),(3025,'Macaé','Rio de Janeiro'),(3033,'Macau','Rio Grande do Norte'),(3047,'Madre de Deus','Bahia'),(3053,'Magalhães Barata','Pará'),(3056,'Magé','Rio de Janeiro'),(3089,'Mangaratiba','Rio de Janeiro'),(3113,'Maracanã','Pará'),(3116,'Maragogi','Alagoas'),(3122,'Marapanim','Pará'),(3125,'Marataízes','Espírito Santo'),(3127,'Maraú','Bahia'),(3131,'Marcação','Paraíba'),(3140,'Marechal Deodoro','Alagoas'),(3154,'Maricá','Rio de Janeiro'),(3188,'Mata de São João','Bahia'),(3193,'Mataraca','Paraíba'),(3205,'Matinhos','Paraná'),(3227,'Maxaranguape','Rio Grande do Norte'),(3314,'Mongaguá','São Paulo'),(3392,'Mostardas','Rio Grande do Sul'),(3400,'Mucuri','Bahia'),(3439,'Navegantes','Santa Catarina'),(3456,'Nilo Peçanha','Bahia'),(3463,'Nísia Floresta','Rio Grande do Norte'),(3464,'Niterói','Rio de Janeiro'),(3579,'Nova Viçosa','Bahia'),(3620,'Oiapoque','Amapá'),(3633,'Olinda','Pernambuco'),(3658,'Osório','Rio Grande do Sul'),(3688,'Pacatuba','Sergipe'),(3689,'Paço do Lumiar','Maranhão'),(3711,'Palhoça','Santa Catarina'),(3716,'Palmares do Sul','Rio Grande do Sul'),(3754,'Paracuru','Ceará'),(3762,'Paraipaba','Ceará'),(3775,'Paranaguá','Paraná'),(3789,'Parati','Rio de Janeiro'),(3802,'Paripueira','Alagoas'),(3806,'Parnaíba','Piauí'),(3807,'Parnamirim','Rio Grande do Norte'),(3822,'Passo de Camaragibe','Alagoas'),(3823,'Passo de Torres','Santa Catarina'),(3850,'Paulino Neves','Maranhão'),(3852,'Paulista','Pernambuco'),(3860,'Paulo Lopes','Santa Catarina'),(3879,'Pedra Grande','Rio Grande do Norte'),(3920,'Penha','Santa Catarina'),(3939,'Peruíbe','São Paulo'),(3947,'Piaçabuçu','Alagoas'),(3954,'Piçarras','Santa Catarina'),(4017,'Pirambu','Sergipe'),(4048,'Pitimbu','Paraíba'),(4051,'Piúma','Espírito Santo'),(4094,'Pontal do Paraná','Paraná'),(4132,'Porto Belo','Santa Catarina'),(4136,'Porto de Pedras','Alagoas'),(4137,'Porto do Mangue','Rio Grande do Norte'),(4153,'Porto Rico do Maranhão','Maranhão'),(4154,'Porto Seguro','Bahia'),(4174,'Prado','Bahia'),(4178,'Praia Grande','São Paulo'),(4204,'Presidente Kennedy','Espírito Santo'),(4220,'Primeira Cruz','Maranhão'),(4241,'Quatipuru','Pará'),(4264,'Quissamã','Rio de Janeiro'),(4283,'Raposa','Maranhão'),(4380,'Rio das Ostras','Rio de Janeiro'),(4385,'Rio do Fogo','Rio Grande do Norte'),(4397,'Rio Grande','Rio Grande do Sul'),(4419,'Rio Tinto','Paraíba'),(4458,'Roteiro','Alagoas'),(4489,'Salinas da Margarida','Bahia'),(4490,'Salinópolis','Pará'),(4539,'Santa Cruz Cabrália','Bahia'),(4620,'Santa Rita','Paraíba'),(4660,'Santa Vitória do Palmar','Rio Grande do Sul'),(4701,'Santo Amaro do Maranhão','Maranhão'),(4748,'Santos','São Paulo'),(4757,'São Bento do Norte','Rio Grande do Norte'),(4771,'São Caetano de Odivelas','Pará'),(4813,'São Francisco de Itabapoana','Rio de Janeiro'),(4818,'São Francisco do Conde','Bahia'),(4825,'São Francisco do Sul','Santa Catarina'),(4835,'São Gonçalo','Rio de Janeiro'),(4837,'São Gonçalo do Amarante','Ceará'),(4855,'São João da Barra','Rio de Janeiro'),(4872,'São João de Pirabas','Pará'),(4909,'São José','Santa Catarina'),(4913,'São José da Coroa Grande','Pernambuco'),(4928,'São José de Ribamar','Maranhão'),(4949,'São José do Norte','Rio Grande do Sul'),(4993,'São Mateus','Espírito Santo'),(5003,'São Miguel de Touros','Rio Grande do Norte'),(5016,'São Miguel dos Milagres','Alagoas'),(5051,'São Sebastião','São Paulo'),(5084,'São Vicente','São Paulo'),(5098,'Saquarema','Rio de Janeiro'),(5108,'Saubara','Bahia'),(5132,'Senador Georgino Avelino','Rio Grande do Norte'),(5156,'Serra','Espírito Santo'),(5178,'Serrano do Maranhão','Maranhão'),(5226,'Sirinhaém','Pernambuco'),(5253,'Soure','Pará'),(5295,'Tamandaré','Pernambuco'),(5349,'Tavares','Rio Grande do Sul'),(5377,'Terra de Areia','Rio Grande do Sul'),(5390,'Tibau','Rio Grande do Norte'),(5391,'Tibau do Sul','Rio Grande do Norte'),(5394,'Tijucas','Santa Catarina'),(5426,'Touros','Rio Grande do Norte'),(5428,'Tracuateua','Pará'),(5432,'Trairi','Ceará'),(5434,'Tramandaí','Rio Grande do Sul'),(5492,'Turiaçu','Maranhão'),(5504,'Tutóia','Maranhão'),(5515,'Ubatuba','São Paulo'),(5535,'Una','Bahia'),(5561,'Uruçuca','Bahia'),(5579,'Valença','Bahia'),(5626,'Vera Cruz','Bahia'),(5676,'Vila Velha','Espírito Santo'),(5686,'Viseu','Pará'),(5716,'Xangri-lá','Rio Grande do Sul'),(5795,'Jequiá da Praia','Alagoas');
/*!40000 ALTER TABLE `cidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ondas`
--

DROP TABLE IF EXISTS `ondas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ondas` (
  `cod_cidade` int(11) NOT NULL,
  `dia` varchar(11) NOT NULL,
  `agitacao` varchar(15) NOT NULL,
  `vento_vel` int(11) NOT NULL,
  `vento_dir` varchar(15) NOT NULL,
  PRIMARY KEY (`cod_cidade`,`dia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ondas`
--

LOCK TABLES `ondas` WRITE;
/*!40000 ALTER TABLE `ondas` DISABLE KEYS */;
/*!40000 ALTER TABLE `ondas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tempo`
--

DROP TABLE IF EXISTS `tempo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tempo` (
  `cod_cidade` int(11) NOT NULL,
  `dia` varchar(11) NOT NULL,
  `cod_tempo` varchar(5) NOT NULL,
  `minima` int(11) NOT NULL,
  `maxima` int(11) NOT NULL,
  PRIMARY KEY (`cod_cidade`,`dia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tempo`
--

LOCK TABLES `tempo` WRITE;
/*!40000 ALTER TABLE `tempo` DISABLE KEYS */;
/*!40000 ALTER TABLE `tempo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ocean'
--

--
-- Dumping routines for database 'ocean'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-16 21:54:16

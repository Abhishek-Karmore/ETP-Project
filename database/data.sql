-- MySQL dump 10.13  Distrib 9.5.0, for Win64 (x86_64)
--
-- Host: localhost    Database: fooddeliveryapp_db
-- ------------------------------------------------------
-- Server version	9.5.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `tbl_category`
--

LOCK TABLES `tbl_category` WRITE;
/*!40000 ALTER TABLE `tbl_category` DISABLE KEYS */;
INSERT INTO `tbl_category` VALUES (1,'pizza','assets/Images/Pizza.avif'),(2,'Burger','assets/Images/Burger.avif'),(3,'Biryani','assets/Images/Biryani.avif'),(4,'Cake','assets/Images/Cake.avif'),(5,'Chinese','assets/Images/Chinese.avif'),(6,'Cutlet','assets/Images/Cutlet.avif'),(7,'Khichdi','assets/Images/Khichdi.avif'),(8,'Momo','assets/Images/Momo.avif'),(9,'Pure Veg','assets/Images/Pure Veg.avif'),(10,'Salad','assets/Images/Salad.avif'),(11,'Samosa','assets/Images/Samosa.avif'),(12,'Shake','assets/Images/Shake.avif');
/*!40000 ALTER TABLE `tbl_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tbl_order`
--

LOCK TABLES `tbl_order` WRITE;
/*!40000 ALTER TABLE `tbl_order` DISABLE KEYS */;
INSERT INTO `tbl_order` VALUES (1,3,8,2,498.00),(2,3,25,1,119.00),(3,27,25,2,238.00),(4,27,18,3,1107.00),(5,27,9,2,1120.00),(6,27,21,1,149.00),(7,29,14,1,212.00),(8,3,18,2,738.00),(9,3,8,1,249.00);
/*!40000 ALTER TABLE `tbl_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tbl_product`
--

LOCK TABLES `tbl_product` WRITE;
/*!40000 ALTER TABLE `tbl_product` DISABLE KEYS */;
INSERT INTO `tbl_product` VALUES (8,'1+1 Veg Cheesy Pizza',1,249.00,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,h_600/FOOD_CATALOG/IMAGES/CMS/2025/5/16/746ea501-cfac-455d-b9e2-e2bdb59212de_11feacd0-4a12-45ae-807b-3a7499829d2e.jpeg'),(9,'3 Veg or Non-Veg Medium Pizza\r\n',1,560.00,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,h_600/FOOD_CATALOG/IMAGES/CMS/2025/5/16/032c3f9b-1cd3-4321-aa47-4a7dd52ccab1_f7b5db14-d6bc-4964-91e4-c7e03dcf965c.jpeg'),(10,'Garden Fresh Veggie Crust Pizza\r\n',1,249.00,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,h_600/FOOD_CATALOG/IMAGES/CMS/2025/6/5/cce10adb-47bb-428b-92eb-976542767511_059a8112-e47f-4a74-95d8-40324cb4d8bf.jpeg'),(12,'Korean Crispy Veg Burger\r\n',2,102.00,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,h_600/FOOD_CATALOG/IMAGES/CMS/2025/5/29/88bd6710-3b12-4799-bdf7-593e2684ffc6_04a83d30-a338-4a65-b422-5ba8f0531f41.jpeg'),(13,'Cajun Spicy Paneer Burger Combo\r\n',2,427.00,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,h_600/FOOD_CATALOG/IMAGES/CMS/2025/10/31/8ec662c1-6fc8-471e-b762-58221a493096_c0eedad4-ef8f-4c06-93bd-3439cbc6e18a.jpeg'),(14,'Nachoburg Cheese Veg Burger\r\n',2,212.00,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,h_600/FOOD_CATALOG/IMAGES/CMS/2025/4/14/06ab39d4-afb3-4a78-8ef8-833f7e7fa3a5_89947803-7d2a-45d5-99f3-9ebc7218e204.jpeg'),(15,'Korea Wrap Combo\r\n ',2,449.00,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,h_600/FOOD_CATALOG/IMAGES/CMS/2025/9/18/07d1f604-1cf9-42de-86db-4819b3a9ef46_9254281f-0913-446b-b8e0-99227f6616be.jpeg'),(16,'Anda Biryani',3,259.00,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,h_600/74facad1d2d89c6302296c21d713baee'),(17,'Murg Dum Biryani\r\n',3,379.00,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,h_600/3f2a16a67dbaabe7841b5fbf5930f72c'),(18,'Chicken Tikka Biryani\r\n',3,369.00,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,h_600/7963207d32bb69c6132e8e565af9923f'),(19,'Makrana Kebab Biryani\r\n',3,389.00,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,h_600/e10544c67ebc6b4c7f82acc5e34b3366'),(20,'Black Forest Pastry\r\n',4,99.00,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,h_600/FOOD_CATALOG/IMAGES/CMS/2024/4/12/22e3ac19-a07d-413f-afd4-670712cf0266_9615c40e-04e9-4033-9574-377c141c06d2.jpg'),(21,'Pack Of Any Two Pastries\r\n',4,149.00,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,h_600/7a0d075a73598d9c6c8564e399f30177'),(23,'Chocolate Truffle Bento Cake\r\n',4,309.00,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,h_600/FOOD_CATALOG/IMAGES/CMS/2024/3/7/3304ae2f-ef5f-4d4c-a0b9-357febf9cee7_0bca3d13-77b5-432c-ae06-66ba0caa4308_compressed'),(25,'New McSaver Chicken Nuggets (4 Pc)',12,119.00,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,h_600/7bf83367ed61708817caefbc79a3c9eb'),(26,'Veg Chinese Schezwan Fried Rice',5,149.00,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,h_600/FOOD_CATALOG/IMAGES/CMS/2024/6/7/7fc502e9-2f9e-4c28-90c4-933abfa54e6a_8dcd85b4-42cd-466d-bc27-964729344fa3.jpg_compressed'),(27,'Paneer Tikka & Onion Mania Pizza',1,210.00,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTRCFiMPTIhFWcRU9LxGFVFj7JqOQq0b6h4Hw&s');
/*!40000 ALTER TABLE `tbl_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tbl_user`
--

LOCK TABLES `tbl_user` WRITE;
/*!40000 ALTER TABLE `tbl_user` DISABLE KEYS */;
INSERT INTO `tbl_user` VALUES (1,'Admin','Admin@gmail.com','Admin@123','Admin'),(2,'Abhi','Abhi@gmail.com','Abhi@123','User'),(3,'Rushikesh','Rushi@gmail.com','$2a$10$kZyQp3','User'),(5,'Vikas Samrit','Vikas@gmail.com','Vikas@123','User'),(11,'Rushi sdfg','Rushi1@gmail.com','Rushi@123','User'),(12,'Vikas Samrit','Vikas1@gmail.com','Vikas@123','User'),(13,'Vikas Samrit','Vik@gmail.com','Vikas@123','User'),(14,'Vikas Samrit','wert@gmail.com','asdfgh','User'),(16,'asdgh','Rushi11@gmail.com','rushi@123','User'),(17,'sasdf','asfg','asdfgh','User'),(19,'asdfgh','werqt@gmail.com','asdfgh','User'),(20,'Yashashree langde','yash@gmail.com','yash@123','User'),(21,'Madhu','Madhu@gmail.com','Madhu@123','User'),(22,'shailesh','shailesh@gmail.com','shai@123','User'),(23,'anu','anu@gmail.com','abu@123','User'),(24,'ravi','ravi@gmail.com','ravi@321','User'),(25,'abc','abc@gmail.com','abc@123','User'),(26,'renuka','renuka@gmail.com','renuka','User'),(27,'veer','veer@gmail.com','veer@123','User'),(29,'abc','abca@gmail.com','Abc@123','User'),(30,'DirectTest','direct@test.com','123','User');
/*!40000 ALTER TABLE `tbl_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-01-05 15:49:01

-- phpMyAdmin SQL Dump
-- version 4.9.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Jun 09, 2022 at 08:14 PM
-- Server version: 5.7.32
-- PHP Version: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `rent_a_car`
--

-- --------------------------------------------------------

--
-- Table structure for table `cars`
--

CREATE TABLE `cars` (
  `id` int(11) NOT NULL,
  `company_id` int(11) NOT NULL,
  `brand` varchar(100) NOT NULL,
  `model` int(11) NOT NULL,
  `type` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cars`
--

INSERT INTO `cars` (`id`, `company_id`, `brand`, `model`, `type`) VALUES
(1, 1, 'VOLVO', 2022, 'Kamyon'),
(2, 1, 'Renuld', 2012, 'binek'),
(3, 3, 'TOGG', 2022, 'Binek'),
(4, 4, 'Murat131', 1978, 'binek\r\n');

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `id` int(11) NOT NULL,
  `city_id` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`id`, `city_id`, `name`) VALUES
(1, 1, 'Adana'),
(2, 2, 'Adiyaman'),
(3, 3, 'Afyonkarahisar'),
(4, 4, 'Agri'),
(5, 5, 'Amasya'),
(6, 6, 'Ankara'),
(7, 7, 'Antalya'),
(8, 8, 'Artvin'),
(9, 9, 'Aydin'),
(10, 10, 'Balikesir'),
(11, 11, 'Bilecik'),
(12, 12, 'Bingol'),
(13, 13, 'Bitlis'),
(14, 14, 'Bolu'),
(15, 15, 'Burdur'),
(16, 16, 'Bursa'),
(17, 17, 'Canakkale'),
(18, 18, 'Cankiri'),
(19, 19, 'Corum'),
(20, 20, 'Denizli'),
(21, 21, 'Diyarbakir'),
(22, 22, 'Edirne'),
(23, 23, 'Elazig'),
(24, 24, 'Erzincan'),
(25, 25, 'Erzurum'),
(26, 26, 'Eskisehir'),
(27, 27, 'Gaziantep'),
(28, 28, 'Giresun'),
(29, 29, 'Gumushane'),
(30, 30, 'Hakkari'),
(31, 31, 'Hatay'),
(32, 32, 'Isparta'),
(33, 33, 'Mersin'),
(34, 34, 'Istanbul'),
(35, 35, 'Izmir'),
(36, 36, 'Kars'),
(37, 37, 'Kastamonu'),
(38, 38, 'Kayseri'),
(39, 39, 'Kirklareli'),
(40, 40, 'Kirsehir'),
(41, 41, 'Kocaeli'),
(42, 42, 'Konya'),
(43, 43, 'Kutahya'),
(44, 44, 'Malatya'),
(45, 45, 'Manisa'),
(46, 46, 'Kahramanmaras'),
(47, 47, 'Mardin'),
(48, 48, 'Mugla'),
(49, 49, 'Mus'),
(50, 50, 'Nevsehir'),
(51, 51, 'Nigde'),
(52, 52, 'Ordu'),
(53, 53, 'Rize'),
(54, 54, 'Sakarya'),
(55, 55, 'Samsun'),
(56, 56, 'Siirt'),
(57, 57, 'Sinop'),
(58, 58, 'Sivas'),
(59, 59, 'Tekirdag'),
(60, 60, 'Tokat'),
(61, 61, 'Trabzon'),
(62, 62, 'Tunceli'),
(63, 63, 'Sanliurfa'),
(64, 64, 'Usak'),
(65, 65, 'Van'),
(66, 66, 'Yozgat'),
(67, 67, 'Zonguldak'),
(68, 68, 'Aksaray'),
(69, 69, 'Bayburt'),
(70, 70, 'Karaman'),
(71, 71, 'Kirikkale'),
(72, 72, 'Batman'),
(73, 73, 'Sirnak'),
(74, 74, 'Bartin'),
(75, 75, 'Ardahan'),
(76, 76, 'Igdir'),
(77, 77, 'Yalova'),
(78, 78, 'Karabuk'),
(79, 79, 'Kilis'),
(80, 80, 'Osmaniye'),
(81, 81, 'Duzce');

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

CREATE TABLE `company` (
  `id` int(11) NOT NULL,
  `uname` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `city_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`id`, `uname`, `password`, `name`, `city_id`) VALUES
(1, 'enuygun', 'eu123', 'ENUYGUN', 34),
(2, 'dedeoto', 'dd123', 'DEDE OTO', 34),
(3, 'budget', 'bdgt123', 'BUDGET', 6),
(4, 'yolcu365', 'ylc123', 'Yolcu360', 34);

-- --------------------------------------------------------

--
-- Table structure for table `rental_cars`
--

CREATE TABLE `rental_cars` (
  `id` int(11) NOT NULL,
  `car_id` int(11) NOT NULL,
  `company_id` int(11) NOT NULL,
  `daily_price` double NOT NULL,
  `date_first` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rental_cars`
--

INSERT INTO `rental_cars` (`id`, `car_id`, `company_id`, `daily_price`, `date_first`) VALUES
(1, 1, 1, 233, '2022-06-16');

-- --------------------------------------------------------

--
-- Table structure for table `reserved_cars`
--

CREATE TABLE `reserved_cars` (
  `id` int(11) NOT NULL,
  `company_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `car_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `uname` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `uname`, `password`, `name`, `surname`) VALUES
(1, 'tolgaacgul', 't123', 'Tolga', 'Açgül'),
(2, 'oguzhantasyaran', 'o123', 'Oğuzhan', 'Taşyaran'),
(3, 'erdemoden', 'e123', 'Erdem', 'Oden');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cars`
--
ALTER TABLE `cars`
  ADD PRIMARY KEY (`id`),
  ADD KEY `company_id` (`company_id`);

--
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD UNIQUE KEY `city_id` (`city_id`);

--
-- Indexes for table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`id`),
  ADD KEY `city_id` (`city_id`);

--
-- Indexes for table `rental_cars`
--
ALTER TABLE `rental_cars`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cars_id` (`car_id`),
  ADD KEY `company_id` (`company_id`);

--
-- Indexes for table `reserved_cars`
--
ALTER TABLE `reserved_cars`
  ADD PRIMARY KEY (`id`),
  ADD KEY `company_id` (`company_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `car_id` (`car_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cars`
--
ALTER TABLE `cars`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `company`
--
ALTER TABLE `company`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `rental_cars`
--
ALTER TABLE `rental_cars`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `reserved_cars`
--
ALTER TABLE `reserved_cars`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cars`
--
ALTER TABLE `cars`
  ADD CONSTRAINT `cars_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`);

--
-- Constraints for table `company`
--
ALTER TABLE `company`
  ADD CONSTRAINT `company_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`);

--
-- Constraints for table `rental_cars`
--
ALTER TABLE `rental_cars`
  ADD CONSTRAINT `rental_cars_ibfk_1` FOREIGN KEY (`car_id`) REFERENCES `cars` (`id`),
  ADD CONSTRAINT `rental_cars_ibfk_2` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`);

--
-- Constraints for table `reserved_cars`
--
ALTER TABLE `reserved_cars`
  ADD CONSTRAINT `reserved_cars_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`),
  ADD CONSTRAINT `reserved_cars_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `reserved_cars_ibfk_3` FOREIGN KEY (`car_id`) REFERENCES `cars` (`id`);

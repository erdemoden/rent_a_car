-- phpMyAdmin SQL Dump
-- version 4.9.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Jun 25, 2022 at 09:37 PM
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
  `city_id` int(3) NOT NULL,
  `brand` varchar(50) NOT NULL,
  `model` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `daily_price` double NOT NULL,
  `date_first` date NOT NULL,
  `date_last` date NOT NULL,
  `is_rental` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cars`
--

INSERT INTO `cars` (`id`, `company_id`, `city_id`, `brand`, `model`, `type`, `daily_price`, `date_first`, `date_last`, `is_rental`) VALUES
(1, 1, 34, 'Volvo', '2012', 'Binek', 159, '2022-02-12', '2023-12-13', 1),
(2, 2, 35, 'Toyota', '2004', 'Camry', 85.25, '2022-02-18', '2022-10-25', 1),
(3, 2, 51, 'Toyota', '1993', 'Celica', 99.93, '2022-10-11', '2023-04-07', 1),
(4, 3, 77, 'Ford', '1994', 'Econoline E150', 72.9, '2022-01-29', '2022-09-06', 0),
(5, 3, 31, 'Mercury', '1984', 'Capri', 3.74, '2022-01-30', '2022-06-22', 0),
(6, 1, 11, 'Toyota', '2010', 'Highlander', 49.93, '2022-12-26', '2023-10-08', 1),
(7, 3, 9, 'Jaguar', '2002', 'X-Type', 34.37, '2022-02-26', '2022-12-21', 0),
(8, 2, 17, 'Honda', '1983', 'Accord', 73.76, '2022-11-17', '2022-11-20', 1),
(9, 1, 24, 'Chevrolet', '2007', 'Impala', 45.51, '2022-12-27', '2023-04-09', 1),
(10, 1, 37, 'Mazda', '2012', 'Mazdaspeed 3', 67.46, '2022-06-25', '2022-08-27', 0),
(11, 3, 28, 'Mazda', '2004', 'MX-5', 37.84, '2022-07-08', '2023-01-11', 1),
(12, 3, 14, 'Mitsubishi', '1997', 'Galant', 32.46, '2022-02-21', '2023-01-29', 0),
(13, 1, 28, 'Pontiac', '1992', 'Grand Am', 26.95, '2022-03-16', '2023-03-18', 1),
(14, 3, 24, 'Mercedes-Benz', '2005', 'M-Class', 2.25, '2022-08-05', '2022-10-04', 0),
(15, 1, 30, 'Alfa Romeo', '1993', '164', 14.51, '2022-02-20', '2023-04-02', 1),
(16, 1, 34, 'Toyota', '2010', 'Camry Hybrid', 71.85, '2022-01-04', '2022-10-13', 1),
(17, 1, 10, 'Mercury', '1989', 'Cougar', 32.23, '2022-01-08', '2023-02-28', 1),
(18, 3, 31, 'Mazda', '2004', 'RX-8', 12.23, '2022-03-29', '2022-10-16', 0),
(19, 3, 56, 'Mitsubishi', '1990', 'Chariot', 64.95, '2022-04-20', '2023-06-25', 1),
(20, 1, 43, 'Chevrolet', '2004', 'Venture', 4.48, '2022-07-04', '2022-12-22', 1),
(21, 1, 65, 'BMW', '2004', '760', 86.43, '2022-10-18', '2023-03-25', 1),
(22, 2, 5, 'Jeep', '2008', 'Compass', 44.05, '2022-01-07', '2022-08-06', 1),
(23, 2, 70, 'Mazda', '2002', 'Miata MX-5', 34.68, '2022-02-21', '2023-02-06', 1),
(24, 1, 44, 'Saab', '2000', '9-3', 66.45, '2022-12-20', '2023-03-10', 0),
(25, 3, 50, 'Nissan', '2011', 'JUKE', 93.53, '2022-04-19', '2023-04-20', 0),
(26, 2, 14, 'Toyota', '2004', 'Tacoma Xtra', 77.36, '2022-02-18', '2023-03-28', 0),
(27, 2, 66, 'Land Rover', '2002', 'Freelander', 42.51, '2022-03-06', '2022-08-18', 0),
(28, 2, 5, 'Pontiac', '1967', 'GTO', 85.27, '2022-04-10', '2022-07-14', 1),
(29, 2, 69, 'Oldsmobile', '1995', '98', 84.31, '2022-01-18', '2023-04-04', 1),
(30, 1, 49, 'Dodge', '1992', 'Dakota', 84.06, '2022-02-11', '2022-09-28', 1),
(31, 3, 26, 'Honda', '2004', 'S2000', 23.84, '2023-02-19', '2022-10-22', 1),
(32, 3, 22, 'Ford', '1968', 'Mustang', 15.16, '2022-07-01', '2022-07-14', 0),
(33, 1, 71, 'Volvo', '2002', 'S40', 66.58, '2022-07-02', '2022-09-08', 1),
(34, 1, 16, 'Saturn', '1999', 'S-Series', 79.3, '2022-08-05', '2023-03-30', 1),
(35, 3, 31, 'Chevrolet', '1994', 'Suburban 2500', 10.57, '2022-12-31', '2023-03-30', 0),
(36, 2, 43, 'GMC', '1992', 'Rally Wagon 1500', 40.3, '2022-07-25', '2022-09-10', 1),
(37, 3, 9, 'Jaguar', '2001', 'XJ Series', 56.07, '2022-12-02', '2022-10-29', 1),
(38, 2, 76, 'Nissan', '2012', 'JUKE', 32.48, '2022-08-29', '2022-11-27', 1),
(39, 1, 49, 'Dodge', '1999', 'Viper', 7.24, '2022-08-12', '2023-03-07', 1),
(40, 3, 61, 'Jeep', '1996', 'Cherokee', 3.69, '2022-06-24', '2022-09-25', 0),
(41, 1, 30, 'Buick', '2005', 'Terraza', 14.64, '2022-08-19', '2022-06-19', 1),
(42, 2, 24, 'Kia', '2008', 'Carens', 35.91, '2022-08-14', '2022-07-20', 1),
(43, 3, 52, 'Hummer', '1995', 'H1', 89.48, '2022-06-30', '2022-07-26', 0),
(44, 1, 80, 'MINI', '2008', 'Clubman', 21.57, '2022-07-26', '2023-03-21', 1),
(45, 3, 36, 'BMW', '2011', 'X3', 28.93, '2022-08-20', '2022-11-01', 1),
(46, 1, 40, 'Mercury', '1988', 'Tracer', 25.96, '2023-01-09', '2022-08-02', 1),
(47, 2, 15, 'BMW', '2008', '6 Series', 83.15, '2022-08-27', '2022-10-22', 1),
(48, 2, 42, 'Acura', '2007', 'TSX', 66.02, '2023-04-23', '2023-05-18', 0),
(49, 2, 79, 'Mazda', '1990', 'MX-5', 69.73, '2022-06-21', '2022-11-22', 1),
(50, 1, 57, 'Nissan', '1993', 'Quest', 85.63, '2022-08-13', '2022-08-13', 1),
(51, 2, 27, 'Toyota', '2010', 'Highlander', 92.08, '2023-01-22', '2023-02-07', 1),
(52, 4, 35, 'Tesla', '2021', 'Arazi', 120, '2022-06-19', '2024-12-30', 0),
(53, 5, 34, 'volvo', '2009', 'dynamıc', 500, '2022-12-12', '2022-12-12', 1),
(54, 1, 34, 'Chevrolet', '1994', 'binek', 123, '2022-06-12', '2022-12-12', 1),
(55, 6, 61, 'Martı', '2021', 'scoter', 100, '2022-05-12', '2022-02-19', NULL),
(56, 7, 6, 'Togg', '2012', 'Uzun Araç', 120.3, '2022-12-12', '2022-12-21', 1),
(57, 7, 52, 'TOGG', '2022', 'Binek', 120, '2022-02-12', '2022-12-12', 0),
(58, 8, 34, 'TOGG', 'istanbul 2022', 'binek', 140, '2022-06-23', '2022-07-15', 1),
(59, 1, 61, 'xxxx', 'xxx', 'xxx', 140, '2022-01-01', '2023-01-01', 1),
(60, 1, 4, 'xlg', 'xlg', 'xlg', 500, '2022-07-01', '2023-12-30', 0),
(61, 9, 34, 'VOLVO', '2012', 'sedan', 134, '2022-07-01', '2023-12-30', 1),
(62, 1, 34, 'RENOLD', '2013', 'SEDAN', 0, '2022-07-01', '2023-12-30', 1),
(63, 1, 34, 'SPACEX', '2023', 'UZAY', 8560, '2022-07-01', '2023-12-30', 1);

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `id` int(11) NOT NULL,
  `city_id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `name` varchar(50) NOT NULL,
  `city_id` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`id`, `uname`, `password`, `name`, `city_id`) VALUES
(1, 'ibb', '123', 'İBB OTO KİRALAMA A.Ş', 34),
(2, 'patika', '123', 'PATİKA OTO KİRA A.Ş', 52),
(3, '360', '123', 'OTO 360 KİRALAMA A.Ş ', 61),
(4, 'tesla', '123', 'TESLA OTO KİRA A.Ş', 34),
(5, 'sedat yazar', '5062', 'sosed danş', 34),
(6, 'martioto', '123', 'Martı OTO A.Ş', 61),
(7, 'xrent', '123', 'X Rent', 34),
(8, 'bagcilaroto', '123', 'Bağcılar OTO', 62),
(9, 'cevher', '123', 'CEVHER OTO', 34);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `uname` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `uname`, `password`, `name`, `surname`) VALUES
(1, 'tolgaacgul', '123', 'Tolga', 'Açgül'),
(2, 'oguzhan', '123', 'Oğuzhan', 'Taş Yaran'),
(3, 'erdem', '123', 'Erdem', 'Öden'),
(4, 'mahmutkocavali', '123', 'Mahmut', 'Koçavalı'),
(5, 'kartal1903', '123', 'gökhan', 'aytekin'),
(6, 'mazlum', '123', 'Mazlum', 'Soydan'),
(7, 'ersan', '123', 'Ersan', 'Açgül'),
(8, 'cevher', '123', 'Cevher', 'Kursak');

-- --------------------------------------------------------

--
-- Table structure for table `rental_cars`
--

CREATE TABLE `rental_cars` (
  `id` int(11) NOT NULL,
  `car_id` int(11) NOT NULL,
  `company_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `daily_price` double DEFAULT NULL,
  `date_first` date NOT NULL,
  `date_last` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rental_cars`
--

INSERT INTO `rental_cars` (`id`, `car_id`, `company_id`, `customer_id`, `daily_price`, `date_first`, `date_last`) VALUES
(35, 20, 1, 1, 4.48, '2022-06-25', '2022-07-23'),
(41, 58, 8, 6, 140, '2022-06-23', '2022-06-24'),
(42, 58, 8, 1, 140, '2022-06-01', '2022-06-29'),
(43, 13, 1, 3, 26.95, '2023-03-16', '2023-03-17'),
(44, 13, 1, 2, 26.95, '2023-03-18', '2023-03-18'),
(47, 51, 2, 7, 92.08, '2023-01-22', '2023-02-01'),
(48, 24, 1, 7, 66.45, '2022-12-20', '2022-07-23'),
(52, 19, 3, 3, 64.95, '2023-04-23', '2023-04-23'),
(57, 2, 2, 3, 85.25, '2022-02-18', '2022-02-18'),
(59, 34, 1, 5, 79.3, '2023-02-20', '2023-02-20'),
(61, 59, 1, 4, 140, '2022-01-01', '2022-01-01'),
(64, 61, 9, 8, 134, '2022-07-18', '2022-07-23'),
(66, 10, 1, 1, 67.46, '2022-06-25', '2022-07-23');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cars`
--
ALTER TABLE `cars`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rental_cars`
--
ALTER TABLE `rental_cars`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cars`
--
ALTER TABLE `cars`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- AUTO_INCREMENT for table `city`
--
ALTER TABLE `city`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=82;

--
-- AUTO_INCREMENT for table `company`
--
ALTER TABLE `company`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `rental_cars`
--
ALTER TABLE `rental_cars`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;
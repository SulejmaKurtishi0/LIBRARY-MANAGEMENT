-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 27, 2022 at 04:51 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library12`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `bID` int(11) NOT NULL,
  `title` text NOT NULL,
  `author` text NOT NULL,
  `availability` text NOT NULL,
  `phID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`bID`, `title`, `author`, `availability`, `phID`) VALUES
(1, 'The Fault In Our Stars', 'John Green', 'YES', 1),
(3, 'DeaIsNice', 'Sulejma', 'YES', NULL),
(4, 'Where The Sun Sets', 'Sulejma', 'YES', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `borrowedbooks`
--

CREATE TABLE `borrowedbooks` (
  `dateofborrow` date NOT NULL,
  `returndate` date NOT NULL,
  `bookID` int(11) DEFAULT NULL,
  `mID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `borrowedbooks`
--

INSERT INTO `borrowedbooks` (`dateofborrow`, `returndate`, `bookID`, `mID`) VALUES
('2022-01-05', '2022-01-26', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `eID` int(11) NOT NULL,
  `Name` text NOT NULL,
  `Surname` text NOT NULL,
  `WorkingHours` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`eID`, `Name`, `Surname`, `WorkingHours`) VALUES
(1, 'Aurora', 'Topojani', 12),
(2, 'Remzije', 'Kurtishi', 4);

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `mID` int(11) NOT NULL,
  `mName` text NOT NULL,
  `mSurname` text NOT NULL,
  `nrBooks` int(11) NOT NULL,
  `eID` int(11) DEFAULT NULL,
  `rtID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`mID`, `mName`, `mSurname`, `nrBooks`, `eID`, `rtID`) VALUES
(1, 'Sulejma', 'Kurtishi', 100, 1, 1),
(2, 'Sara', 'Jashari', 3, 2, 2),
(3, 'Dea', 'Skikuli', 12, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `publishinghouse`
--

CREATE TABLE `publishinghouse` (
  `phID` int(11) NOT NULL,
  `Name` text NOT NULL,
  `Address` text NOT NULL,
  `nrBooks` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `publishinghouse`
--

INSERT INTO `publishinghouse` (`phID`, `Name`, `Address`, `nrBooks`) VALUES
(1, 'Germa', 'germa@gmail.com', 20);

-- --------------------------------------------------------

--
-- Table structure for table `readingtable`
--

CREATE TABLE `readingtable` (
  `rtID` int(11) NOT NULL,
  `availability` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `readingtable`
--

INSERT INTO `readingtable` (`rtID`, `availability`) VALUES
(1, 'yes'),
(2, 'no');

-- --------------------------------------------------------

--
-- Table structure for table `tablesbooked`
--

CREATE TABLE `tablesbooked` (
  `tbID` int(11) NOT NULL,
  `bID` int(11) DEFAULT NULL,
  `rtID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tablesbooked`
--

INSERT INTO `tablesbooked` (`tbID`, `bID`, `rtID`) VALUES
(1, 1, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`bID`),
  ADD KEY `FK_PublishingHouse` (`phID`);

--
-- Indexes for table `borrowedbooks`
--
ALTER TABLE `borrowedbooks`
  ADD PRIMARY KEY (`dateofborrow`),
  ADD KEY `FK_Book1` (`bookID`),
  ADD KEY `FK_member` (`mID`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`eID`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`mID`),
  ADD KEY `FK_Employee` (`eID`),
  ADD KEY `FK_ReadingTsble` (`rtID`);

--
-- Indexes for table `publishinghouse`
--
ALTER TABLE `publishinghouse`
  ADD PRIMARY KEY (`phID`);

--
-- Indexes for table `readingtable`
--
ALTER TABLE `readingtable`
  ADD PRIMARY KEY (`rtID`);

--
-- Indexes for table `tablesbooked`
--
ALTER TABLE `tablesbooked`
  ADD PRIMARY KEY (`tbID`),
  ADD KEY `FK_Book` (`bID`),
  ADD KEY `FK_ReadingTable` (`rtID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `bID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `eID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `mID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `publishinghouse`
--
ALTER TABLE `publishinghouse`
  MODIFY `phID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `readingtable`
--
ALTER TABLE `readingtable`
  MODIFY `rtID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tablesbooked`
--
ALTER TABLE `tablesbooked`
  MODIFY `tbID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `FK_PublishingHouse` FOREIGN KEY (`phID`) REFERENCES `publishinghouse` (`phID`);

--
-- Constraints for table `borrowedbooks`
--
ALTER TABLE `borrowedbooks`
  ADD CONSTRAINT `FK_Book1` FOREIGN KEY (`bookID`) REFERENCES `book` (`bID`),
  ADD CONSTRAINT `FK_member` FOREIGN KEY (`mID`) REFERENCES `member` (`mID`);

--
-- Constraints for table `member`
--
ALTER TABLE `member`
  ADD CONSTRAINT `FK_Employee` FOREIGN KEY (`eID`) REFERENCES `employee` (`eID`),
  ADD CONSTRAINT `FK_ReadingTsble` FOREIGN KEY (`rtID`) REFERENCES `readingtable` (`rtID`);

--
-- Constraints for table `tablesbooked`
--
ALTER TABLE `tablesbooked`
  ADD CONSTRAINT `FK_Book` FOREIGN KEY (`bID`) REFERENCES `book` (`bID`),
  ADD CONSTRAINT `FK_ReadingTable` FOREIGN KEY (`rtID`) REFERENCES `readingtable` (`rtID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

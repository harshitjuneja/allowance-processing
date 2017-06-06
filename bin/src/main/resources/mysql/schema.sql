-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 01, 2017 at 06:09 AM
-- Server version: 5.7.17
-- PHP Version: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `aps`
--
CREATE DATABASE IF NOT EXISTS `aps` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `aps`;

-- --------------------------------------------------------

--
-- Table structure for table `Allowance_Type`
--

CREATE TABLE `Allowance_Type` (
  `Allowance_Type_ID` int(50) NOT NULL,
  `Type_name` varchar(255) DEFAULT NULL,
  `Type_rate` int(50) DEFAULT NULL,
  `Valid_flag` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Department`
--

CREATE TABLE `Department` (
  `Dept_ID` int(50) NOT NULL,
  `Dept_name` varchar(255) DEFAULT NULL,
  `Dept_code` varchar(255) DEFAULT NULL,
  `HOD` varchar(255) DEFAULT NULL,
  `Parent_Dept_ID` int(50) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Status` tinyint(1) DEFAULT NULL,
  `Dept_coordinator` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Employee`
--

CREATE TABLE `Employee` (
  `Corp_ID` varchar(255) NOT NULL,
  `Dept_ID` int(50) DEFAULT NULL,
  `Emp_name` varchar(255) DEFAULT NULL,
  `Manager_ID` varchar(255) DEFAULT NULL,
  `Email_ID` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `Role` varchar(255) DEFAULT NULL,
  `Benefit_level` int(50) DEFAULT NULL,
  `Phone_no` int(50) DEFAULT NULL,
  `Status` tinyint(1) DEFAULT NULL,
  `Start_date` date NOT NULL,
  `End_date` date NOT NULL DEFAULT '2038-12-31',
  `Updated_by` varchar(255) DEFAULT NULL,
  `Designation` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Invoice`
--

CREATE TABLE `Invoice` (
  `Invoice_ID` int(50) NOT NULL,
  `Dept_ID` int(50) DEFAULT NULL,
  `Period_ID` int(50) DEFAULT NULL,
  `Total_amt` float(12,2) DEFAULT NULL,
  `Adjustments` float(12,2) DEFAULT NULL,
  `Generated_date` date DEFAULT NULL,
  `Status` tinyint(1) DEFAULT NULL,
  `Generated_by` varchar(255) DEFAULT NULL,
  `Comments` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Period`
--

CREATE TABLE `Period` (
  `Period_ID` int(50) NOT NULL,
  `Period_name` varchar(255) DEFAULT NULL,
  `Period_Year` year(4) DEFAULT NULL,
  `Start_date` date DEFAULT NULL,
  `End_date` date DEFAULT '2038-12-31',
  `Is_active` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `request`
--

CREATE TABLE `request` (
  `Request_ID` int(50) NOT NULL,
  `Allowance_type_ID` int(50) NOT NULL,
  `Invoice_ID` int(50) NOT NULL,
  `Corp_ID` varchar(255) NOT NULL,
  `Period_Start_Date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `Period_End_Date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Number_Of_Days` int(50) NOT NULL,
  `Submitted_Date` date NOT NULL,
  `request_Status` enum('saved','submitted','approved','rejected','invoiced') NOT NULL,
  `Status_Start_Date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Status_End_Date` timestamp NOT NULL DEFAULT '2038-01-18 21:44:07',
  `Submitted_By` varchar(255) NOT NULL,
  `Amount` float(12,2) NOT NULL,
  `Comments` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Request_Details`
--

CREATE TABLE `Request_Details` (
  `Request_Details_ID` int(50) NOT NULL,
  `Request_ID` int(50) NOT NULL,
  `Date` date NOT NULL,
  `Shift_Time_ID` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Shift_time_Details`
--

CREATE TABLE `Shift_time_Details` (
  `Shift_Time_ID` int(50) NOT NULL,
  `Allowance_Type_ID` int(50) DEFAULT NULL,
  `Start_time` date DEFAULT NULL,
  `End_time` date DEFAULT '2038-12-31',
  `Valid_flag` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Allowance_Type`
--
ALTER TABLE `Allowance_Type`
  ADD PRIMARY KEY (`Allowance_Type_ID`);

--
-- Indexes for table `Department`
--
ALTER TABLE `Department`
  ADD PRIMARY KEY (`Dept_ID`),
  ADD KEY `Parent_Dept_ID` (`Parent_Dept_ID`);

--
-- Indexes for table `Employee`
--
ALTER TABLE `Employee`
  ADD PRIMARY KEY (`Corp_ID`,`Start_date`,`End_date`),
  ADD KEY `Dept_ID` (`Dept_ID`),
  ADD KEY `Manager_ID` (`Manager_ID`);

--
-- Indexes for table `Invoice`
--
ALTER TABLE `Invoice`
  ADD PRIMARY KEY (`Invoice_ID`),
  ADD KEY `Dept_ID` (`Dept_ID`),
  ADD KEY `Period_ID` (`Period_ID`);

--
-- Indexes for table `Period`
--
ALTER TABLE `Period`
  ADD PRIMARY KEY (`Period_ID`);

--
-- Indexes for table `request`
--
ALTER TABLE `request`
  ADD PRIMARY KEY (`Request_ID`,`Status_Start_Date`,`Status_End_Date`),
  ADD KEY `Allowance_type_ID` (`Allowance_type_ID`),
  ADD KEY `Invoice_ID` (`Invoice_ID`),
  ADD KEY `Corp_ID` (`Corp_ID`);

--
-- Indexes for table `Request_Details`
--
ALTER TABLE `Request_Details`
  ADD PRIMARY KEY (`Request_Details_ID`),
  ADD KEY `Request_ID` (`Request_ID`),
  ADD KEY `Shift_Time_ID` (`Shift_Time_ID`);

--
-- Indexes for table `Shift_time_Details`
--
ALTER TABLE `Shift_time_Details`
  ADD PRIMARY KEY (`Shift_Time_ID`),
  ADD KEY `Allowance_Type_ID` (`Allowance_Type_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Allowance_Type`
--
ALTER TABLE `Allowance_Type`
  MODIFY `Allowance_Type_ID` int(50) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Department`
--
ALTER TABLE `Department`
  MODIFY `Dept_ID` int(50) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Invoice`
--
ALTER TABLE `Invoice`
  MODIFY `Invoice_ID` int(50) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Period`
--
ALTER TABLE `Period`
  MODIFY `Period_ID` int(50) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Shift_time_Details`
--
ALTER TABLE `Shift_time_Details`
  MODIFY `Shift_Time_ID` int(50) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `Department`
--
ALTER TABLE `Department`
  ADD CONSTRAINT `department_ibfk_1` FOREIGN KEY (`Parent_Dept_ID`) REFERENCES `Department` (`Dept_ID`);

--
-- Constraints for table `Employee`
--
ALTER TABLE `Employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`Dept_ID`) REFERENCES `Department` (`Dept_ID`),
  ADD CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`Manager_ID`) REFERENCES `Employee` (`Corp_ID`);

--
-- Constraints for table `Invoice`
--
ALTER TABLE `Invoice`
  ADD CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`Dept_ID`) REFERENCES `Department` (`Dept_ID`),
  ADD CONSTRAINT `invoice_ibfk_2` FOREIGN KEY (`Period_ID`) REFERENCES `Period` (`Period_ID`);

--
-- Constraints for table `request`
--
ALTER TABLE `request`
  ADD CONSTRAINT `request_ibfk_1` FOREIGN KEY (`Allowance_type_ID`) REFERENCES `Allowance_Type` (`Allowance_Type_ID`),
  ADD CONSTRAINT `request_ibfk_2` FOREIGN KEY (`Invoice_ID`) REFERENCES `Invoice` (`Invoice_ID`),
  ADD CONSTRAINT `request_ibfk_3` FOREIGN KEY (`Corp_ID`) REFERENCES `Employee` (`Corp_ID`);

--
-- Constraints for table `Request_Details`
--
ALTER TABLE `Request_Details`
  ADD CONSTRAINT `request_details_ibfk_1` FOREIGN KEY (`Request_ID`) REFERENCES `request` (`Request_ID`),
  ADD CONSTRAINT `request_details_ibfk_2` FOREIGN KEY (`Shift_Time_ID`) REFERENCES `Shift_time_Details` (`Shift_Time_ID`);

--
-- Constraints for table `Shift_time_Details`
--
ALTER TABLE `Shift_time_Details`
  ADD CONSTRAINT `shift_time_details_ibfk_1` FOREIGN KEY (`Allowance_Type_ID`) REFERENCES `Allowance_Type` (`Allowance_Type_ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

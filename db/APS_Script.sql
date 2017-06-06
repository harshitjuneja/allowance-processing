-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 02, 2017 at 07:15 PM
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
DROP DATABASE aps;
CREATE DATABASE IF NOT EXISTS `aps` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `aps`;

-- --------------------------------------------------------

--
-- Table structure for table `allowance_type`
--

DROP TABLE IF EXISTS `allowance_type`;
CREATE TABLE `allowance_type` (
  `allowance_type_id` int(50) NOT NULL,
  `type_name` varchar(255) DEFAULT NULL,
  `type_rate` int(50) DEFAULT NULL,
  `valid_flag` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `allowance_type`
--

INSERT INTO `allowance_type` (`allowance_type_id`, `type_name`, `type_rate`, `valid_flag`) VALUES
(1, 'Shift Allowance', 500, 1),
(2, 'On call Allowance', 500, 1);

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `dept_id` int(50) NOT NULL,
  `dept_name` varchar(255) DEFAULT NULL,
  `dept_code` varchar(255) DEFAULT NULL,
  `hod` varchar(255) DEFAULT NULL,
  `parent_dept_id` int(50) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `dept_coordinator` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`dept_id`, `dept_name`, `dept_code`, `hod`, `parent_dept_id`, `description`, `status`, `dept_coordinator`) VALUES
(1, 'retail', 'a101', 'rahul', NULL, 'retail department', 1, 'pranay'),
(2, 'technical', 'a102', 'ajay', NULL, 'teachnical department', 1, 'vishesh');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `corp_id` varchar(255) NOT NULL,
  `dept_id` int(50) DEFAULT NULL,
  `emp_name` varchar(255) DEFAULT NULL,
  `manager_id` varchar(255) DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `benefit_level` int(50) DEFAULT NULL,
  `phone_no` int(50) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL DEFAULT '2038-12-31',
  `updated_by` varchar(255) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`corp_id`, `dept_id`, `emp_name`, `manager_id`, `email_id`, `password`, `role`, `benefit_level`, `phone_no`, `status`, `start_date`, `end_date`, `updated_by`, `designation`) VALUES
('a999999', 1, 'ishaan', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2014-05-02', '2038-12-31', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
CREATE TABLE `invoice` (
  `invoice_id` int(50) NOT NULL,
  `dept_id` int(50) DEFAULT NULL,
  `period_id` int(50) DEFAULT NULL,
  `total_amt` float(12,2) DEFAULT NULL,
  `adjustments` float(12,2) DEFAULT NULL,
  `generated_date` date DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `generated_by` varchar(255) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `period`
--

DROP TABLE IF EXISTS `period`;
CREATE TABLE `period` (
  `period_id` int(50) NOT NULL,
  `period_name` varchar(255) DEFAULT NULL,
  `period_year` year(4) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT '2038-12-31',
  `is_active` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
CREATE TABLE `request` (
  `request_id` int(50) NOT NULL,
  `allowance_type_id` int(50) DEFAULT NULL,
  `invoice_id` int(50) DEFAULT NULL,
  `corp_id` varchar(255) DEFAULT NULL,
  `period_start_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `period_end_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `number_of_days` int(50) DEFAULT NULL,
  `submitted_date` date DEFAULT NULL,
  `request_status` enum('saved','submitted','approved','rejected','invoiced') DEFAULT NULL,
  `status_start_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status_end_date` timestamp NOT NULL DEFAULT '2038-01-18 21:44:07',
  `submitted_by` varchar(255) DEFAULT NULL,
  `amount` float(12,2) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `exception` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `request_details`
--

DROP TABLE IF EXISTS `request_details`;
CREATE TABLE `request_details` (
  `request_details_id` int(50) NOT NULL,
  `request_id` int(50) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `shift_time_id` int(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `shift_time_details`
--

DROP TABLE IF EXISTS `shift_time_details`;
CREATE TABLE `shift_time_details` (
  `shift_time_id` int(50) NOT NULL,
  `allowance_type_id` int(50) DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `end_time` time DEFAULT '2038-12-31',
  `valid_flag` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `allowance_type`
--
ALTER TABLE `allowance_type`
  ADD PRIMARY KEY (`allowance_type_id`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`dept_id`),
  ADD KEY `parent_dept_id` (`parent_dept_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`corp_id`,`start_date`,`end_date`),
  ADD KEY `dept_id` (`dept_id`),
  ADD KEY `manager_id` (`manager_id`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`invoice_id`),
  ADD KEY `dept_id` (`dept_id`),
  ADD KEY `period_id` (`period_id`);

--
-- Indexes for table `period`
--
ALTER TABLE `period`
  ADD PRIMARY KEY (`period_id`);

--
-- Indexes for table `request`
--
ALTER TABLE `request`
  ADD PRIMARY KEY (`request_id`,`status_start_date`,`status_end_date`),
  ADD KEY `allowance_type_id` (`allowance_type_id`),
  ADD KEY `invoice_id` (`invoice_id`),
  ADD KEY `corp_id` (`corp_id`);

--
-- Indexes for table `request_details`
--
ALTER TABLE `request_details`
  ADD PRIMARY KEY (`request_details_id`),
  ADD KEY `request_id` (`request_id`),
  ADD KEY `shift_time_id` (`shift_time_id`);

--
-- Indexes for table `shift_time_details`
--
ALTER TABLE `shift_time_details`
  ADD PRIMARY KEY (`shift_time_id`),
  ADD KEY `allowance_type_id` (`allowance_type_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `allowance_type`
--
ALTER TABLE `allowance_type`
  MODIFY `allowance_type_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `dept_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `invoice`
--
ALTER TABLE `invoice`
  MODIFY `invoice_id` int(50) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `period`
--
ALTER TABLE `period`
  MODIFY `period_id` int(50) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `request`
--
ALTER TABLE `request`
  MODIFY `request_id` int(50) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `request_details`
--
ALTER TABLE `request_details`
  MODIFY `request_details_id` int(50) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `shift_time_details`
--
ALTER TABLE `shift_time_details`
  MODIFY `shift_time_id` int(50) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `department`
--
ALTER TABLE `department`
  ADD CONSTRAINT `department_ibfk_1` FOREIGN KEY (`parent_dept_id`) REFERENCES `department` (`dept_id`);

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `department` (`dept_id`),
  ADD CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`manager_id`) REFERENCES `employee` (`corp_id`);

--
-- Constraints for table `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `department` (`dept_id`),
  ADD CONSTRAINT `invoice_ibfk_2` FOREIGN KEY (`period_id`) REFERENCES `period` (`period_id`);

--
-- Constraints for table `request`
--
ALTER TABLE `request`
  ADD CONSTRAINT `request_ibfk_1` FOREIGN KEY (`allowance_type_id`) REFERENCES `allowance_type` (`allowance_type_id`),
  ADD CONSTRAINT `request_ibfk_2` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`invoice_id`),
  ADD CONSTRAINT `request_ibfk_3` FOREIGN KEY (`corp_id`) REFERENCES `employee` (`corp_id`);

--
-- Constraints for table `request_details`
--
ALTER TABLE `request_details`
  ADD CONSTRAINT `request_details_ibfk_1` FOREIGN KEY (`request_id`) REFERENCES `request` (`request_id`),
  ADD CONSTRAINT `request_details_ibfk_2` FOREIGN KEY (`shift_time_id`) REFERENCES `shift_time_details` (`shift_time_id`);

--
-- Constraints for table `shift_time_details`
--
ALTER TABLE `shift_time_details`
  ADD CONSTRAINT `shift_time_details_ibfk_1` FOREIGN KEY (`allowance_type_id`) REFERENCES `allowance_type` (`allowance_type_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

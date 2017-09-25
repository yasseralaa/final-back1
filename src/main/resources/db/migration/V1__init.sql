-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 25, 2017 at 05:17 PM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 7.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `miniproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
  (1),
  (1),
  (1),
  (1);

-- --------------------------------------------------------

--
-- Table structure for table `predefined_notes`
--

CREATE TABLE `predefined_notes` (
  `id` int(11) NOT NULL,
  `maximum_temperature` int(11) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `minimum_temprature` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `predefined_notes`
--

INSERT INTO `predefined_notes` (`id`, `maximum_temperature`, `message`, `minimum_temprature`) VALUES
  (1, 10, '', 1),
  (2, 20, '', 11),
  (3, 30, '', 21),
  (4, 100000, '', 31);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `role`) VALUES
  (1, 'ROLE_ADMIN'),
  (2, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `email`, `mobile_number`, `name`, `password`, `role_id`) VALUES
  (1, 'admin@admin.com', '01122334455', 'admin', 'admin', 1),
  (2, 'user@user.com', '01425366543', 'user', 'user', 2),
  (3, 'abcd', '01155887744', 'abc', 'abc', 1),
  (4, 'abcder', '01155887744', 'zzzzzzzzzzzzzz', 'zzzzzzzzzzzzzz', 2);

-- --------------------------------------------------------

--
-- Table structure for table `weather_note`
--

CREATE TABLE `weather_note` (
  `id` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `weather_note`
--

INSERT INTO `weather_note` (`id`, `date`, `note`, `user_id`) VALUES
  (1, '2017-09-05', 'note note its note', 1),
  (3, '2017-09-24', 'Nooooooooooooooooooooooooooooooooooooooooooooooooote', 1),
  (4, '2017-09-25', 'new note', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `predefined_notes`
--
ALTER TABLE `predefined_notes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKn82ha3ccdebhokx3a8fgdqeyy` (`role_id`);

--
-- Indexes for table `weather_note`
--
ALTER TABLE `weather_note`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_opoh0h4ot3k4ns64418nye4n4` (`date`),
  ADD KEY `FKefi91kw1sloa1bdt72ddg574c` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `predefined_notes`
--
ALTER TABLE `predefined_notes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `weather_note`
--
ALTER TABLE `weather_note`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

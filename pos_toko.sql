-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 02, 2024 at 05:33 PM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pos_toko`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `KodeBarang` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NamaBarang` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `HargaBeliBarang` int NOT NULL,
  `HargaJualBarang` int NOT NULL,
  `StokBarang` int NOT NULL,
  `StokMinBarang` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`KodeBarang`, `NamaBarang`, `HargaBeliBarang`, `HargaJualBarang`, `StokBarang`, `StokMinBarang`) VALUES
('B01', 'Pepsodent', 22500, 25000, 20, 5),
('B02', 'Sampo', 10000, 12000, 20, 5),
('B03', 'Sabun', 15000, 15500, 20, 5),
('B04', 'Bedak', 20000, 21000, 20, 5);

-- --------------------------------------------------------

--
-- Table structure for table `dpembelian`
--

CREATE TABLE `dpembelian` (
  `KodePembelian` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `KodeBarang` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `HargaBeliBarang` int NOT NULL,
  `JmlBeliBarang` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `dpembelian`
--

INSERT INTO `dpembelian` (`KodePembelian`, `KodeBarang`, `HargaBeliBarang`, `JmlBeliBarang`) VALUES
('B01', 'B01', 25000, 20),
('B01', 'B02', 12000, 20),
('B02', 'B01', 25000, 2),
('B02', 'B02', 12000, 2),
('B03', 'B01', 25000, 10),
('B04', 'B01', 25000, 1),
('B05', 'B01', 25000, 1),
('B05', 'B01', 25000, 1),
('B06', 'B04', 21000, 20);

-- --------------------------------------------------------

--
-- Table structure for table `dpenjualan`
--

CREATE TABLE `dpenjualan` (
  `KodePenjualan` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `KodeBarang` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `HargaJualBarang` int NOT NULL,
  `JmlJualBarang` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `dpenjualan`
--

INSERT INTO `dpenjualan` (`KodePenjualan`, `KodeBarang`, `HargaJualBarang`, `JmlJualBarang`) VALUES
('J01', 'B01', 25000, 1),
('J01', 'B02', 12000, 2),
('J02', 'B01', 25000, 3),
('J03', 'B01', 25000, 1),
('J03', 'B02', 12000, 1),
('J04', 'B03', 15500, 4),
('J04', 'B04', 21000, 3);

-- --------------------------------------------------------

--
-- Table structure for table `dreturpembelian`
--

CREATE TABLE `dreturpembelian` (
  `KodeReturPembelian` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `KodeBarang` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `HargaBeliBarang` int NOT NULL,
  `JmlReturBeliBarang` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `dreturpembelian`
--

INSERT INTO `dreturpembelian` (`KodeReturPembelian`, `KodeBarang`, `HargaBeliBarang`, `JmlReturBeliBarang`) VALUES
('RB01', 'B01', 25000, 1),
('RB02', 'B03', 15500, 10),
('RB02', 'B04', 21000, 10),
('RJ03', 'B03', 15500, 5),
('RJ03', 'B04', 21000, 5);

-- --------------------------------------------------------

--
-- Table structure for table `dreturpenjualan`
--

CREATE TABLE `dreturpenjualan` (
  `KodeReturPenjualan` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `KodeBarang` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `HargaJualBarang` int NOT NULL,
  `JmlReturJualBarang` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `dreturpenjualan`
--

INSERT INTO `dreturpenjualan` (`KodeReturPenjualan`, `KodeBarang`, `HargaJualBarang`, `JmlReturJualBarang`) VALUES
('RJ01', 'B03', 15500, 5),
('RJ01', 'B04', 21000, 5);

-- --------------------------------------------------------

--
-- Table structure for table `konsumen`
--

CREATE TABLE `konsumen` (
  `KodeKonsumen` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NamaKonsumen` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `AlamatKonsumen` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `KotaKonsumen` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TelpKonsumen` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `HPKonsumen` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `konsumen`
--

INSERT INTO `konsumen` (`KodeKonsumen`, `NamaKonsumen`, `AlamatKonsumen`, `KotaKonsumen`, `TelpKonsumen`, `HPKonsumen`) VALUES
('K01', 'Dito', 'Ungaran', 'Semarang', '-', '-'),
('K02', 'Aldi', 'Boja', 'Kendal', '0089', '-'),
('K03', 'Faiz', 'Slawi', 'Tegal', '089', '-');

-- --------------------------------------------------------

--
-- Table structure for table `pembelian`
--

CREATE TABLE `pembelian` (
  `KodePembelian` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `KodeSupplier` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TglPembelian` timestamp NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `pembelian`
--

INSERT INTO `pembelian` (`KodePembelian`, `KodeSupplier`, `TglPembelian`) VALUES
('B01', 'K01', '2024-12-01 17:00:00'),
('B02', 'K02', '2024-12-01 17:00:00'),
('B03', 'K01', '2024-12-01 17:00:00'),
('B04', 'K02', '2024-12-02 13:51:00'),
('B05', 'K02', '2024-12-02 14:36:00'),
('B06', 'K03', '2024-12-02 17:10:00');

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE `penjualan` (
  `KodePenjualan` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `KodeKonsumen` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TglPenjualan` timestamp NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`KodePenjualan`, `KodeKonsumen`, `TglPenjualan`) VALUES
('J01', 'K01', '2024-12-01 17:00:00'),
('J02', 'K02', '2024-12-01 17:00:00'),
('J03', 'K02', '2024-12-02 14:56:00'),
('J04', 'K03', '2024-12-02 17:09:00');

-- --------------------------------------------------------

--
-- Table structure for table `returpembelian`
--

CREATE TABLE `returpembelian` (
  `KodeReturPembelian` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `KodePembelian` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TglReturPembelian` timestamp NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `returpembelian`
--

INSERT INTO `returpembelian` (`KodeReturPembelian`, `KodePembelian`, `TglReturPembelian`) VALUES
('RB01', 'B01', '2024-12-02 15:24:00'),
('RB02', 'B06', '2024-12-02 17:15:00'),
('RJ03', 'B06', '2024-12-02 17:16:00');

-- --------------------------------------------------------

--
-- Table structure for table `returpenjualan`
--

CREATE TABLE `returpenjualan` (
  `KodeReturPenjualan` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `KodePenjualan` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TglReturPenjualan` timestamp NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `returpenjualan`
--

INSERT INTO `returpenjualan` (`KodeReturPenjualan`, `KodePenjualan`, `TglReturPenjualan`) VALUES
('RJ01', 'J04', '2024-12-02 17:15:00');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `KodeSupplier` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NamaSupplier` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `AlamatSupplier` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `KotaSupplier` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TelpSupplier` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `HPSupplier` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`KodeSupplier`, `NamaSupplier`, `AlamatSupplier`, `KotaSupplier`, `TelpSupplier`, `HPSupplier`) VALUES
('K01', 'Fisco', 'Mijen', 'Semarang', '-', '-'),
('K02', 'Satrio', 'Gajah', 'Semarang', '089789789789', '123'),
('K03', 'Tomo', 'Sukolilo', 'Pati', '081', '1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`KodeBarang`),
  ADD KEY `KodeBarang` (`KodeBarang`);

--
-- Indexes for table `dpembelian`
--
ALTER TABLE `dpembelian`
  ADD KEY `KodePembelian` (`KodePembelian`),
  ADD KEY `KodeBarang` (`KodeBarang`);

--
-- Indexes for table `dpenjualan`
--
ALTER TABLE `dpenjualan`
  ADD KEY `KodeBarang` (`KodeBarang`),
  ADD KEY `KodePenjualan` (`KodePenjualan`);

--
-- Indexes for table `dreturpembelian`
--
ALTER TABLE `dreturpembelian`
  ADD KEY `KodeReturPembelian` (`KodeReturPembelian`),
  ADD KEY `KodeBarang` (`KodeBarang`);

--
-- Indexes for table `dreturpenjualan`
--
ALTER TABLE `dreturpenjualan`
  ADD KEY `KodeReturPenjualan` (`KodeReturPenjualan`) USING BTREE,
  ADD KEY `KodeBarang` (`KodeBarang`) USING BTREE;

--
-- Indexes for table `konsumen`
--
ALTER TABLE `konsumen`
  ADD PRIMARY KEY (`KodeKonsumen`);

--
-- Indexes for table `pembelian`
--
ALTER TABLE `pembelian`
  ADD PRIMARY KEY (`KodePembelian`),
  ADD KEY `KodeSupplier` (`KodeSupplier`);

--
-- Indexes for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`KodePenjualan`),
  ADD KEY `KodeKonsumen` (`KodeKonsumen`);

--
-- Indexes for table `returpembelian`
--
ALTER TABLE `returpembelian`
  ADD PRIMARY KEY (`KodeReturPembelian`),
  ADD KEY `KodePembelian` (`KodePembelian`);

--
-- Indexes for table `returpenjualan`
--
ALTER TABLE `returpenjualan`
  ADD PRIMARY KEY (`KodeReturPenjualan`),
  ADD KEY `KodePenjualan` (`KodePenjualan`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`KodeSupplier`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dpembelian`
--
ALTER TABLE `dpembelian`
  ADD CONSTRAINT `dpembelian_ibfk_1` FOREIGN KEY (`KodePembelian`) REFERENCES `pembelian` (`KodePembelian`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `dpembelian_ibfk_2` FOREIGN KEY (`KodeBarang`) REFERENCES `barang` (`KodeBarang`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `dpenjualan`
--
ALTER TABLE `dpenjualan`
  ADD CONSTRAINT `dpenjualan_ibfk_2` FOREIGN KEY (`KodeBarang`) REFERENCES `barang` (`KodeBarang`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `dpenjualan_ibfk_3` FOREIGN KEY (`KodePenjualan`) REFERENCES `penjualan` (`KodePenjualan`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `dreturpembelian`
--
ALTER TABLE `dreturpembelian`
  ADD CONSTRAINT `dreturpembelian_ibfk_1` FOREIGN KEY (`KodeBarang`) REFERENCES `barang` (`KodeBarang`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `dreturpembelian_ibfk_2` FOREIGN KEY (`KodeReturPembelian`) REFERENCES `returpembelian` (`KodeReturPembelian`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `dreturpenjualan`
--
ALTER TABLE `dreturpenjualan`
  ADD CONSTRAINT `dreturpenjualan_ibfk_1` FOREIGN KEY (`KodeReturPenjualan`) REFERENCES `returpenjualan` (`KodeReturPenjualan`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `dreturpenjualan_ibfk_2` FOREIGN KEY (`KodeBarang`) REFERENCES `barang` (`KodeBarang`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pembelian`
--
ALTER TABLE `pembelian`
  ADD CONSTRAINT `pembelian_ibfk_1` FOREIGN KEY (`KodeSupplier`) REFERENCES `supplier` (`KodeSupplier`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD CONSTRAINT `penjualan_ibfk_1` FOREIGN KEY (`KodeKonsumen`) REFERENCES `konsumen` (`KodeKonsumen`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `returpembelian`
--
ALTER TABLE `returpembelian`
  ADD CONSTRAINT `returpembelian_ibfk_1` FOREIGN KEY (`KodePembelian`) REFERENCES `pembelian` (`KodePembelian`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `returpenjualan`
--
ALTER TABLE `returpenjualan`
  ADD CONSTRAINT `returpenjualan_ibfk_1` FOREIGN KEY (`KodePenjualan`) REFERENCES `penjualan` (`KodePenjualan`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

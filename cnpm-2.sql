-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 28, 2021 at 01:56 PM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cnpm`
--

-- --------------------------------------------------------

--
-- Table structure for table `bangdiem`
--

CREATE TABLE `bangdiem` (
  `MaSV` varchar(10) NOT NULL,
  `MaMH` varchar(10) NOT NULL,
  `Diem` float NOT NULL,
  `LoaiDiem` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `chitietmonhoc`
--

CREATE TABLE `chitietmonhoc` (
  `MaMH` varchar(10) NOT NULL,
  `MaGV` varchar(10) NOT NULL,
  `MaSV` varchar(10) NOT NULL,
  `HocKi` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dkmonhoc`
--

CREATE TABLE `dkmonhoc` (
  `MaNhom` varchar(10) NOT NULL,
  `MaLop` varchar(10) NOT NULL,
  `TenMH` varchar(50) NOT NULL,
  `SoLuongDK` int(11) NOT NULL,
  `SoTc` int(11) NOT NULL,
  `SoTiet` int(11) NOT NULL,
  `TenGV` varchar(50) NOT NULL,
  `tiethoc` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dkmonhoc`
--

INSERT INTO `dkmonhoc` (`MaNhom`, `MaLop`, `TenMH`, `SoLuongDK`, `SoTc`, `SoTiet`, `TenGV`, `tiethoc`) VALUES
('1', '1', 'Java', 4, 4, 24, 'Quan bi', 'TH'),
('2', '2', 'Mobile', 5, 4, 48, 'Nguyen Van A', 'LT');

-- --------------------------------------------------------

--
-- Table structure for table `giangvien`
--

CREATE TABLE `giangvien` (
  `MaGV` varchar(10) NOT NULL,
  `HoTen` varchar(50) NOT NULL,
  `NgaySinh` varchar(10) NOT NULL,
  `NamBoNhiem` varchar(10) NOT NULL,
  `Makhoa` varchar(10) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `ChucVu` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `giangvien`
--

INSERT INTO `giangvien` (`MaGV`, `HoTen`, `NgaySinh`, `NamBoNhiem`, `Makhoa`, `Email`, `ChucVu`) VALUES
('1', 'Nguyen Van A', '25/07/1986', '2005', '1', 'a@gmail.com', 'Giang vien'),
('2', 'Le Cong Minh', '25/07/1996', '2015', '1', 'abc@gmail.com', 'Giang vien'),
('3', 'Luu Van An', '25/07/1997', '2016', '1', 'luu@gmail.com', 'Giang Vien'),
('4', 'Nam Dan', '01/01/1989', '2015', '1', 'abc1@gmail.com', 'Truong Khoa'),
('5', 'Quan bi', '02/02/1986', '2016', '2', 'quanbi@gmail.com', 'Truong khoa'),
('6', 'Nguyen Thi B', '25/07/1986', '2016', '2', 'abc123@gmail.com', 'Giang vien');

-- --------------------------------------------------------

--
-- Table structure for table `khoa`
--

CREATE TABLE `khoa` (
  `Makhoa` varchar(10) NOT NULL,
  `TenKhoa` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `khoa`
--

INSERT INTO `khoa` (`Makhoa`, `TenKhoa`) VALUES
('1', 'CNTT'),
('2', 'CNPM');

-- --------------------------------------------------------

--
-- Table structure for table `lop`
--

CREATE TABLE `lop` (
  `MaLop` varchar(10) NOT NULL,
  `TenLop` varchar(50) NOT NULL,
  `MaKhoa` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lop`
--

INSERT INTO `lop` (`MaLop`, `TenLop`, `MaKhoa`) VALUES
('1', 'DCT119C2', '1'),
('2', 'DCT119C3', '1'),
('3', 'DCT119C4', '2'),
('4', 'DCT119C4', '2');

-- --------------------------------------------------------

--
-- Table structure for table `monhoc`
--

CREATE TABLE `monhoc` (
  `MaMH` varchar(10) NOT NULL,
  `TenMH` varchar(50) NOT NULL,
  `SoTc` int(10) NOT NULL,
  `ThucHanh` int(10) NOT NULL,
  `LiThuyet` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `monhoc`
--

INSERT INTO `monhoc` (`MaMH`, `TenMH`, `SoTc`, `ThucHanh`, `LiThuyet`) VALUES
('1', 'Java', 4, 1, 0),
('2', 'Java', 4, 0, 1),
('3', 'Mobile', 4, 1, 0),
('4', 'Mobile', 4, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `nhommh`
--

CREATE TABLE `nhommh` (
  `MaNhom` varchar(10) NOT NULL,
  `MaMH` varchar(10) NOT NULL,
  `TenMH` varchar(50) NOT NULL,
  `Succhua` int(10) NOT NULL,
  `TenGV` varchar(50) NOT NULL,
  `tiethoc` varchar(50) NOT NULL,
  `sotuanhoc` int(10) NOT NULL,
  `tongphantiet` int(10) NOT NULL,
  `tongtiet` int(11) NOT NULL,
  `hocki` varchar(50) NOT NULL,
  `namhoc` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nhommh`
--

INSERT INTO `nhommh` (`MaNhom`, `MaMH`, `TenMH`, `Succhua`, `TenGV`, `tiethoc`, `sotuanhoc`, `tongphantiet`, `tongtiet`, `hocki`, `namhoc`) VALUES
('1', '1', 'Java', 100, 'Quan bi', 'TH', 12, 2, 24, '1', '2020-2021'),
('2', '3', 'Mobile', 100, 'Nguyen Van A', 'TH', 12, 4, 48, '2', '2020-2021');

-- --------------------------------------------------------

--
-- Table structure for table `sinhvien`
--

CREATE TABLE `sinhvien` (
  `MaSV` varchar(10) NOT NULL,
  `HoTen` varchar(50) NOT NULL,
  `NgaySinh` varchar(10) NOT NULL,
  `GioiTinh` varchar(10) NOT NULL,
  `MaLop` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sinhvien`
--

INSERT INTO `sinhvien` (`MaSV`, `HoTen`, `NgaySinh`, `GioiTinh`, `MaLop`) VALUES
('1', 'Tran Cong Bach', '25/07/2001', 'Nu', '2'),
('2', 'Nguyen Ngoc Gia Bao', '25/10/2001', 'Nu', '1'),
('3', 'Nguyen Quoc Binh', '25/07/2001', 'Nam', '1'),
('4', 'Le Nhut Duy', '25/10/2001', 'Nam', '1'),
('5', 'Huynh Gia Han', '25/07/2001', 'Nu', '2'),
('6', 'Dang Ngoc Khang', '25/10/2001', 'Nam', '2'),
('7', 'Vo Tuan Khoi', '25/07/2001', 'Nam', '2'),
('8', 'Nguyen Huu Nghia', '25/10/2001', 'Nam', '2'),
('9', 'Nguy?n V?n A', '25/07/2001', 'Nu', '1');

--
-- Triggers `sinhvien`
--
DELIMITER $$
CREATE TRIGGER `trg_themsv` AFTER INSERT ON `sinhvien` FOR EACH ROW update dkmonhoc
SET 	MaNhom = MaNhom,
		MaLop = MaLop,
        TenMH = TenMH,
		SoLuongDK = SoLuongDK +1,
        SoTC = SoTC,
        SoTiet = SoTiet,
        TenGV = TenGV,
        tiethoc= tiethoc
        
 WHERE dkmonhoc.MaLop = NEW.MaLop
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `updatesinhvien` AFTER UPDATE ON `sinhvien` FOR EACH ROW BEGIN
BEGIN
update dkmonhoc
SET 	MaNhom = MaNhom,
		MaLop = MaLop,
        TenMH = TenMH,
		SoLuongDK = SoLuongDK +1,
        SoTC = SoTC,
        SoTiet = SoTiet,
        TenGV = TenGV,
        tiethoc= tiethoc
        
 WHERE dkmonhoc.MaLop = NEW.MaLop;
 end;
 update dkmonhoc
SET 	MaNhom = MaNhom,
		MaLop = MaLop,
        TenMH = TenMH,
		SoLuongDK = SoLuongDK -1,
        SoTC = SoTC,
        SoTiet = SoTiet,
        TenGV = TenGV,
        tiethoc= tiethoc
        
 WHERE dkmonhoc.MaLop = OLD.MaLop;
 END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `xoasv` AFTER DELETE ON `sinhvien` FOR EACH ROW update dkmonhoc
SET 	MaNhom = MaNhom,
		MaLop = MaLop,
        TenMH = TenMH,
		SoLuongDK = SoLuongDK-1,
        SoTC = SoTC,
        SoTiet = SoTiet,
        TenGV = TenGV,
        tiethoc= tiethoc
        
 WHERE dkmonhoc.MaLop = OLD.MaLop
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bangdiem`
--
ALTER TABLE `bangdiem`
  ADD PRIMARY KEY (`MaSV`,`MaMH`),
  ADD KEY `MaSV` (`MaSV`),
  ADD KEY `MaMH` (`MaMH`);

--
-- Indexes for table `chitietmonhoc`
--
ALTER TABLE `chitietmonhoc`
  ADD PRIMARY KEY (`MaMH`,`MaGV`,`MaSV`),
  ADD KEY `MaMH` (`MaMH`),
  ADD KEY `MaGV` (`MaGV`),
  ADD KEY `MaSV` (`MaSV`);

--
-- Indexes for table `dkmonhoc`
--
ALTER TABLE `dkmonhoc`
  ADD PRIMARY KEY (`MaNhom`,`MaLop`),
  ADD KEY `MaNhom` (`MaNhom`),
  ADD KEY `dkmonhoc_ibfk_1` (`MaLop`);

--
-- Indexes for table `giangvien`
--
ALTER TABLE `giangvien`
  ADD PRIMARY KEY (`MaGV`),
  ADD KEY `Makhoa` (`Makhoa`);

--
-- Indexes for table `khoa`
--
ALTER TABLE `khoa`
  ADD PRIMARY KEY (`Makhoa`);

--
-- Indexes for table `lop`
--
ALTER TABLE `lop`
  ADD PRIMARY KEY (`MaLop`),
  ADD KEY `MaKhoa` (`MaKhoa`);

--
-- Indexes for table `monhoc`
--
ALTER TABLE `monhoc`
  ADD PRIMARY KEY (`MaMH`);

--
-- Indexes for table `nhommh`
--
ALTER TABLE `nhommh`
  ADD PRIMARY KEY (`MaNhom`),
  ADD KEY `MaMH` (`MaMH`);

--
-- Indexes for table `sinhvien`
--
ALTER TABLE `sinhvien`
  ADD PRIMARY KEY (`MaSV`),
  ADD KEY `MaLop` (`MaLop`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bangdiem`
--
ALTER TABLE `bangdiem`
  ADD CONSTRAINT `bangdiem_ibfk_1` FOREIGN KEY (`MaMH`) REFERENCES `monhoc` (`MaMH`),
  ADD CONSTRAINT `bangdiem_ibfk_2` FOREIGN KEY (`MaSV`) REFERENCES `sinhvien` (`MaSV`);

--
-- Constraints for table `chitietmonhoc`
--
ALTER TABLE `chitietmonhoc`
  ADD CONSTRAINT `chitietmonhoc_ibfk_1` FOREIGN KEY (`MaGV`) REFERENCES `giangvien` (`MaGV`),
  ADD CONSTRAINT `chitietmonhoc_ibfk_2` FOREIGN KEY (`MaMH`) REFERENCES `monhoc` (`MaMH`),
  ADD CONSTRAINT `chitietmonhoc_ibfk_3` FOREIGN KEY (`MaSV`) REFERENCES `sinhvien` (`MaSV`);

--
-- Constraints for table `dkmonhoc`
--
ALTER TABLE `dkmonhoc`
  ADD CONSTRAINT `dkmonhoc_ibfk_1` FOREIGN KEY (`MaLop`) REFERENCES `lop` (`MaLop`),
  ADD CONSTRAINT `dkmonhoc_ibfk_2` FOREIGN KEY (`MaNhom`) REFERENCES `nhommh` (`MaNhom`);

--
-- Constraints for table `giangvien`
--
ALTER TABLE `giangvien`
  ADD CONSTRAINT `giangvien_ibfk_1` FOREIGN KEY (`Makhoa`) REFERENCES `khoa` (`Makhoa`);

--
-- Constraints for table `lop`
--
ALTER TABLE `lop`
  ADD CONSTRAINT `lop_ibfk_1` FOREIGN KEY (`MaKhoa`) REFERENCES `khoa` (`Makhoa`);

--
-- Constraints for table `nhommh`
--
ALTER TABLE `nhommh`
  ADD CONSTRAINT `nhommh_ibfk_1` FOREIGN KEY (`MaMH`) REFERENCES `monhoc` (`MaMH`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

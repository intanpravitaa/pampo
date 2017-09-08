-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 08, 2017 at 01:00 PM
-- Server version: 10.1.8-MariaDB
-- PHP Version: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pampo`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_review`
--

CREATE TABLE `tbl_review` (
  `id_review` int(11) NOT NULL,
  `judul_review` varchar(150) NOT NULL,
  `gambar_review` varchar(250) NOT NULL,
  `deskripsi_review` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_review`
--

INSERT INTO `tbl_review` (`id_review`, `judul_review`, `gambar_review`, `deskripsi_review`) VALUES
(1, 'Bakso Pakde Iyok', 'bakso_pakde_iyok.jpg', 'Bakso pakde iyok terletak di Jl. Kamboja (tepat di jalan sebelah BRI Raden Intan, ke arah Kebon Jahe. Berada di deretan ruko klinik kecantikan)\nWaktu buka : 08.00 - 13.00 WIB\nRange harga : Rp 10.000 - Rp 14.000'),
(2, 'Bubur Ayam Yubi', 'buryam_yubi.jpg', 'Alamat : Jl. Basuki Rahmat(Pertigaan samping markas polisi militer), Teluk Betung\r\nWaktu buka : Pkl 06.30 WIB - habis\r\nHarga : \r\nBubur ayam 1 porsi (lengkap dengan ati ampela), Rp 8.000\r\nTelur asin, Rp 4.000'),
(3, 'Encim Gendut', 'encim_gendut.jpg', 'Alamat : Jl. Lindu No.6, Palapa, Tj. Karang Pusat, Kota Bandar Lampung, Lampung 35119 (di belakang LBPP Lia Kartini)\r\nWaktu buka : Senin - Sabtu (Prasmanan) 07.00 - 16.00 WIB\r\nMinggu (All You Can''t Eat) 08.00 - 15.30 WIB\r\nRange harga : Rp 3.000 - 20.000\r\n'),
(4, 'Enggal Resto', 'enggal_resto.jpg', 'Alamat : Jalan S. Parman No.26, Pelita, Enggal (dekat Hotel Andalas Permai)\r\nWaktu buka (Khusus menu sarapan) : Senin-Sabtu Pkl 07.00 - 10.00 WIB\r\nMinggu Pkl 08.00 - 11.00 WIB\r\nRange harga : \r\nBubur ayam : Rp 15.000\r\nMie ayam polos : Rp 15.000\r\nMie ayam bakso + pangsit : Rp 20.000\r\nMie ayam bakso + pangsit + ceker : Rp 23.000\r\nAyam rebus : Rp 21.000\r\nCeker enggal : Rp 19.000\r\nPangsit : Rp 12.000\r\nBakso : Rp 10.000'),
(5, 'Jons Boulangerie Patisserie', 'jons_boulange.jpg', 'Alamat : Jl. Jenderal Sudirman 55E\r\nWaktu buka : Setiap hari Pl 06.00 - 21.30 WIB\r\nRange harga : Rp 8.000 - 25.000\r\nNomor telepon : (0721) 5605039/0813 7960 0077'),
(6, 'Kantin Mie Ayam 168', 'mie_168.jpg', 'Alamat : Jl. Mister Gele Harun No. 28, Rawa Laut, Bandarlampung (Deretan SMP Negeri 1 Bandarlampung)\r\nWaktu buka : Pkl 08.00 - 17.00 WIB\r\nTelepon : 0811 7222 168\r\nRange harga : \r\nMie Ayam RP 18.000\r\nFu Kian/The Fu Kok Rp 18.000\r\nMie Ayam + Fu Kian/The Fu Kok Rp 34.000'),
(7, 'New Town Coffee', 'new_town.jpg', 'Alamat : Hotel Grand Anugrah Express, Jl. Ahmad Yani No.1, Tanjung Karang, Bandarlampung\r\nWaktu buka : Senin - Minggu (Pkl 07.00 - 11.00 WIB)\r\nTelepon : 0721-251000 \r\nHarga : Nasi Tim Rp 25.000'),
(8, 'Mie Selada Lampung', 'selada.jpg', 'Alamat : Jl. Ikan Hiu Blok C No. 9, Teluk Betung, Lampung\r\nWaktu buka : Selasa - Minggu (Pkl 07.00 - 15.00 WIB)\r\nTelepon : 082176431700\r\nRange harga :\r\nBakmi Komplit Rp 23.000\r\nBakso Goreng RP 6.000\r\nPangsit Kuah Rp 15.000 (5 pcs)\r\nPangsit Goreng Rp 3.500'),
(9, 'Soto Lamongan Cak Wid', 'soto_lamongan.jpg', 'Alamat : Pintu masuk arah PKOR\r\nWaktu buka : Pkl 07.00 WIB - sore\r\nRange harga:\r\nSoto lamongan Rp 12.000\r\nNasi RP 3.000'),
(10, 'Bubur Ayam Van Danoe', 'van_danoe.jpg', 'Alamat : di samping Hotel Anugerah Express, Jl. Ahmad Yani, Bandarlampung (sebelah Salon Fendri)\r\nWaktu buka : Pkl 06.00 WIB - habis\r\nRange harga : Rp 12.000 - 25.000');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `id` int(11) NOT NULL,
  `unique_id` varchar(23) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `encrypted_password` varchar(80) NOT NULL,
  `salt` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`id`, `unique_id`, `nama`, `email`, `encrypted_password`, `salt`) VALUES
(1, '59a9c58a016b97.87860623', 'intan', 'intanpravitaa@gmail.com', 'ok7xCI+CyZh198XZ9tDhz2+XWjdhODFiZDM4N2E0', 'a81bd387a4'),
(2, '59b0efa3d63998.27038698', 'najib darmawan', 'najibd@gmail.com', 'jOeM6ckcQy8GZ+jBoQc4c/iQIuczMjA1OTE5YjI1', '3205919b25');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_review`
--
ALTER TABLE `tbl_review`
  ADD PRIMARY KEY (`id_review`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_id` (`unique_id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_review`
--
ALTER TABLE `tbl_review`
  MODIFY `id_review` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 17, 2017 at 04:43 PM
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
-- Table structure for table `tbl_rating`
--

CREATE TABLE `tbl_rating` (
  `rating_id` int(11) NOT NULL,
  `user_id` int(7) DEFAULT NULL,
  `item_id` int(7) DEFAULT NULL,
  `rating` int(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_rating`
--

INSERT INTO `tbl_rating` (`rating_id`, `user_id`, `item_id`, `rating`) VALUES
(2, 1, 1, 0),
(3, 1, 2, 5),
(4, 1, 3, 0),
(5, 1, 5, 2),
(6, 2, 1, 4),
(7, 2, 2, 0),
(8, 2, 4, 5),
(9, 2, 5, 5),
(10, 3, 1, 1),
(11, 3, 3, 4),
(12, 3, 4, 1),
(13, 3, 5, 0),
(14, 4, 2, 2),
(15, 4, 3, 1),
(16, 4, 4, 1),
(17, 5, 1, 1),
(18, 5, 2, 0),
(19, 5, 3, 5),
(20, 5, 5, 3),
(21, 6, 1, 1),
(22, 6, 2, 1),
(23, 6, 4, 5),
(24, 6, 5, 1),
(25, 7, 1, 3),
(26, 7, 3, 0),
(27, 7, 4, 2),
(28, 7, 5, 5),
(29, 8, 2, 3),
(30, 8, 3, 0),
(31, 8, 4, 5),
(32, 9, 1, 3),
(33, 9, 2, 1),
(34, 9, 3, 3),
(35, 9, 5, 3),
(36, 10, 1, 1),
(37, 10, 2, 0),
(38, 10, 4, 5),
(39, 10, 5, 5),
(40, 11, 1, 1),
(41, 11, 3, 5),
(42, 11, 4, 0),
(43, 11, 5, 0),
(44, 12, 2, 3),
(45, 12, 3, 4),
(46, 12, 4, 5),
(47, 13, 1, 5),
(48, 13, 2, 0),
(49, 13, 3, 2),
(50, 13, 5, 4),
(51, 14, 1, 5),
(52, 14, 2, 5),
(53, 14, 4, 3),
(54, 14, 5, 4),
(55, 15, 1, 4),
(56, 15, 3, 5),
(57, 15, 4, 4),
(58, 15, 5, 5),
(59, 16, 2, 5),
(60, 16, 3, 3),
(61, 16, 4, 3),
(62, 17, 1, 3),
(63, 17, 2, 5),
(64, 17, 3, 0),
(65, 17, 5, 3),
(66, 18, 1, 4),
(67, 18, 2, 0),
(68, 18, 4, 0),
(69, 18, 5, 2),
(70, 19, 1, 3),
(71, 19, 3, 5),
(72, 19, 4, 1),
(73, 19, 5, 1),
(74, 20, 2, 2),
(75, 20, 3, 4),
(76, 20, 4, 4),
(77, 21, 1, 1),
(78, 21, 2, 3),
(79, 21, 3, 3),
(80, 21, 5, 1),
(81, 22, 1, 3),
(82, 22, 2, 0),
(83, 22, 4, 0),
(84, 22, 5, 0),
(85, 23, 1, 5),
(86, 23, 3, 0),
(87, 23, 4, 2),
(88, 23, 5, 2),
(89, 24, 2, 0),
(90, 24, 3, 1),
(91, 24, 4, 0),
(92, 25, 1, 0),
(93, 25, 2, 4),
(94, 25, 3, 5),
(95, 25, 5, 5),
(96, 26, 1, 2),
(97, 26, 2, 1),
(98, 26, 4, 3),
(99, 26, 5, 3),
(100, 27, 1, 3),
(101, 27, 3, 0),
(102, 27, 4, 5),
(103, 27, 5, 5),
(104, 28, 2, 1),
(105, 28, 3, 2),
(106, 28, 4, 2),
(107, 29, 1, 3),
(108, 29, 2, 2),
(109, 29, 3, 5),
(110, 29, 5, 5),
(111, 30, 1, 4),
(112, 30, 2, 2),
(113, 30, 4, 4),
(114, 30, 5, 2),
(115, 31, 1, 1),
(116, 31, 3, 4),
(117, 31, 4, 4),
(118, 31, 5, 0),
(119, 32, 2, 5),
(120, 32, 3, 1),
(121, 32, 4, 2),
(122, 33, 1, 1),
(123, 33, 2, 3),
(124, 33, 3, 3),
(125, 33, 5, 4),
(126, 34, 1, 0),
(127, 34, 2, 3),
(128, 34, 4, 4),
(129, 34, 5, 3),
(130, 35, 1, 3),
(131, 35, 3, 0),
(132, 35, 4, 1),
(133, 35, 5, 5),
(134, 36, 2, 3),
(135, 36, 3, 0),
(136, 36, 4, 0),
(137, 37, 1, 1),
(138, 37, 2, 3),
(139, 37, 3, 2),
(140, 37, 5, 4),
(141, 38, 1, 3),
(142, 38, 2, 4),
(143, 38, 4, 1),
(144, 38, 5, 1),
(145, 39, 1, 4),
(146, 39, 3, 4),
(147, 39, 4, 5),
(148, 39, 5, 1),
(149, 40, 2, 1),
(150, 40, 3, 3),
(151, 40, 4, 1),
(152, 41, 1, 0),
(153, 41, 2, 2),
(154, 41, 3, 0),
(155, 41, 5, 1),
(156, 42, 1, 0),
(157, 42, 2, 3),
(158, 42, 4, 1),
(159, 42, 5, 4),
(160, 43, 1, 1),
(161, 43, 3, 0),
(162, 43, 4, 4),
(163, 43, 5, 5),
(164, 44, 2, 0),
(165, 44, 3, 4),
(166, 44, 4, 2),
(167, 45, 1, 4),
(168, 45, 2, 5),
(169, 45, 3, 4),
(170, 45, 5, 5),
(171, 46, 1, 2),
(172, 46, 2, 4),
(173, 46, 4, 3),
(174, 46, 5, 3),
(175, 47, 1, 1),
(176, 47, 3, 0),
(177, 47, 4, 1),
(178, 47, 5, 2),
(179, 48, 2, 4),
(180, 48, 3, 2),
(181, 48, 4, 4),
(182, 49, 1, 5),
(183, 49, 2, 5),
(184, 49, 3, 5),
(185, 49, 5, 5),
(186, 50, 1, 2),
(187, 50, 2, 1),
(188, 50, 4, 1),
(189, 50, 5, 5),
(190, 51, 1, 3),
(191, 51, 3, 4),
(192, 51, 4, 3),
(193, 51, 5, 0),
(194, 52, 2, 5),
(195, 52, 3, 2),
(196, 52, 4, 0),
(197, 53, 1, 0),
(198, 53, 2, 3),
(199, 53, 3, 2),
(200, 53, 5, 1),
(201, 54, 1, 3),
(202, 54, 2, 5),
(203, 54, 4, 2),
(204, 54, 5, 3),
(205, 55, 1, 4),
(206, 55, 3, 4),
(207, 55, 4, 1),
(208, 55, 5, 4),
(209, 56, 2, 0),
(210, 56, 3, 4),
(211, 56, 4, 2),
(212, 57, 1, 2),
(213, 57, 2, 2),
(214, 57, 3, 0),
(215, 57, 5, 2),
(216, 58, 1, 4),
(217, 58, 2, 1),
(218, 58, 4, 5),
(219, 58, 5, 2),
(220, 59, 1, 2),
(221, 59, 3, 2),
(222, 59, 4, 0),
(223, 59, 5, 1),
(224, 60, 2, 3),
(225, 60, 3, 4),
(226, 60, 4, 3),
(227, 61, 1, 2),
(228, 61, 2, 2),
(229, 61, 3, 0),
(230, 61, 5, 2),
(231, 62, 1, 3),
(232, 62, 2, 5),
(233, 62, 4, 3),
(234, 62, 5, 2),
(235, 63, 1, 5),
(236, 63, 3, 5),
(237, 63, 4, 4),
(238, 63, 5, 4),
(239, 64, 2, 5),
(240, 64, 3, 4),
(241, 64, 4, 0),
(242, 65, 1, 4),
(243, 65, 2, 5),
(244, 65, 3, 1),
(245, 65, 5, 2),
(246, 66, 1, 2),
(247, 66, 2, 5),
(248, 66, 4, 2),
(249, 66, 5, 2),
(250, 67, 1, 4),
(251, 67, 3, 2),
(252, 67, 4, 5),
(253, 67, 5, 0),
(254, 68, 2, 0),
(255, 68, 3, 2),
(256, 68, 4, 5),
(257, 69, 1, 0),
(258, 69, 2, 0),
(259, 69, 3, 0),
(260, 69, 5, 2),
(261, 70, 1, 2),
(262, 70, 2, 3),
(263, 70, 4, 2),
(264, 70, 5, 5),
(265, 71, 1, 0),
(266, 71, 3, 2),
(267, 71, 4, 3),
(268, 71, 5, 0),
(269, 72, 2, 5),
(270, 72, 3, 1),
(271, 72, 4, 2),
(272, 73, 1, 0),
(273, 73, 2, 4),
(274, 73, 3, 0),
(275, 73, 5, 0),
(276, 74, 1, 3),
(277, 74, 2, 3),
(278, 74, 4, 0),
(279, 74, 5, 1),
(280, 75, 1, 4),
(281, 75, 3, 0),
(282, 75, 4, 0),
(283, 75, 5, 5),
(284, 76, 2, 0),
(285, 76, 3, 1),
(286, 76, 4, 1),
(287, 77, 1, 0),
(288, 77, 2, 1),
(289, 77, 3, 0),
(290, 77, 5, 5),
(291, 78, 1, 2),
(292, 78, 2, 4),
(293, 78, 4, 0),
(294, 78, 5, 5),
(295, 79, 1, 2),
(296, 79, 3, 3),
(297, 79, 4, 5),
(298, 79, 5, 0),
(299, 80, 2, 5),
(300, 80, 3, 0),
(301, 80, 4, 2);

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
(2, '59b0efa3d63998.27038698', 'najib darmawan', 'najibd@gmail.com', 'jOeM6ckcQy8GZ+jBoQc4c/iQIuczMjA1OTE5YjI1', '3205919b25'),
(3, '59ba7da17a81c1.85049515', 'prasetyo sudarji', 'prasetyosudarji@gmail.com', '3SPAQdihxIbAvCQ6ow0gxnmd+X0xOTYzYWUwOTA2', '1963ae0906'),
(4, '59ba7e3c027619.41875605', 'aprilia', 'aprilia@gmail.com', '/PaRidB87XmclFj8H9WJPz4sijY0YTQ1MGFiODgz', '4a450ab883'),
(5, '59ba7e64616cf1.80122172', 'bernardus galih', 'galihdwi@gmail.com', 'pmgLhmaCvMGoyPLeGoRJJn/qYbtjMDdlMDU4ZmM1', 'c07e058fc5'),
(6, '59ba7e7f156ec7.67623652', 'ade sekarini', 'adesekar@gmail.com', 'dl9lTQm7hwq+vsIXDdlloblrwTk2MmQ2MDM1OTA5', '62d6035909'),
(7, '59ba7ea3daa2b1.54276122', 'anggi mukti', 'anggimukti@gmail.com', 'HS063D5ZPIGM3o0wujCBHpyRV6JmNzc1MTQxNjg3', 'f775141687'),
(8, '59ba7eb0c24e68.96816460', 'agung apriadi', 'agungaa@gmail.com', 'CXdy158DofGEunysDH/HqnJJhLE0OTg3YTRhNzZi', '4987a4a76b'),
(9, '59ba7ec242d4b3.85389796', 'ahman hasan alfikri', 'fikri@yahoo.com', '4gUooOnSla82DknyQekT4DrAHyVkNTQyNmVmN2Rk', 'd5426ef7dd'),
(10, '59ba7ed2b92c80.04039428', 'ariq suherman', 'bukanariq@outlook.com', '+910CW/Et8gMCD70V7/rgJUidG44ZjFlM2YxMzJm', '8f1e3f132f'),
(11, '59ba7ee2702dd6.39907199', 'bintang bagus', 'bintangbp@hotmail.com', '4rTj+gpbIkiBpyGgZlgSsSf/3NViZjQ0N2M2ZWIy', 'bf447c6eb2'),
(12, '59ba7eece99c33.25054948', 'bramah ing sona', 'wakyeng@hotmail.com', 'fYuWMqfHOJn6HASq9FtazedVmZUwMmRjZDhhOWRl', '02dcd8a9de'),
(13, '59ba7f2cbc5204.84816371', 'ditto amalsyah', 'dittoamalsyah@hotmail.com', 'udtlUWzSb/8BvHQf/lyb+nyXqYUxNjUyNWI5ZWQx', '16525b9ed1'),
(14, '59ba7f3ba3e4f7.43979492', 'domu silalahi', 'domusilalahi@gmail.com', 'PfcMqvKNECjDfvXCo7uzVHR1cYxkMGE4ZWM4ZjM4', 'd0a8ec8f38'),
(15, '59ba7f48dabfe0.72516790', 'gde komang', 'gdekmatmajaya@gmail.com', 'gsQ4X49p8w+Oe8oHayya8fSzvLVkODM5OTAxZDg2', 'd839901d86'),
(16, '59ba7f5a47acb3.49022105', 'genggam mahardhika', 'genggam@gmail.com', 'e8cjRd0Ry1WdFCGgcIIcDCSTh41jMTQyOTBjNWNh', 'c14290c5ca'),
(17, '59ba7f63896730.54472852', 'hardiyan utama', 'tama@gmail.com', '3bCjflu3lHe1Et+8fN65SJztbBMzMTMzNTZmMGQx', '313356f0d1'),
(18, '59ba7f76e4d421.62730037', 'ibrahim amyas', 'baimtarigan@gmail.com', 'g0Nf5Rhz4U5EjuU3+yUuHwCO5y85YmJkNGNkZjcw', '9bbd4cdf70'),
(19, '59ba7f896a9330.14790303', 'jauhar ismiyadinata', 'jauhar@gmail.com', 'Hl3gw1KStJ5Jo9RIo6Rf+YTVvqI4YjYxMjMyODU3', '8b61232857'),
(20, '59ba7f970b8079.07919152', 'danovan aryandanu', 'danovandanu@gmail.com', 'Nl6zJUmsQ9ItVBwSCSPCY/v1cyUxNjIyNDM1ZDdj', '1622435d7c'),
(21, '59ba7fa10a6d71.62093654', 'ridho pambudi', 'ridhombud@gmail.com', 'CqqhdJ2JIVTySX4ld3yIUktoAmtjMTQ2NTZkMmZl', 'c14656d2fe'),
(22, '59ba7facbcdd68.09287794', 'muhammad agung', 'agung14@gmail.com', '9rldXCsBmvc5Z7hl30+ZFYeRsb5kZmI0MGFiZGNi', 'dfb40abdcb'),
(23, '59ba7fbb17ec44.87171762', 'ravinus daniel', 'daniel@yahoo.com', '0/UKzjtST8gTkQz0vJ9rnSuqFLNiMTc5ZWUyZTY4', 'b179ee2e68'),
(24, '59ba7fcaaa11d5.32246935', 'reizky patrical', 'reizkysirya@gmail.com', 'wZL5EKAXbvHD/MKeAb247Vb1s9Q5Y2E5NjY2ODgw', '9ca9666880'),
(25, '59ba7fd6f3bab8.15150692', 'ridho batubara', 'ridhobeter@gmail.com', 'cJGQiCEDN5y/3S1Pp1WScWKka0c1MGVmNGY1YTlj', '50ef4f5a9c'),
(26, '59ba7fe76a3509.74445706', 'riyon sanjaya', 'riyonsanjaya@gmail.com', 'xSEewc+mYsIgUdYx461UgfEamAo3ZjAzZjNmMmZl', '7f03f3f2fe'),
(27, '59ba7ff3200090.20412366', 'theo manullang', 'omtheo@gmail.com', 'jfkiVEwy8b4QnGBS/gYLR33DYLs5MTI0NTk0MWM5', '91245941c9'),
(28, '59ba80036e4d74.95767402', 'tommy ikhwan', 'tommyikhwan@yahoo.com', 'CcAUUSds3aPBpRQ5Bhee1oE0iBUwMjM4MWQ3MjUw', '02381d7250'),
(29, '59ba802e75ef29.12868514', 'ade febriana', 'adenana@gmail.com', 'GGLpB/mzHsFE0mFQsUkMQawgFUcwMmRkYjY0YzIz', '02ddb64c23'),
(30, '59ba803d4adc51.62601086', 'ayu maya sari', 'ayumaya@outlook.com', 'qaMNiOsGtcBAkvQ2JEMCa2abOl9iZTI3ZWEwZGYw', 'be27ea0df0'),
(31, '59ba8049a2d300.22570679', 'fitri weliya', 'makwel@yahoo.com', 'y3+27l+gOmGSZdsRA+re8QaYTkQyN2UyMGUxYzYx', '27e20e1c61'),
(32, '59ba80576e87a4.90281757', 'lintang kurnia aridini', 'lintangkurniaa@gmail.com', 'n7FMbmAjt3SSweC1SQdiZm7G8zg2ZTkxNGU1OTY4', '6e914e5968'),
(33, '59ba80639536c9.35425694', 'ni made shanti', 'madeshanti@gmail.com', 'hdNGlWNDVaLdkVojcDUTD+HjYKczNTZhMTkyYjc5', '356a192b79'),
(34, '59ba80714c32f5.99091855', 'bunga apriyanti', 'unge@gmail.com', 'X+gpHjer6qpfw1giNZxcLKCt4sQ0MmVlNzgxYmJm', '42ee781bbf'),
(35, '59ba807bdba011.55687013', 'yucky anggun', 'yuckyaa@gmail.com', 'RRiH/my+wyLizBZOrlaNZGEuWjc1M2NmMTBiZjA2', '53cf10bf06'),
(36, '59ba808b4a8cd7.51948193', 'febriko fajar alafim', 'febrikoalafim@hotmail.com', 'CZ9CpEROqSB1+zjlV+JvfFA5tuxjZWY2YmQ1Y2Qx', 'cef6bd5cd1'),
(37, '59ba809d38aab9.05097202', 'dhandy mahardhika', 'dhandymahar@gmail.com', '5OlfwQHWlP3Wlz/NeScrTyJV+cFjOTk2MTJmZWZh', 'c99612fefa'),
(38, '59ba80b3218651.00374742', 'gabreilla posparani', 'gabih@gmail.com', 'PtopFZI1jbVEq754H24p/wFv+GE5ZjFlZmMzYzAz', '9f1efc3c03'),
(39, '59ba80c39d9f69.22932657', 'aderia damayanti', 'aderder@gmail.com', 'hkUb7G1Oew5DVMYfE7fTYc90P4wzMmVhZjc4OGI3', '32eaf788b7'),
(40, '59ba80cf4fbd12.04079686', 'st ananda yukarina', 'sete@yahoo.com', 'gFOeR7Vm6Yjr+pWIC1aYdkuCO+FkNTU0NTlhNGMw', 'd55459a4c0'),
(41, '59ba80db1a4461.88809210', 'desintha fachrunissa', 'decin@gmail.com', '85EFgJGREuOoWUMhVxj3ud0k9rYyMWNkMDM1Nzdk', '21cd03577d'),
(42, '59ba80f0b1d3d6.55708110', 'yusuf hasyim', 'ucup@gmail.com', 'I+PXxI1UuE/xBkyZIHY1LQO7D1kyMDFmMzUxYjZj', '201f351b6c'),
(43, '59ba810086d5d0.94762454', 'aditia reshi', 'adit.chipmunk@gmail.com', 'jB2K4jUtyxp4EoJEq27zQOCqLVFiNDRjZTBkYjdh', 'b44ce0db7a'),
(44, '59ba811294fe28.15165507', 'desnacita harly', 'citacit@gmail.com', 'dJYPDguTjlGkQ0LBL7for/knF3llMGU3YTFhNDMz', 'e0e7a1a433'),
(45, '59ba8126b030c0.17884769', 'diah ayu', 'diahuii@gmail.com', 'ZLn4orwRDAxdNAXbuXXPuWcuNCc2NGM1MTliZjRl', '64c519bf4e'),
(46, '59ba8131e89660.06203224', 'amelia shervina', 'vinamel@gmail.com', 'XhxTWR/6apqpD2CqQjlt4Ioxt3BjMWM4N2VjZjUy', 'c1c87ecf52'),
(47, '59ba813da46592.52725094', 'dinda oktarini', 'dindadeo@gmail.com', 'GKxxDneWUMEwNkme1GDUKmbBFQsxYzA4ZmE0Mjcw', '1c08fa4270'),
(48, '59ba814b34e206.71556113', 'dini ambarwaty', 'diniambar@yahoo.com', '9qbR3nnsfVUkHObOeyLHhJjFxIkyNjRlMGY2ZWY1', '264e0f6ef5'),
(49, '59ba8158e5e4b4.20942665', 'fahmi aziz', 'abangaziz@gmail.com', 'aWrGx+VuFWa3ne+EXHTdyky0QB4wZGI5Y2NmNjE4', '0db9ccf618'),
(50, '59ba81690cf388.98541961', 'gendhy prima', 'gendhyprima@gmail.com', 'jQBRc30QVw6LMhpO8aEVeL1gtIc1ZjJmZGQwNTc3', '5f2fdd0577'),
(51, '59ba8175b4a0b9.52354997', 'gerry laksono', 'gerrylaksono@gmail.com', 'GVjQMbYsU8UxMCbCpWLZpMQHQh5mNmZiNWZmN2Nm', 'f6fb5ff7cf'),
(52, '59ba818807cac9.03848283', 'mahrifa gita', 'mahrifagitta@gmail.com', 'mv/6ZLm1LmxpeZRgb2enRZX5wFIwZWEwMDM0NDRm', '0ea003444f'),
(53, '59ba81944a70f7.15931888', 'jenisa devy', 'unijeni@gmail.com', 'mxu0JamwClY5DGwxtxGMKe/GkiU2YjA2Y2Q3MjA5', '6b06cd7209'),
(54, '59ba81a2db9819.31055608', 'muamar katon', 'katonipoy@yahoo.com', 'DC+T2ArOVJaebetHW+xK+HnBfQI3N2MyYWQzMmY3', '77c2ad32f7'),
(55, '59ba81bc031f87.75489174', 'nurul amira', 'nuyul@gmail.com', 'c8DYArBK/7xM5mtrzuy2f89XvclhMDcwODFiOTFh', 'a07081b91a'),
(56, '59ba81cd907ee5.82236510', 'pia sabrina murthado', 'piasabrina@gmail.com', 'vN9cin0Uh2kvccsSJYlILEFBqFI5YjNkOTc2YWNk', '9b3d976acd'),
(57, '59ba81f2c526f9.88605816', 'rachmat abdillah', 'mamathakim@gmail.com', 'FJuOKSrp4oBGPDpqJrW27WtLT1gyZGU3OTY2OTdj', '2de796697c'),
(58, '59ba82034bbcf9.78646584', 'rayssa harbani', 'umirayssa@hotmail.com', 'ie12C0W09rQl4mjtOSSSUPIW5YI4OWM2Yzk4Mzcz', '89c6c98373'),
(59, '59ba8212cd96a9.84887576', 'revi novitasari', 'revinovita@gmail.com', 'GWCvoso5iKoau+vBpw2bXkL9cxQ4ZDM5NmY5MDQ3', '8d396f9047'),
(60, '59ba822df225c2.90529267', 'wage nurmaulina', 'wage@gmail.com', 'FuZNCVta1tXK5jA8DpL3g7Uq7WFkZmZhMGIyNTMy', 'dffa0b2532'),
(61, '59bd4450cf9572.67807708', 'agadi', 'agadisams@gmail.com', 'HLqXNsjOX+fNiZeTSeGHyuo1tmY5ZDY1YzRhMjdh', '9d65c4a27a'),
(62, '59bd4467238930.88847102', 'agis tri wahyuji', 'agistri@gmail.com', 'E6tihplJyIJBS5ssjrirUKv3YNxhNWQ5MDdjMTEy', 'a5d907c112'),
(63, '59bd447a6f8f06.84280346', 'agung prawoso', 'agungpra@gmail.com', 'bAWsB8d5BR548auZzM9cz8f4rUdkNzQ5Zjc2NGJi', 'd749f764bb'),
(64, '59bd4490cba682.71342043', 'anggreini intan', 'aang@gmail.com', 'rTJeY4WXD/2DmBnoDrT8KXyzddI4NTg0Yzg1OTEx', '8584c85911'),
(65, '59bd44a4c716d8.75732641', 'dinda', 'dinda@gmail.com', 'iyNQXQowRtV8+6uECVi3YNasdbVlOTEyYTZhOGY3', 'e912a6a8f7'),
(66, '59bd44af2e58d7.07546538', 'mutiara ruci', 'uci@gmail.com', 'uXc2mE+KfNJGSaGSWEuuCTmUJOEzNmM0OGE0Nzg2', '36c48a4786'),
(67, '59bd44bfe7d960.06162497', 'dzaky hilmi', 'dzakyh@gmail.com', 'SZsWLlhbzeArQ4/rA+sxm9NFQSM0Yzk1YTFhMDY3', '4c95a1a067'),
(68, '59bd4505e78393.46748115', 'dinur ', 'dinur@gmail.com', 'E60P3AhgejJ4hBynjkCqbP/1pLwwNTVkZjFjY2Zl', '055df1ccfe'),
(69, '59bd45138ba106.92126552', 'ihsan prawira', 'ihsan@gmail.com', 'LNEBhxl0XAKbgu2whVp/SS5MWxU1MzdjMzA2ZjU3', '537c306f57'),
(70, '59bd4524c5f5a6.06959746', 'mega sinaga', 'mega@gmail.com', 'nA1T3dvEL/dZg6Io7SXmurnxQtJkZTE1ODE3MjYx', 'de15817261'),
(71, '59bd4540d0c8f3.73914043', 'mokalu irfan', 'mokaluirfan@gmail.com', 'lp+a/aUt9UMzcdr3GVIeLgMi1Wg0MTA4NGM3OTE4', '41084c7918'),
(72, '59bd456599c778.47354206', 'minaldi', 'minaldi@gmail.com', 'MkzFsoDugacnpeVgs21Msc+mW8gzMGIzMDliOGQx', '30b309b8d1'),
(73, '59bd458f05d864.37576091', 'nanda nur septama', 'nandanur@gmail.com', 'j1ZbCIBMJhJPKigKDvOzx8X97Mg1NGUyOGYxMmJi', '54e28f12bb'),
(74, '59bd45a28efea0.39744402', 'dedi munandar', 'nandar@gmail.com', 'ivCw4Oz11MMe1A6n5I20LyU/0WwwYzZkYTg4MTJi', '0c6da8812b'),
(75, '59bd45b66e0c53.41394951', 'putri abi akbarjune', 'putriabi@gmail.com', 'y16iyoZqE3rf0JetFMsVxSgJobNhNzgzMzQ2M2Vl', 'a7833463ee'),
(76, '59bd4602019b18.70921315', 'wili agustian', 'wili@gmail.com', '6ow05thqf2jBIzwCmkD3AWZmdKkxYmMxYjdkNjU1', '1bc1b7d655'),
(77, '59bd462778ba77.67559373', 'muhammad surya', 'surya@gmail.com', 'SCuR1Yq9kE/Xn8m3zzRSacu07VA0ZWNiYjI0MmY3', '4ecbb242f7'),
(78, '59bd463bdd2be4.51670766', 'rizki osb', 'rizkiosb@gmail.com', 'ZAjIyn/XQX8whXt5DNk6QYpCWwBhMWYwNTI4OGYx', 'a1f05288f1'),
(79, '59bd4655bd10f6.70927866', 'monang', 'monang@gmail.com', 'Jd72TNBErSCgwaAK2O1oFO0xg9c1MTUwNWNlMmVl', '51505ce2ee'),
(80, '59bd466e373798.05188934', 'kamal', 'kamal@gmail.com', '/bOiyv0LbZ2kDcsfTFvS5S0BC0JkZDJlYzM5YzJj', 'dd2ec39c2c');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_rating`
--
ALTER TABLE `tbl_rating`
  ADD PRIMARY KEY (`rating_id`);

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
-- AUTO_INCREMENT for table `tbl_rating`
--
ALTER TABLE `tbl_rating`
  MODIFY `rating_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=302;
--
-- AUTO_INCREMENT for table `tbl_review`
--
ALTER TABLE `tbl_review`
  MODIFY `id_review` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=81;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

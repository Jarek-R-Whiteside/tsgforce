CREATE TABLE `balance_text_report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employer` varchar(100) DEFAULT NULL,
  `balance` decimal(10,0) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `homebankingStatus` varchar(100) DEFAULT NULL,
  `mobileBankingStatus` varchar(100) DEFAULT NULL,
  `hasEstatements` varchar(100) DEFAULT NULL,
  `aText` varchar(100) DEFAULT NULL,
  `holdAmount` decimal(10,0) DEFAULT NULL,
  `openDate` datetime DEFAULT NULL,
  `closeDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

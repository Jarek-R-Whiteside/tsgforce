CREATE TABLE `history_text_report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `organization` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `aText` varchar(100) DEFAULT NULL,
  `postingDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

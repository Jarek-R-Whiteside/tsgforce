CREATE TABLE `report_identification` (
  `report_id` int(3) unsigned NOT NULL AUTO_INCREMENT,
  `report_name` varchar(45) DEFAULT NULL,
  `file_type` varchar(200) NOT NULL,
  `header` varchar(4000) NOT NULL,
  `header_row` int(6) NOT NULL,
  `data_row` int(6) NOT NULL,
  PRIMARY KEY (`report_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

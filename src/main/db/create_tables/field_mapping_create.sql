CREATE TABLE `field_mapping` (
  `report_id` int(3) unsigned NOT NULL,
  `field_id` varchar(35) NOT NULL,
  `start_pos` int(4) NOT NULL,
  `end_pos` int(4) NOT NULL,
  `destination` varchar(255) NOT NULL,
  PRIMARY KEY (`report_id`,`field_id`),
  CONSTRAINT `mapping_fk1` FOREIGN KEY (`report_id`) REFERENCES `report_identification` (`report_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

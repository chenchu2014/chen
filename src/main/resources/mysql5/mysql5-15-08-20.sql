USE chinaoil;

DROP TABLE IF EXISTS ade7758_dot;
DROP TABLE IF EXISTS ade7758_continous;
DROP TABLE IF EXISTS inteli_table_dot;
DROP TABLE IF EXISTS inteli_table_continous;

DROP TABLE IF EXISTS dot_data;
DROP TABLE IF EXISTS stream_data;
DROP TABLE IF EXISTS log;

CREATE TABLE ade7758_dot(
  `id` int(10) AUTO_INCREMENT PRIMARY KEY,
  `address` int(10) unsigned NOT NULL,
  `timestramp` varchar(20) NOT NULL DEFAULT '',
  `currenta` int(11) DEFAULT NULL,
  `currentb` int(11) DEFAULT NULL,
  `currentc` int(11) DEFAULT NULL,
  `voltagea` int(11) DEFAULT NULL,
  `voltageb` int(11) DEFAULT NULL,
  `voltagec` int(11) DEFAULT NULL,
  `activePower1` int(11) DEFAULT NULL,
  `activePower2` int(11) DEFAULT NULL,
  `activePower3` int(11) DEFAULT NULL,
  `activePower4` int(11) DEFAULT NULL,
  `reactivePower1` int(11) DEFAULT NULL,
  `reactivePower2` int(11) DEFAULT NULL,
  `reactivePower3` int(11) DEFAULT NULL,
  `reactivePower4` int(11) DEFAULT NULL,
  `apparentPower1` int(11) DEFAULT NULL,
  `apparentPower2` int(11) DEFAULT NULL,
  `apparentPower3` int(11) DEFAULT NULL,
  `apparentPower4` int(11) DEFAULT NULL,
  `powerfactor1` int(11) DEFAULT NULL,
  `powerfactor2` int(11) DEFAULT NULL,
  `powerfactor3` int(11) DEFAULT NULL,
  `powerfactor4` int(11) DEFAULT NULL,
  `positiveActiveEnergy` int(11) DEFAULT NULL,
  `positiveReactiveEnergy` int(11) DEFAULT NULL,
  `reverseActiveEnergy` int(11) DEFAULT NULL,
  `reverseReactiveEnergy` int(11) DEFAULT NULL,
  KEY `dot_time_ind` (`timestramp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE inteli_table_dot(
  `id` int(10) AUTO_INCREMENT PRIMARY KEY,
  `address` int(10) unsigned NOT NULL,
  `timestramp` varchar(20) NOT NULL DEFAULT '',
  `currenta` int(11) DEFAULT NULL,
  `currentb` int(11) DEFAULT NULL,
  `currentc` int(11) DEFAULT NULL,
  `voltagea` int(11) DEFAULT NULL,
  `voltageb` int(11) DEFAULT NULL,
  `voltagec` int(11) DEFAULT NULL,
  `activePower1` int(11) DEFAULT NULL,
  `activePower2` int(11) DEFAULT NULL,
  `activePower3` int(11) DEFAULT NULL,
  `activePower4` int(11) DEFAULT NULL,
  `reactivePower1` int(11) DEFAULT NULL,
  `reactivePower2` int(11) DEFAULT NULL,
  `reactivePower3` int(11) DEFAULT NULL,
  `reactivePower4` int(11) DEFAULT NULL,
  `apparentPower1` int(11) DEFAULT NULL,
  `apparentPower2` int(11) DEFAULT NULL,
  `apparentPower3` int(11) DEFAULT NULL,
  `apparentPower4` int(11) DEFAULT NULL,
  `powerfactor1` int(11) DEFAULT NULL,
  `powerfactor2` int(11) DEFAULT NULL,
  `powerfactor3` int(11) DEFAULT NULL,
  `powerfactor4` int(11) DEFAULT NULL,
  `positiveActiveEnergy` int(11) DEFAULT NULL,
  `positiveReactiveEnergy` int(11) DEFAULT NULL,
  `reverseActiveEnergy` int(11) DEFAULT NULL,
  `reverseReactiveEnergy` int(11) DEFAULT NULL,
  KEY `dot_time_ind` (`timestramp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE ade7758_continous(
  `id` int(10) AUTO_INCREMENT PRIMARY KEY,
  `address` int(10) unsigned NOT NULL,
  `timestramp` varchar(20) NOT NULL DEFAULT '',
  `type` varchar(20) NOT NULL DEFAULT '',
  `data` varchar(4000) DEFAULT NULL,
  KEY `str_time_ind` (`timestramp`),
  KEY `str_type_ind` (`type`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE inteli_table_continous(
  `id` int(10) AUTO_INCREMENT PRIMARY KEY,
  `address` int(10) unsigned NOT NULL,
  `timestramp` varchar(20) NOT NULL DEFAULT '',
  `type` varchar(20) NOT NULL DEFAULT '',
  `data` varchar(4000) DEFAULT NULL,
  KEY `str_time_ind` (`timestramp`),
  KEY `str_type_ind` (`type`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `log` (
  `id` int(10) AUTO_INCREMENT PRIMARY KEY,
  `address` int(10) unsigned NOT NULL,
  `type` varchar(20) NOT NULL DEFAULT '',
  `message` varchar(20) NOT NULL DEFAULT '',
  `timestramp` varchar(20) NOT NULL DEFAULT '',
  KEY `log_msg_ind` (`message`),
  KEY `log_time_ind` (`timestramp`),
  KEY `log_type_ind` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

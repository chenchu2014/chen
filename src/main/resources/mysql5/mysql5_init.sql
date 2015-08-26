CREATE DATABASE chinaoil;

USE chinaoil;

CREATE TABLE log (
  address    INT UNSIGNED NOT NULL,
  type       VARCHAR(20),
  message    VARCHAR(20),
  timestramp VARCHAR(20)
);

ALTER TABLE log ADD INDEX log_msg_ind(message);
ALTER TABLE log ADD INDEX log_time_ind(timestramp);
ALTER TABLE log ADD INDEX log_type_ind(type);
ALTER TABLE log ADD PRIMARY KEY (address, timestramp, type);


CREATE TABLE dot_data (
  address        INT UNSIGNED NOT NULL,
  timestramp     VARCHAR(20),
  currenta       INT,
  currentb       INT,
  currentc       INT,
  voltagea       INT,
  voltageb       INT,
  voltagec       INT,
  activePower1   INT,
  activePower2   INT,
  activePower3   INT,
  activePower4   INT,
  reactivePower1 INT,
  reactivePower2 INT,
  reactivePower3 INT,
  reactivePower4 INT,
  apparentPower1 INT,
  apparentPower2 INT,
  apparentPower3 INT,
  apparentPower4 INT,
  powerfactor1   INT,
  powerfactor2   INT,
  powerfactor3   INT,
  powerfactor4   INT,
  positiveEnergy INT,
  reverseEnergy  INT
);

ALTER TABLE dot_data ADD INDEX dot_time_ind(timestramp);
ALTER TABLE dot_data ADD PRIMARY KEY (address, timestramp);


CREATE TABLE stream_data (
  address    INT UNSIGNED NOT NULL,
  timestramp VARCHAR(20),
  type       VARCHAR(20),
  data       VARCHAR(2000)
);

ALTER TABLE stream_data ADD INDEX str_time_ind(timestramp);
ALTER TABLE stream_data ADD INDEX str_type_ind(type);
ALTER TABLE stream_data ADD PRIMARY KEY (address, timestramp, type);

CREATE TABLE my_user (
  username VARCHAR(20) PRIMARY KEY,
  password VARCHAR(50),
  role     VARCHAR(20)
);

INSERT INTO my_user VALUES ('admin', '21232f297a57a5a743894a0e4a801fc3', 'ROLE_ADMIN');

CREATE TABLE address_info (
  address   INT UNSIGNED PRIMARY KEY,
  version   VARCHAR(10),
  last_time VARCHAR(20)
);

ALTER TABLE address_info ADD INDEX add_ver_ind(version);
ALTER TABLE address_info ADD INDEX add_last_ind(last_time);

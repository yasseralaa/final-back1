CREATE TABLE hibernate_sequence (
  next_val bigint(20) DEFAULT NULL
)   ;

--
-- Dumping data for table  hibernate_sequence 
--

INSERT INTO hibernate_sequence ( next_val ) VALUES
  (1),
  (1),
  (1),
  (1);

-- --------------------------------------------------------

--
-- Table structure for table  predefined_notes 
--

CREATE TABLE predefined_notes (
   id  int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
   maximum_temperature  int(11) DEFAULT NULL,
   message  varchar(255) DEFAULT NULL,
   minimum_temprature  int(11) DEFAULT NULL
);

--
-- Dumping data for table  predefined_notes 
--

INSERT INTO  predefined_notes  ( id ,  maximum_temperature ,  message ,  minimum_temprature ) VALUES
  (1, 10, '', 1),
  (2, 20, '', 11),
  (3, 30, '', 21),
  (4, 100000, '', 31);

-- --------------------------------------------------------

--
-- Table structure for table  role 
--

CREATE TABLE  role  (
   id  int(11) NOT NULL  PRIMARY KEY AUTO_INCREMENT,
   role  varchar(255) DEFAULT NULL
)   ;

--
-- Dumping data for table  role 
--

INSERT INTO  role  ( id ,  role ) VALUES
  (1, 'ROLE_ADMIN'),
  (2, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table  user 
--

CREATE TABLE  user  (
   id  int(11) NOT NULL  PRIMARY KEY AUTO_INCREMENT,
   email  varchar(255) DEFAULT NULL,
   mobile_number  varchar(255) DEFAULT NULL,
   name  varchar(255) DEFAULT NULL,
   password  varchar(255) DEFAULT NULL,
   role_id  int(11) DEFAULT NULL
)   ;

--
-- Dumping data for table  user 
--

INSERT INTO  user  ( id ,  email ,  mobile_number ,  name ,  password ,  role_id ) VALUES
  (1, 'admin@admin.com', '01122334455', 'admin', 'admin', 1),
  (2, 'user@user.com', '01425366543', 'user', 'user', 2),
  (3, 'abcd', '01155887744', 'abc', 'abc', 1),
  (4, 'abcder', '01155887744', 'zzzzzzzzzzzzzz', 'zzzzzzzzzzzzzz', 2);

-- --------------------------------------------------------

--
-- Table structure for table  weather_note 
--

CREATE TABLE  weather_note  (
   id  int(11) NOT NULL  PRIMARY KEY AUTO_INCREMENT,
   date  date DEFAULT NULL,
   note  varchar(255) DEFAULT NULL,
   user_id  int(11) DEFAULT NULL
)   ;

--
-- Dumping data for table  weather_note 
--

INSERT INTO  weather_note  ( id ,  date ,  note ,  user_id ) VALUES
  (1, '2017-09-05', 'note note its note', 1),
  (3, '2017-09-24', 'Nooooooooooooooooooooooooooooooooooooooooooooooooote', 1),
  (4, '2017-09-25', 'new note', 1);

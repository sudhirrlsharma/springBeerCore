## Execute each query one by one

CREATE TABLE `beer` (
  `id` bigint(20) Primary Key auto_increment,
  `brand` text,
  `price` decimal(11,2) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `users`(
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`username`)
 ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 
 CREATE TABLE `user_roles` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY uni_username_role (`role`,`username`),
  KEY fk_username_idx (`username`),
  CONSTRAINT fk_username FOREIGN KEY (`username`) REFERENCES users (`username`)
 )ENGINE=InnoDB DEFAULT CHARSET=latin1;
 
 
INSERT INTO users(username,password,enabled) VALUES ('sudhir','sharma', true);
INSERT INTO users(username,password,enabled) VALUES ('cybage','gandhinagar', true);


INSERT INTO user_roles (username, role) VALUES ('sudhir', 'ROLE_USER');
INSERT INTO user_roles (username, role) VALUES ('sudhir', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role) VALUES ('cybage', 'ROLE_USER');
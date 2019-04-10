-- PLEASE DO NOT EDIT THIS CODE
-- This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!

CREATE DATABASE IF NOT EXISTS `expo`;
USE `expo`;

CREATE TABLE IF NOT EXISTS `expo`.`exhibition`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*exhibition Associations*/
  vote_weight INT,
  
  /*exhibition Attributes*/
  id VARCHAR(255),
  name VARCHAR(255),
  description VARCHAR(255),
  UNKNOWN ID: attributeMany List<BLOB>,
  UNKNOWN ID: attributeMany List<VARCHAR(255)>,
  PRIMARY KEY(id)

);



CREATE DATABASE IF NOT EXISTS `expo`;
USE `expo`;

CREATE TABLE IF NOT EXISTS `expo`.`user`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*user Associations*/
  vote_weight INT,
  
  /*user Attributes*/
  id VARCHAR(255),
  name VARCHAR(255),
  type VARCHAR(255),
  PRIMARY KEY(id)

);



CREATE DATABASE IF NOT EXISTS `expo`;
USE `expo`;

CREATE TABLE IF NOT EXISTS `expo`.`vote`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*vote Associations*/
  user_id VARCHAR(255),
  exhibition_id VARCHAR(255),
  
  /*vote Attributes*/
  weight INT,
  PRIMARY KEY(weight)

);


ALTER TABLE `expo`.`exhibition` ADD CONSTRAINT `fk_exhibition_vote_weight` FOREIGN KEY (`vote_weight`) REFERENCES `expo`.`vote`(`weight`);

ALTER TABLE `expo`.`user` ADD CONSTRAINT `fk_user_vote_weight` FOREIGN KEY (`vote_weight`) REFERENCES `expo`.`vote`(`weight`);

ALTER TABLE `expo`.`vote` ADD CONSTRAINT `fk_vote_user_id` FOREIGN KEY (`user_id`) REFERENCES `expo`.`user`(`id`);
ALTER TABLE `expo`.`vote` ADD CONSTRAINT `fk_vote_exhibition_id` FOREIGN KEY (`exhibition_id`) REFERENCES `expo`.`exhibition`(`id`);

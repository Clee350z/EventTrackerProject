-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema musicfestivaldb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `musicfestivaldb` ;

-- -----------------------------------------------------
-- Schema musicfestivaldb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `musicfestivaldb` DEFAULT CHARACTER SET utf8 ;
USE `musicfestivaldb` ;

-- -----------------------------------------------------
-- Table `festival`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `festival` ;

CREATE TABLE IF NOT EXISTS `festival` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `date` DATETIME NULL,
  `handicap_access` TINYINT NULL,
  `venue` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS musicfestivaluser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'musicfestivaluser'@'localhost' IDENTIFIED BY 'musicfestivaluser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'musicfestivaluser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `festival`
-- -----------------------------------------------------
START TRANSACTION;
USE `musicfestivaldb`;
INSERT INTO `festival` (`id`, `name`, `date`, `handicap_access`, `venue`) VALUES (1, 'Global Dance', '2022-7-23', 1, 'Mile High Stadium');
INSERT INTO `festival` (`id`, `name`, `date`, `handicap_access`, `venue`) VALUES (2, 'Global Dub', '2022-5-21', 0, 'Red Rocks Ampitheater');
INSERT INTO `festival` (`id`, `name`, `date`, `handicap_access`, `venue`) VALUES (3, 'Ultra Music ', '2022-3-25', 1, 'Bayfront Park');
INSERT INTO `festival` (`id`, `name`, `date`, `handicap_access`, `venue`) VALUES (4, 'Electonic Daisy Carnival', '2022-5-20', 1, 'Las Vegas Motor Speedway');
INSERT INTO `festival` (`id`, `name`, `date`, `handicap_access`, `venue`) VALUES (5, 'Foam Wonderland', '2022-5-20', 1, 'Western Complex');
INSERT INTO `festival` (`id`, `name`, `date`, `handicap_access`, `venue`) VALUES (6, 'Decadence', '2022-12-30', 1, 'Colorado Convention Center');
INSERT INTO `festival` (`id`, `name`, `date`, `handicap_access`, `venue`) VALUES (7, 'Global Dance Ater Party', '2022-7-24', 1, 'The Church Nightclub');

COMMIT;


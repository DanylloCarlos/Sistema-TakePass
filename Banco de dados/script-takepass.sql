-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema bdEventos
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bdEventos` ;

-- -----------------------------------------------------
-- Schema bdEventos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bdEventos` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `bdEventos` ;

-- -----------------------------------------------------
-- Table `bdEventos`.`ingresso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdEventos`.`ingresso` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `bdEventos`.`ingresso` (
  `idIngresso` INT NOT NULL AUTO_INCREMENT,
  `codigoDoEvento` VARCHAR(50) NULL,
  `nomeEvento` VARCHAR(45) NULL,
  PRIMARY KEY (`idIngresso`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `bdEventos`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdEventos`.`cliente` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `bdEventos`.`cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `nomeCliente` VARCHAR(50) NULL,
  `cpf` VARCHAR(45) NULL,
  `ingresso_idIngresso` INT NOT NULL,
  PRIMARY KEY (`idCliente`, `ingresso_idIngresso`),
  CONSTRAINT `fk_cliente_ingresso`
    FOREIGN KEY (`ingresso_idIngresso`)
    REFERENCES `bdEventos`.`ingresso` (`idIngresso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_cliente_ingresso_idx` ON `bdEventos`.`cliente` (`ingresso_idIngresso` ASC);

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

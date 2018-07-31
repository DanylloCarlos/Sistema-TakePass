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
-- Table `bdEventos`.`Eventos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdEventos`.`Eventos` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `bdEventos`.`Eventos` (
  `idEvento` INT NOT NULL AUTO_INCREMENT,
  `nomeEvento` VARCHAR(45) NULL,
  `qtdIngressos` INT NOT NULL,
  PRIMARY KEY (`idEvento`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `bdEventos`.`Clientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdEventos`.`Clientes` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `bdEventos`.`Clientes` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `nomeCliente` VARCHAR(50) NULL,
  `cpf` VARCHAR(45) NULL,
  `Eventos_idEvento` INT NOT NULL,
  PRIMARY KEY (`idCliente`),
  CONSTRAINT `fk_Clientes_Eventos`
    FOREIGN KEY (`Eventos_idEvento`)
    REFERENCES `bdEventos`.`Eventos` (`idEvento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_Clientes_Eventos_idx` ON `bdEventos`.`Clientes` (`Eventos_idEvento` ASC);

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

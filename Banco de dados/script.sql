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
-- Table `bdEventos`.`Clientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdEventos`.`Clientes` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `bdEventos`.`Clientes` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `nomeCliente` VARCHAR(50) NULL,
  `cpf` VARCHAR(45) NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `bdEventos`.`Ingressos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdEventos`.`Ingressos` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `bdEventos`.`Ingressos` (
  `idIngresso` INT NOT NULL AUTO_INCREMENT,
  `qtdDisp` INT NULL,
  `descricao` VARCHAR(100) NULL,
  PRIMARY KEY (`idIngresso`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `bdEventos`.`Eventos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdEventos`.`Eventos` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `bdEventos`.`Eventos` (
  `idEvento` INT NOT NULL AUTO_INCREMENT,
  `nomeEvento` VARCHAR(45) NULL,
  `Clientes_idCliente` INT NOT NULL,
  `Ingressos_idIngresso` INT NOT NULL,
  PRIMARY KEY (`idEvento`),
  CONSTRAINT `fk_Evento_Clientes`
    FOREIGN KEY (`Clientes_idCliente`)
    REFERENCES `bdEventos`.`Clientes` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Evento_Ingressos1`
    FOREIGN KEY (`Ingressos_idIngresso`)
    REFERENCES `bdEventos`.`Ingressos` (`idIngresso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_Evento_Clientes_idx` ON `bdEventos`.`Eventos` (`Clientes_idCliente` ASC);

SHOW WARNINGS;
CREATE INDEX `fk_Evento_Ingressos1_idx` ON `bdEventos`.`Eventos` (`Ingressos_idIngresso` ASC);

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

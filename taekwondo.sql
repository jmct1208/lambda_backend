-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema taekwondo
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema taekwondo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `taekwondo` ;
USE `taekwondo` ;

-- -----------------------------------------------------
-- Table `taekwondo`.`administrador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `taekwondo`.`administrador` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre_usuario` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `taekwondo`.`alumno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `taekwondo`.`alumno` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre_usuario` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `fecha_nacimiento` DATE NOT NULL,
  `fotografia` VARCHAR(45) NOT NULL,
  `actividad_marcial` VARCHAR(45) NOT NULL,
  `grado_actividad_marcial` VARCHAR(45) NOT NULL,
  `seguro_medico` VARCHAR(45) NOT NULL,
  `certificado_medico` VARCHAR(45) NOT NULL,
  `carta_responsiva` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `taekwondo`.`examen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `taekwondo`.`examen` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `fecha_hora` DATETIME NOT NULL,
  `costo` DECIMAL(7,2) NOT NULL,
  `enlace_facebook` VARCHAR(45) NOT NULL,
  `solicitud_examen` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `taekwondo`.`evento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `taekwondo`.`evento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `tipo_evento` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `fecha_inicio` DATETIME NOT NULL,
  `fecha_fin` DATETIME NOT NULL,
  `costo` DECIMAL(7,2) NOT NULL,
  `enlace_facebook` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `taekwondo`.`alumno_has_examen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `taekwondo`.`alumno_has_examen` (
  `alumno_id` INT NOT NULL,
  `examen_id` INT NOT NULL,
  PRIMARY KEY (`alumno_id`, `examen_id`),
  INDEX `fk_alumno_has_examen_examen1_idx` (`examen_id` ASC) VISIBLE,
  INDEX `fk_alumno_has_examen_alumno_idx` (`alumno_id` ASC) VISIBLE,
  CONSTRAINT `fk_alumno_has_examen_alumno`
    FOREIGN KEY (`alumno_id`)
    REFERENCES `taekwondo`.`alumno` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_alumno_has_examen_examen1`
    FOREIGN KEY (`examen_id`)
    REFERENCES `taekwondo`.`examen` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `taekwondo`.`alumno_has_evento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `taekwondo`.`alumno_has_evento` (
  `alumno_id` INT NOT NULL,
  `Evento_id` INT NOT NULL,
  PRIMARY KEY (`alumno_id`, `Evento_id`),
  INDEX `fk_alumno_has_Evento_Evento1_idx` (`Evento_id` ASC) VISIBLE,
  INDEX `fk_alumno_has_Evento_alumno1_idx` (`alumno_id` ASC) VISIBLE,
  CONSTRAINT `fk_alumno_has_Evento_alumno1`
    FOREIGN KEY (`alumno_id`)
    REFERENCES `taekwondo`.`alumno` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_alumno_has_Evento_Evento1`
    FOREIGN KEY (`Evento_id`)
    REFERENCES `taekwondo`.`evento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

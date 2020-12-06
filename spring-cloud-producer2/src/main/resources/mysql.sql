CREATE DATABASE `db01`;
USE  `db01`

DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept` (
    `deptno` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `dname` VARCHAR(60) DEFAULT NULL,
    `db_source` VARCHAR(60) DEFAULT NULL,
    PRIMARY KEY (`deptno`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `dept` (dname, db_source) VALUES ('开发部', database());
INSERT INTO `dept` (dname, db_source) VALUES ('人事部', database());
INSERT INTO `dept` (dname, db_source) VALUES ('财务部', database());
INSERT INTO `dept` (dname, db_source) VALUES ('市场部', database());
INSERT INTO `dept` (dname, db_source) VALUES ('运维部', database());
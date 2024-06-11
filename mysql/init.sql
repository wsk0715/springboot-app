-- 0.CREATE DB/USER
DROP DATABASE IF EXISTS central;

CREATE DATABASE central;

DROP USER IF EXISTS 'central'@'%';

CREATE USER 'central'@'%' IDENTIFIED BY '1234';

GRANT ALL PRIVILEGES ON central.* TO 'central'@'%';

FLUSH PRIVILEGES;


-- 1.CREATE TABLE
USE central;

CREATE TABLE tb_member
(
    m_id    VARCHAR(20) NOT NULL,
    m_pw    VARCHAR(100),
    m_name  VARCHAR(10),
    m_email VARCHAR(20),
    PRIMARY KEY (m_id)
);


-- 2. INSERT DATA
INSERT IGNORE INTO tb_member (m_id, m_pw, m_name, m_email)
VALUES ('admin', 'admin', '관리자', 'admin@localhost'),
       ('id001', 'pw001', '홍01', '홍01@localhost'),
       ('id002', 'pw002', '홍02', '홍02@localhost'),
       ('id003', 'pw003', '홍03', '홍03@localhost');

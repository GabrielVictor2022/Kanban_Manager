--liquidbase formatted sql
--changeset gabriel:202503250329
--comment: boards table create

CREATE TABLE BOARDS (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,  
) ENGINE=InnoDB;

--rollback DROP TABLE BOARDS;
CREATE SEQUENCE IF NOT EXISTS secuencia_usuario START WITH 1 INCREMENT BY 1;

CREATE TABLE usuario
(
    identificacion BIGINT NOT NULL,
    nombre         VARCHAR(255),
    CONSTRAINT pk_usuario PRIMARY KEY (identificacion)
);

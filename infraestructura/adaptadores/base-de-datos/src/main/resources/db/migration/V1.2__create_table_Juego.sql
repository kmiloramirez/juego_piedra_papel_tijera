CREATE SEQUENCE IF NOT EXISTS secuencia_juego START WITH 1 INCREMENT BY 1;

CREATE TABLE juego
(
    numero_juego            INTEGER NOT NULL,
    jugador1_identificacion BIGINT,
    jugador2_identificacion BIGINT,
    modalidad_juego         VARCHAR(255),
    ganador                 VARCHAR(255),
    CONSTRAINT pk_juego PRIMARY KEY (numero_juego)
);

ALTER TABLE juego
    ADD CONSTRAINT FK_JUEGO_ON_JUGADOR1_IDENTIFICACION FOREIGN KEY (jugador1_identificacion) REFERENCES usuario (identificacion);

ALTER TABLE juego
    ADD CONSTRAINT FK_JUEGO_ON_JUGADOR2_IDENTIFICACION FOREIGN KEY (jugador2_identificacion) REFERENCES usuario (identificacion);

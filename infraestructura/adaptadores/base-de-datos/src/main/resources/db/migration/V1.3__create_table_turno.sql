CREATE SEQUENCE IF NOT EXISTS secuencia_turno START WITH 1 INCREMENT BY 1;

CREATE TABLE turno
(
    id            BIGINT NOT NULL,
    mano_jugador1 VARCHAR(255),
    mano_jugador2 VARCHAR(255),
    ganador       VARCHAR(255),
    turno_numero  INTEGER,
    juego_id      INTEGER,
    CONSTRAINT pk_turno PRIMARY KEY (id)
);

ALTER TABLE turno
    ADD CONSTRAINT FK_TURNO_ON_JUEGO FOREIGN KEY (juego_id) REFERENCES juego (numero_juego);

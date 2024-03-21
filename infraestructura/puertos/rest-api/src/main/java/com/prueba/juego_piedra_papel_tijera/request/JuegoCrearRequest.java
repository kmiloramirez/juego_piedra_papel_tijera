package com.prueba.juego_piedra_papel_tijera.request;

import com.prueba.juego_piedra_papel_tijera.entidad.enums.ModalidadJuego;

public record JuegoCrearRequest(
        ModalidadJuego modalidadJuego
) {
}

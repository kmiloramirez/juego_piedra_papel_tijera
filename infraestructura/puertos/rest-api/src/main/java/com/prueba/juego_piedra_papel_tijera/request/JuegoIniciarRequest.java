package com.prueba.juego_piedra_papel_tijera.request;


public record JuegoIniciarRequest(
        Integer identificacionJugador1,
        Integer identificacionJugador2
) {
}

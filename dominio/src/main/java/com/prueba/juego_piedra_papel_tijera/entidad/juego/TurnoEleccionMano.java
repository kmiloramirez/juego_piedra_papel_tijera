package com.prueba.juego_piedra_papel_tijera.entidad.juego;

import com.prueba.juego_piedra_papel_tijera.entidad.enums.EleccionesDeJuego;

public record TurnoEleccionMano(
        Integer numeroJuego,
        Integer identificacionJugador,
        EleccionesDeJuego eleccionesDeJuego
) {
}

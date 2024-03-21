package com.prueba.juego_piedra_papel_tijera.dto;

import com.prueba.juego_piedra_papel_tijera.entidad.enums.EleccionesDeJuego;
import com.prueba.juego_piedra_papel_tijera.entidad.enums.Ganador;

public record TurnoDto(
        EleccionesDeJuego manoJugador1,
        EleccionesDeJuego manoJugador2,
        Ganador ganador,
        Integer turnoNumero
) {
}

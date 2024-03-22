package com.prueba.juego_piedra_papel_tijera.dto;

import com.prueba.juego_piedra_papel_tijera.entidad.enums.Ganador;
import com.prueba.juego_piedra_papel_tijera.entidad.enums.ModalidadJuego;

import java.util.List;

public record JuegoDto(
        Integer numeroJuego,
        UsuarioDto jugador1,
        UsuarioDto jugador2,
        ModalidadJuego modalidadJuego,
        List<TurnoDto> turnos,
        Ganador ganador
) {
}

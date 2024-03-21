package com.prueba.juego_piedra_papel_tijera.entidad.juego;

import com.prueba.juego_piedra_papel_tijera.entidad.enums.ModalidadJuego;
import com.prueba.juego_piedra_papel_tijera.entidad.usuario.Usuario;

import java.util.List;

public record JuegoCrear(
        ModalidadJuego modalidadJuego
) {
}

package com.prueba.juego_piedra_papel_tijera.entidad.juego;

import com.prueba.juego_piedra_papel_tijera.entidad.enums.ModalidadJuego;

public record JuegoIniciar(
        Integer numeroJuego,
        Integer identificacionJugador1,
        Integer identificacionJugador2,
        ModalidadJuego modalidadJuego
) {

    public JuegoIniciar agregarModoDeJuego(ModalidadJuego modalidadJuego){
        return new JuegoIniciar(this.numeroJuego(),this.identificacionJugador1(),this.identificacionJugador2(),modalidadJuego);
    }
}

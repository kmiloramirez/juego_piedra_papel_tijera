package com.prueba.juego_piedra_papel_tijera.regla.juego;

import com.prueba.juego_piedra_papel_tijera.anotacion.ReglaDeNegocio;
import com.prueba.juego_piedra_papel_tijera.entidad.enums.ModalidadJuego;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.JuegoIniciar;
import com.prueba.juego_piedra_papel_tijera.error.UsuarioError;
import com.prueba.juego_piedra_papel_tijera.regla.Regla;
import com.prueba.juego_piedra_papel_tijera.regla.usuario.UsuarioExistenteIdRegla;

@ReglaDeNegocio
public class ValidarIniciarJuegoJugadores implements Regla<JuegoIniciar> {
    private UsuarioExistenteIdRegla usuarioExistenteIdRegla;

    public ValidarIniciarJuegoJugadores(UsuarioExistenteIdRegla usuarioExistenteIdRegla) {
        this.usuarioExistenteIdRegla = usuarioExistenteIdRegla;
    }

    @Override
    public void validar(JuegoIniciar juego) {
        UsuarioError error;
        if (ModalidadJuego.UN_JUGADOR == juego.modalidadJuego()
                && null == juego.identificacionJugador1()) {
            error = new UsuarioError(
                    "En esta modalidad de juego de una sola parsona contra la maquina debria haber al menos un jugador");
            error.log();
            throw error;

        }
        if (ModalidadJuego.DOS_JUGADORES == juego.modalidadJuego()) {
            if (null == juego.identificacionJugador1() || null == juego.identificacionJugador2()) {
                error = new UsuarioError(
                        "En esta modalidad de juego de dos parsonas debria estar los dos jugadores");
                error.log();
                throw error;
            }
            usuarioExistenteIdRegla.validar(juego.identificacionJugador2());
        }
        usuarioExistenteIdRegla.validar(juego.identificacionJugador1());

    }
}

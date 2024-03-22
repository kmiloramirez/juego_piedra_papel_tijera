package com.prueba.juego_piedra_papel_tijera.regla.juego;

import com.prueba.juego_piedra_papel_tijera.adaptador.repositorio.juego.JuegoRepositorio;
import com.prueba.juego_piedra_papel_tijera.anotacion.ReglaDeNegocio;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.Juego;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.JuegoIniciar;
import com.prueba.juego_piedra_papel_tijera.error.UsuarioError;
import com.prueba.juego_piedra_papel_tijera.regla.Regla;

@ReglaDeNegocio
public class ValidarJuegoIniciado implements Regla<JuegoIniciar> {
    private JuegoRepositorio juegoRepositorio;

    public ValidarJuegoIniciado(JuegoRepositorio juegoRepositorio) {
        this.juegoRepositorio = juegoRepositorio;
    }

    @Override
    public void validar(JuegoIniciar juegoIniciar) {
        UsuarioError error;
        Juego juego = juegoRepositorio.buscarJuegoPorNumero(juegoIniciar.numeroJuego()).get();
        if (!juego.turnos().isEmpty()) {
            error = new UsuarioError(
                    "EL juego con el numero: " + juegoIniciar.numeroJuego() + " ya fue iniciado");
            error.log();
            throw error;
        }
    }
}


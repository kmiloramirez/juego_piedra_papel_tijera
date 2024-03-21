package com.prueba.juego_piedra_papel_tijera.regla.juego;

import com.prueba.juego_piedra_papel_tijera.adaptador.repositorio.juego.JuegoRepositorio;
import com.prueba.juego_piedra_papel_tijera.anotacion.ReglaDeNegocio;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.Juego;
import com.prueba.juego_piedra_papel_tijera.error.UsuarioError;
import com.prueba.juego_piedra_papel_tijera.regla.Regla;

import java.util.Optional;

@ReglaDeNegocio
public class ValidarJuegoExistente implements Regla<Integer> {
    private JuegoRepositorio juegoRepositorio;

    public ValidarJuegoExistente(JuegoRepositorio juegoRepositorio) {
        this.juegoRepositorio = juegoRepositorio;
    }

    @Override
    public void validar(Integer integer) {
        UsuarioError error;
        Optional<Juego> juegoBuscado = juegoRepositorio.buscarJuegoPorNumero(integer);
        if (juegoBuscado.isEmpty()) {
            error = new UsuarioError("EL juego con el numero: " + integer + "no existe");
            error.log();
            throw error;
        }
    }
}

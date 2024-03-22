package com.prueba.juego_piedra_papel_tijera.casodeuso.juego;

import com.prueba.juego_piedra_papel_tijera.adaptador.repositorio.juego.JuegoRepositorio;
import com.prueba.juego_piedra_papel_tijera.anotacion.CasoDeUso;
import com.prueba.juego_piedra_papel_tijera.casodeuso.CasoDeUsoBase;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.Juego;
import com.prueba.juego_piedra_papel_tijera.regla.juego.ValidarJuegoExistente;

@CasoDeUso
public class BuscarJuegoCasoDeuso implements CasoDeUsoBase<Integer, Juego> {

    private JuegoRepositorio juegoRepositorio;
    private ValidarJuegoExistente validarExisteJuego;


    public BuscarJuegoCasoDeuso(JuegoRepositorio juegoRepositorio,
                                ValidarJuegoExistente validarExisteJuego
                               ) {
        this.juegoRepositorio = juegoRepositorio;
        this.validarExisteJuego = validarExisteJuego;
    }

    @Override
    public Juego ejecutar(Integer numeroJuego) {
        validarExisteJuego.validar(numeroJuego);
        return juegoRepositorio.buscarJuego(numeroJuego);
    }
}

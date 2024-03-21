package com.prueba.juego_piedra_papel_tijera.casodeuso.juego;

import com.prueba.juego_piedra_papel_tijera.adaptador.repositorio.juego.JuegoRepositorio;
import com.prueba.juego_piedra_papel_tijera.anotacion.CasoDeUso;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.Juego;

import java.util.List;

@CasoDeUso
public class BuscarJuegosCasoDeuso {

    private JuegoRepositorio juegoRepositorio;

    public BuscarJuegosCasoDeuso(JuegoRepositorio juegoRepositorio) {
        this.juegoRepositorio = juegoRepositorio;
    }

    public List<Juego> ejecutar(){
        return juegoRepositorio.buscarTodosLosJuegos();
    }

}

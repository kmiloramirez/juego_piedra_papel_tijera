package com.prueba.juego_piedra_papel_tijera.casodeuso.juego;

import com.prueba.juego_piedra_papel_tijera.adaptador.repositorio.juego.JuegoRepositorio;
import com.prueba.juego_piedra_papel_tijera.anotacion.CasoDeUso;
import com.prueba.juego_piedra_papel_tijera.casodeuso.CasoDeUsoBase;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.Juego;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.JuegoCrear;
import com.prueba.juego_piedra_papel_tijera.regla.Regla;
import com.prueba.juego_piedra_papel_tijera.regla.juego.ValidarCrearJuego;

import java.util.ArrayList;
import java.util.List;

@CasoDeUso
public class CrearJuegoCasoDeUso implements CasoDeUsoBase<JuegoCrear, Juego> {

    private List<Regla<JuegoCrear>> validaciones;
    private JuegoRepositorio juegoRepositorio;

    public CrearJuegoCasoDeUso(JuegoRepositorio juegoRepositorio,
                               ValidarCrearJuego validarCrearJuego) {
        this.juegoRepositorio = juegoRepositorio;
        this.validaciones = new ArrayList<>();
        this.validaciones.add(validarCrearJuego);
    }

    @Override
    public Juego ejecutar(JuegoCrear juegoCrear) {
        validarJuego(juegoCrear);
        return juegoRepositorio.guardarJuego(juegoCrear);
    }

    private void validarJuego(JuegoCrear juego) {
        validaciones.forEach(validacion -> validacion.validar(juego));

    }
}

package com.prueba.juego_piedra_papel_tijera.casodeuso.juego;

import com.prueba.juego_piedra_papel_tijera.adaptador.repositorio.juego.JuegoRepositorio;
import com.prueba.juego_piedra_papel_tijera.anotacion.CasoDeUso;
import com.prueba.juego_piedra_papel_tijera.casodeuso.CasoDeUsoBase;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.Juego;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.JuegoIniciar;
import com.prueba.juego_piedra_papel_tijera.regla.Regla;
import com.prueba.juego_piedra_papel_tijera.regla.juego.ValidarIniciarJuegoJugadores;
import com.prueba.juego_piedra_papel_tijera.regla.juego.ValidarJuegoExistente;
import com.prueba.juego_piedra_papel_tijera.regla.juego.ValidarJuegoIniciado;

import java.util.ArrayList;
import java.util.List;

@CasoDeUso
public class IniciarJuegoCasoDeUso implements CasoDeUsoBase<JuegoIniciar, Juego> {
    private List<Regla<JuegoIniciar>> validacionesIniciar;
    private List<Regla<Integer>> validacionesExistencia;
    private JuegoRepositorio juegoRepositorio;

    public IniciarJuegoCasoDeUso(JuegoRepositorio juegoRepositorio,
                                 ValidarJuegoExistente validarExisteJuego,
                                 ValidarIniciarJuegoJugadores validarIniciarJuegoJugadores,
                                 ValidarJuegoIniciado validarJuegoIniciado) {
        this.juegoRepositorio = juegoRepositorio;
        this.validacionesExistencia = new ArrayList<>();
        this.validacionesExistencia.add(validarExisteJuego);
        this.validacionesIniciar = new ArrayList<>();
        this.validacionesIniciar.add(validarIniciarJuegoJugadores);
        this.validacionesIniciar.add(validarJuegoIniciado);

    }

    @Override
    public Juego ejecutar(JuegoIniciar juegoIniciar) {
        existeJuego(juegoIniciar);
        Juego juego = juegoRepositorio.buscarJuegoPorNumero(juegoIniciar.numeroJuego()).get();
        juegoIniciar = juegoIniciar.agregarModoDeJuego(juego.modalidadJuego());
        validarIniciarJuego(juegoIniciar);
        return juegoRepositorio.iniciarJuego(juegoIniciar);
    }

    private void existeJuego(JuegoIniciar juegoIniciar) {
        validacionesExistencia.forEach(
                validacion -> validacion.validar(juegoIniciar.numeroJuego()));
    }

    private void validarIniciarJuego(JuegoIniciar juego) {
        validacionesIniciar.forEach(validacion -> validacion.validar(juego));
    }
}

package com.prueba.juego_piedra_papel_tijera.casodeuso.juego;

import com.prueba.juego_piedra_papel_tijera.adaptador.repositorio.juego.JuegoRepositorio;
import com.prueba.juego_piedra_papel_tijera.adaptador.repositorio.turno.TurnoRepositorio;
import com.prueba.juego_piedra_papel_tijera.anotacion.CasoDeUso;
import com.prueba.juego_piedra_papel_tijera.casodeuso.CasoDeUsoBase;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.Juego;
import com.prueba.juego_piedra_papel_tijera.regla.Regla;
import com.prueba.juego_piedra_papel_tijera.regla.juego.ValidarJuegoExistente;

import java.util.ArrayList;
import java.util.List;

@CasoDeUso
public class ReiniciarJuegoCasoDeUso implements CasoDeUsoBase<Integer, Juego> {
    private JuegoRepositorio juegoRepositorio;
    private TurnoRepositorio turnoRepositorio;
    private List<Regla<Integer>> validacionesExistencia;


    public ReiniciarJuegoCasoDeUso(JuegoRepositorio juegoRepositorio,
                                   TurnoRepositorio turnoRepositorio,
                                   ValidarJuegoExistente validarExisteJuego
                                  ) {
        this.juegoRepositorio = juegoRepositorio;
        this.turnoRepositorio = turnoRepositorio;
        this.validacionesExistencia = new ArrayList<>();
        this.validacionesExistencia.add(validarExisteJuego);
    }


    @Override
    public Juego ejecutar(Integer numeroJuego) {
        existeJuego(numeroJuego);
        Juego juego = cargarJuego(numeroJuego);
        juego.turnos().forEach(turno -> {
            turnoRepositorio.borrarTurno(turno, numeroJuego);
        });
        juego = juegoRepositorio.actualizarJuego(juego.eliminarTurnos().eliminarGanador());
        juegoRepositorio.crearNuevoTurno(juego, 1);
        return cargarJuego(numeroJuego);

    }

    private void existeJuego(Integer numeroJuego) {
        validacionesExistencia.forEach(validacion -> validacion.validar(numeroJuego));
    }

    private Juego cargarJuego(Integer numeroJuego) {
        return juegoRepositorio.buscarJuegoPorNumero(numeroJuego).get();
    }
}

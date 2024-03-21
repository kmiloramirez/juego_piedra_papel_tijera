package com.prueba.juego_piedra_papel_tijera.casodeuso.juego;

import com.prueba.juego_piedra_papel_tijera.adaptador.repositorio.juego.JuegoRepositorio;
import com.prueba.juego_piedra_papel_tijera.adaptador.repositorio.turno.TurnoRepositorio;
import com.prueba.juego_piedra_papel_tijera.anotacion.CasoDeUso;
import com.prueba.juego_piedra_papel_tijera.casodeuso.CasoDeUsoBase;
import com.prueba.juego_piedra_papel_tijera.entidad.enums.EleccionesDeJuego;
import com.prueba.juego_piedra_papel_tijera.entidad.enums.ModalidadJuego;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.Juego;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.Turno;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.TurnoEleccionMano;
import com.prueba.juego_piedra_papel_tijera.entidad.usuario.Usuario;
import com.prueba.juego_piedra_papel_tijera.error.UsuarioError;
import com.prueba.juego_piedra_papel_tijera.regla.Regla;
import com.prueba.juego_piedra_papel_tijera.regla.juego.ValidarJuegoExistente;
import com.prueba.juego_piedra_papel_tijera.regla.juego.ValidarJuegoTerminado;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

@CasoDeUso
public class MovimeintoDeJuegoCasoDeUso implements CasoDeUsoBase<TurnoEleccionMano, Juego> {
    private List<Regla<Integer>> validacionesExistencia;
    private JuegoRepositorio juegoRepositorio;
    private TurnoRepositorio turnoRepositorio;
    private ValidarJuegoTerminado validarJuegoTerminado;

    public MovimeintoDeJuegoCasoDeUso(ValidarJuegoExistente validarExisteJuego,
                                      ValidarJuegoTerminado validarJuegoTerminado,
                                      JuegoRepositorio juegoRepositorio,
                                      TurnoRepositorio turnoRepositorio) {
        this.validacionesExistencia = new ArrayList<>();
        this.validacionesExistencia.add(validarExisteJuego);
        this.juegoRepositorio = juegoRepositorio;
        this.turnoRepositorio = turnoRepositorio;
        this.validarJuegoTerminado = validarJuegoTerminado;
    }

    @Override
    public Juego ejecutar(TurnoEleccionMano turnoEleccionMano) {
        existeJuego(turnoEleccionMano.numeroJuego());
        Juego juego = cargarJuego(turnoEleccionMano);
        validarJuegoTerminado.validar(juego);
        Turno turno = obtenerTurnoActual(juego);
        turno = definirEleccionDeMado(turnoEleccionMano, juego, turno).validarGanador();
        turnoRepositorio.guardarTurno(turno,juego.numeroJuego());
        juego = cargarJuego(turnoEleccionMano).validarGanador();
        return validarCrearnuevoTurno(juego,turno);
    }

    private Juego cargarJuego(TurnoEleccionMano turnoEleccionMano) {
        return juegoRepositorio.buscarJuegoPorNumero(turnoEleccionMano.numeroJuego()).get();
    }

    private static Turno obtenerTurnoActual(Juego juego) {
        return juego.turnos().stream()
                    .max(Comparator.comparingInt(Turno::turnoNumero))
                    .orElseThrow();
    }

    private Turno definirEleccionDeMado(TurnoEleccionMano turnoEleccionMano, Juego juego,Turno turno) {
        Usuario jugador1 = juego.jugador1();
        if (ModalidadJuego.UN_JUGADOR == juego.modalidadJuego()) {
            if (!jugador1.identificacion().equals(turnoEleccionMano.identificacionJugador())) {
                errorJugador(turnoEleccionMano.identificacionJugador());
            }
            return turno.elegirManoJugador1(turnoEleccionMano.eleccionesDeJuego()).elegirManoJugador2(obtenerEleccionAleatoria());


        } else {
            Usuario jugador2 = juego.jugador2();
            if (!jugador1.identificacion().equals(turnoEleccionMano.identificacionJugador()) &&
                    !jugador2.identificacion().equals(turnoEleccionMano.identificacionJugador())
            ) {
                errorJugador(turnoEleccionMano.identificacionJugador());
            }
            if(jugador1.identificacion().equals(turnoEleccionMano.identificacionJugador())) {
                return turno.elegirManoJugador1(turnoEleccionMano.eleccionesDeJuego());
            }else{
                return turno.elegirManoJugador2(turnoEleccionMano.eleccionesDeJuego());

            }
        }
    }

    private void existeJuego(Integer numeroJuego) {
        validacionesExistencia.forEach(validacion -> validacion.validar(numeroJuego));
    }

    private void errorJugador(Integer identificacion) {
        UsuarioError error = new UsuarioError("El jugador con identificacion "+identificacion+" no pertenece a ese juego ");
        error.log();
        throw error;

    }

    private EleccionesDeJuego obtenerEleccionAleatoria(){
        Random random = new Random();
        return EleccionesDeJuego.values()[random.nextInt(EleccionesDeJuego.values().length)];
    }

    private Juego validarCrearnuevoTurno(Juego juego, Turno turno){
        if(null != juego.ganador()){
           return juegoRepositorio.actualizarGanador(juego.ganador(), juego.numeroJuego());
        }
        if(null != turno.ganador()){
            juegoRepositorio.crearNuevoTurno(juego, turno.turnoNumero()+1);
        }
        return juego;
    }
}

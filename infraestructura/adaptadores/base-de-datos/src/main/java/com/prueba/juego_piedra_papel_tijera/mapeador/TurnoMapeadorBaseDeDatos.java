package com.prueba.juego_piedra_papel_tijera.mapeador;

import com.prueba.juego_piedra_papel_tijera.entidad.JuegoEntidad;
import com.prueba.juego_piedra_papel_tijera.entidad.TurnoEntidad;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.JuegoCrear;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.Turno;

import java.util.ArrayList;


public class TurnoMapeadorBaseDeDatos {

    private TurnoMapeadorBaseDeDatos() {

        throw new IllegalStateException("Clase util");
    }

    public static JuegoEntidad convertirCrearAEntidad(JuegoCrear juegoCrear) {
        JuegoEntidad entidad = new JuegoEntidad();
        entidad.setModalidadJuego(juegoCrear.modalidadJuego());
        entidad.setTurnos(new ArrayList<>());
        return entidad;
    }

    public static Turno convertirAModelo(TurnoEntidad turno) {
        return turno != null ? new Turno(turno.getManoJugador1(), turno.getManoJugador2(),
                                         turno.getGanador(),
                                         turno.getTurnoNumero()) : null;
    }
}

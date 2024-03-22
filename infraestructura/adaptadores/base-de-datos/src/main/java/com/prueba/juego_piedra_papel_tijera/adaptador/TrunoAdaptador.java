package com.prueba.juego_piedra_papel_tijera.adaptador;

import com.prueba.juego_piedra_papel_tijera.adaptador.repositorio.turno.TurnoRepositorio;
import com.prueba.juego_piedra_papel_tijera.entidad.JuegoEntidad;
import com.prueba.juego_piedra_papel_tijera.entidad.TurnoEntidad;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.Turno;
import com.prueba.juego_piedra_papel_tijera.mapeador.TurnoMapeadorBaseDeDatos;
import com.prueba.juego_piedra_papel_tijera.repositorio.JuegoRepositorioJpa;
import com.prueba.juego_piedra_papel_tijera.repositorio.TurnoRepositorioJpa;

import org.springframework.stereotype.Repository;

@Repository
public class TrunoAdaptador implements TurnoRepositorio {

    private JuegoRepositorioJpa juegoRepositorioJpa;
    private TurnoRepositorioJpa turnoRepositorioJpa;

    public TrunoAdaptador(JuegoRepositorioJpa juegoRepositorioJpa,
                          TurnoRepositorioJpa turnoRepositorioJpa) {
        this.juegoRepositorioJpa = juegoRepositorioJpa;
        this.turnoRepositorioJpa = turnoRepositorioJpa;
    }

    @Override
    public Turno guardarTurno(Turno turno, Integer numeroJuego) {
        JuegoEntidad juegoEntidad = juegoRepositorioJpa.findById(numeroJuego.longValue()).get();
        TurnoEntidad turnoEntidad =
                turnoRepositorioJpa.findByJuegoAndTurnoNumero(juegoEntidad, turno.turnoNumero());
        turnoEntidad.setManoJugador1(turno.manoJugador1());
        turnoEntidad.setManoJugador2(turno.manoJugador2());
        turnoEntidad.setGanador(turno.ganador());
        return TurnoMapeadorBaseDeDatos.convertirAModelo(turnoRepositorioJpa.save(turnoEntidad));
    }

    @Override
    public void borrarTurno(Turno turno, Integer numeroJuego) {
        JuegoEntidad juegoEntidad = juegoRepositorioJpa.findById(numeroJuego.longValue()).get();
        TurnoEntidad turnoEntidad =
                turnoRepositorioJpa.findByJuegoAndTurnoNumero(juegoEntidad, turno.turnoNumero());
        turnoRepositorioJpa.delete(turnoEntidad);
    }
}

package com.prueba.juego_piedra_papel_tijera.adaptador;

import com.prueba.juego_piedra_papel_tijera.adaptador.repositorio.juego.JuegoRepositorio;
import com.prueba.juego_piedra_papel_tijera.adaptador.repositorio.usuario.UsuarioRepositorio;
import com.prueba.juego_piedra_papel_tijera.entidad.JuegoEntidad;
import com.prueba.juego_piedra_papel_tijera.entidad.TurnoEntidad;
import com.prueba.juego_piedra_papel_tijera.entidad.UsuarioEntidad;
import com.prueba.juego_piedra_papel_tijera.entidad.enums.Ganador;
import com.prueba.juego_piedra_papel_tijera.entidad.enums.ModalidadJuego;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.Juego;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.JuegoCrear;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.JuegoIniciar;
import com.prueba.juego_piedra_papel_tijera.entidad.usuario.Usuario;
import com.prueba.juego_piedra_papel_tijera.entidad.usuario.UsuarioCrear;
import com.prueba.juego_piedra_papel_tijera.mapeador.JuegoMapeadorBaseDeDatos;
import com.prueba.juego_piedra_papel_tijera.mapeador.UsuarioMapeadorBaseDeDatos;
import com.prueba.juego_piedra_papel_tijera.repositorio.JuegoRepositorioJpa;
import com.prueba.juego_piedra_papel_tijera.repositorio.TurnoRepositorioJpa;
import com.prueba.juego_piedra_papel_tijera.repositorio.UsuarioRepositorioJpa;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JuegoAdaptador implements JuegoRepositorio {

    private JuegoRepositorioJpa juegoRepositorio;
    private UsuarioRepositorioJpa usuarioRepositorio;
    private TurnoRepositorioJpa turnoRepositorioJpa;

    public JuegoAdaptador(JuegoRepositorioJpa juegoRepositorio,
                          UsuarioRepositorioJpa usuarioRepositorio,
                          TurnoRepositorioJpa turnoRepositorioJpa) {
        this.juegoRepositorio = juegoRepositorio;
        this.usuarioRepositorio = usuarioRepositorio;
        this.turnoRepositorioJpa = turnoRepositorioJpa;
    }

    @Override
    public Juego guardarJuego(JuegoCrear juego) {
        JuegoEntidad entidad = JuegoMapeadorBaseDeDatos.convertirCrearAEntidad(juego);
        return JuegoMapeadorBaseDeDatos.convertirAModelo(juegoRepositorio.save(entidad));
    }

    @Override
    public Optional<Juego> buscarJuegoPorNumero(Integer numeroJuego) {
        return juegoRepositorio.findById(numeroJuego.longValue()).stream()
                               .map(JuegoMapeadorBaseDeDatos::convertirAModelo).findFirst();
    }

    @Override
    public Juego iniciarJuego(JuegoIniciar juego) {
        JuegoEntidad juegoEntidad =
                juegoRepositorio.findById(juego.numeroJuego().longValue()).get();
        UsuarioEntidad jugador1 =
                usuarioRepositorio.findById(juego.identificacionJugador1().longValue()).get();
        juegoEntidad.setJugador1(jugador1);
        if (ModalidadJuego.DOS_JUGADORES == juego.modalidadJuego()) {
            UsuarioEntidad jugador2 =
                    usuarioRepositorio.findById(juego.identificacionJugador2().longValue()).get();
            juegoEntidad.setJugador2(jugador2);
        }
        TurnoEntidad primerTurno = new TurnoEntidad();
        primerTurno.setTurnoNumero(1);
        juegoEntidad.agregarTurno(primerTurno);
        primerTurno.setJuego(juegoEntidad);
        turnoRepositorioJpa.save(primerTurno);

        return JuegoMapeadorBaseDeDatos.convertirAModelo(juegoRepositorio.save(juegoEntidad));
    }

    public void crearNuevoTurno(Juego juego, Integer numeroTurno ) {
        JuegoEntidad juegoEntidad =
                juegoRepositorio.findById(juego.numeroJuego().longValue()).get();
        TurnoEntidad nuevoTurno = new TurnoEntidad();
        nuevoTurno.setTurnoNumero(numeroTurno);
        juegoEntidad.agregarTurno(nuevoTurno);
        nuevoTurno.setJuego(juegoEntidad);
        turnoRepositorioJpa.save(nuevoTurno);
    }

    @Override
    public Juego actualizarGanador(Ganador ganador, Integer numeroJuego) {
        JuegoEntidad juegoEntidad =
                juegoRepositorio.findById(numeroJuego.longValue()).get();
        juegoEntidad.setGanador(ganador);
        return JuegoMapeadorBaseDeDatos.convertirAModelo(juegoRepositorio.save(juegoEntidad));
    }

    @Override
    public List<Juego> buscarTodosLosJuegos() {
        return juegoRepositorio.findAll().stream().map(JuegoMapeadorBaseDeDatos::convertirAModelo).collect(
                Collectors.toList());
    }
}

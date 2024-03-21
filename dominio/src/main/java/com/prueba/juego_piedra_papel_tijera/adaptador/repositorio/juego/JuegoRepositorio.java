package com.prueba.juego_piedra_papel_tijera.adaptador.repositorio.juego;

import com.prueba.juego_piedra_papel_tijera.entidad.enums.Ganador;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.Juego;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.JuegoCrear;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.JuegoIniciar;
import com.prueba.juego_piedra_papel_tijera.entidad.usuario.Usuario;
import com.prueba.juego_piedra_papel_tijera.entidad.usuario.UsuarioCrear;

import java.util.List;
import java.util.Optional;

public interface JuegoRepositorio {
    Juego guardarJuego(JuegoCrear juego);
    Optional<Juego> buscarJuegoPorNumero(Integer numeroJuego);
    Juego iniciarJuego(JuegoIniciar juego);
    void crearNuevoTurno(Juego juego, Integer numeroTurno );
    Juego actualizarGanador(Ganador ganador, Integer numeroJuego);

    List<Juego> buscarTodosLosJuegos();

}

package com.prueba.juego_piedra_papel_tijera.adaptador.repositorio.turno;


import com.prueba.juego_piedra_papel_tijera.entidad.juego.Turno;

public interface TurnoRepositorio {
    Turno guardarTurno(Turno turno, Integer numeroJuego);

    void borrarTurno(Turno turno, Integer numeroJuego);
}

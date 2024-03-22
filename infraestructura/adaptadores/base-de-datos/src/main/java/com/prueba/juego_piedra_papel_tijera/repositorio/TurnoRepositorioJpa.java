package com.prueba.juego_piedra_papel_tijera.repositorio;

import com.prueba.juego_piedra_papel_tijera.entidad.JuegoEntidad;
import com.prueba.juego_piedra_papel_tijera.entidad.TurnoEntidad;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TurnoRepositorioJpa extends JpaRepository<TurnoEntidad, Long> {

    TurnoEntidad findByJuegoAndTurnoNumero(JuegoEntidad juego, Integer turnoNumero);

}

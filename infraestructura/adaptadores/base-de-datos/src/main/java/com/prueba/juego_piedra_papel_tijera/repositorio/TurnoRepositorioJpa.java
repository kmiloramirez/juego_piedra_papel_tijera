package com.prueba.juego_piedra_papel_tijera.repositorio;

import com.prueba.juego_piedra_papel_tijera.entidad.JuegoEntidad;
import com.prueba.juego_piedra_papel_tijera.entidad.TurnoEntidad;
import com.prueba.juego_piedra_papel_tijera.entidad.UsuarioEntidad;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TurnoRepositorioJpa extends JpaRepository<TurnoEntidad,Long> {

    TurnoEntidad findByJuegoAndTurnoNumero(JuegoEntidad juego, Integer turnoNumero);

}

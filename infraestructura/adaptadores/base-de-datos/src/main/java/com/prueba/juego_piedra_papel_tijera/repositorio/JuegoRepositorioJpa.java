package com.prueba.juego_piedra_papel_tijera.repositorio;

import com.prueba.juego_piedra_papel_tijera.entidad.JuegoEntidad;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JuegoRepositorioJpa extends JpaRepository<JuegoEntidad, Long> {

}

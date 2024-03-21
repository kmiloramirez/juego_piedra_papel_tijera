package com.prueba.juego_piedra_papel_tijera.repositorio;

import com.prueba.juego_piedra_papel_tijera.entidad.JuegoEntidad;
import com.prueba.juego_piedra_papel_tijera.entidad.UsuarioEntidad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface JuegoRepositorioJpa extends JpaRepository<JuegoEntidad,Long> {

}

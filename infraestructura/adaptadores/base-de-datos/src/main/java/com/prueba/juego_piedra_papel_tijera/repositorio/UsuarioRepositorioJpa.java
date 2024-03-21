package com.prueba.juego_piedra_papel_tijera.repositorio;

import com.prueba.juego_piedra_papel_tijera.entidad.UsuarioEntidad;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepositorioJpa extends JpaRepository<UsuarioEntidad,Long> {

    Optional<UsuarioEntidad> findByNombre(String nombre);
}

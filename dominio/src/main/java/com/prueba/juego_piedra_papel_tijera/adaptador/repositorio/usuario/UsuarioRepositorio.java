package com.prueba.juego_piedra_papel_tijera.adaptador.repositorio.usuario;

import com.prueba.juego_piedra_papel_tijera.entidad.usuario.Usuario;
import com.prueba.juego_piedra_papel_tijera.entidad.usuario.UsuarioCrear;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepositorio {

    Usuario guardarUsuario(UsuarioCrear usuario);

    Optional<Usuario> buscarUsuarioPorNombre(String nombreUsuario);

    List<Usuario> buscarUsuarios();

    Optional<Usuario> buscarUsuarioPorIdentificacion(Integer identificacion);
}

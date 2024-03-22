package com.prueba.juego_piedra_papel_tijera.adaptador;

import com.prueba.juego_piedra_papel_tijera.adaptador.repositorio.usuario.UsuarioRepositorio;
import com.prueba.juego_piedra_papel_tijera.entidad.UsuarioEntidad;
import com.prueba.juego_piedra_papel_tijera.entidad.usuario.Usuario;
import com.prueba.juego_piedra_papel_tijera.entidad.usuario.UsuarioCrear;
import com.prueba.juego_piedra_papel_tijera.mapeador.UsuarioMapeadorBaseDeDatos;
import com.prueba.juego_piedra_papel_tijera.repositorio.UsuarioRepositorioJpa;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioAdaptador implements UsuarioRepositorio {

    private UsuarioRepositorioJpa usuarioRepositorio;

    public UsuarioAdaptador(UsuarioRepositorioJpa usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public Usuario guardarUsuario(UsuarioCrear usuario) {
        UsuarioEntidad entidad = UsuarioMapeadorBaseDeDatos.convertirAEntidad(usuario);
        return UsuarioMapeadorBaseDeDatos.convertirAModelo(usuarioRepositorio.save(entidad));
    }

    @Override
    public Optional<Usuario> buscarUsuarioPorNombre(String nombreUsuario) {
        return usuarioRepositorio.findByNombre(nombreUsuario).stream()
                                 .map(UsuarioMapeadorBaseDeDatos::convertirAModelo).findFirst();
    }

    @Override
    public List<Usuario> buscarUsuarios() {
        return usuarioRepositorio.findAll().stream()
                                 .map(UsuarioMapeadorBaseDeDatos::convertirAModelo).toList();
    }

    @Override
    public Optional<Usuario> buscarUsuarioPorIdentificacion(Integer identificacion) {
        return usuarioRepositorio.findById(identificacion.longValue()).stream()
                                 .map(UsuarioMapeadorBaseDeDatos::convertirAModelo).findFirst();
    }
}

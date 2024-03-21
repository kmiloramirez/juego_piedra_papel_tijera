package com.prueba.juego_piedra_papel_tijera.regla.usuario;

import com.prueba.juego_piedra_papel_tijera.adaptador.repositorio.usuario.UsuarioRepositorio;
import com.prueba.juego_piedra_papel_tijera.anotacion.ReglaDeNegocio;
import com.prueba.juego_piedra_papel_tijera.entidad.usuario.Usuario;
import com.prueba.juego_piedra_papel_tijera.entidad.usuario.UsuarioCrear;
import com.prueba.juego_piedra_papel_tijera.error.UsuarioError;
import com.prueba.juego_piedra_papel_tijera.regla.Regla;

import java.util.Optional;

@ReglaDeNegocio
public class UsuarioExistenteRegla implements Regla<UsuarioCrear> {

    private UsuarioRepositorio usuarioRepositorio;


    public UsuarioExistenteRegla(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }


    @Override
    public void validar(UsuarioCrear usuarioCrear) {
        UsuarioError error;
        String nombreUsuario = usuarioCrear.nombre();
        Optional<Usuario> usuarioBuscado = usuarioRepositorio.buscarUsuarioPorNombre(nombreUsuario);
        if (usuarioBuscado.isPresent()) {
            error = new UsuarioError("Usuario ya registrado con el id: " + usuarioBuscado.get().identificacion());
            error.log();
            throw error;
        }

    }
}

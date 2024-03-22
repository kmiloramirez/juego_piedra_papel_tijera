package com.prueba.juego_piedra_papel_tijera.regla.usuario;

import com.prueba.juego_piedra_papel_tijera.adaptador.repositorio.usuario.UsuarioRepositorio;
import com.prueba.juego_piedra_papel_tijera.anotacion.ReglaDeNegocio;
import com.prueba.juego_piedra_papel_tijera.entidad.usuario.Usuario;
import com.prueba.juego_piedra_papel_tijera.error.UsuarioError;
import com.prueba.juego_piedra_papel_tijera.regla.Regla;

import java.util.Optional;

@ReglaDeNegocio
public class UsuarioExistenteIdRegla implements Regla<Integer> {

    private UsuarioRepositorio usuarioRepositorio;


    public UsuarioExistenteIdRegla(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }


    @Override
    public void validar(Integer identificacion) {
        UsuarioError error;
        Optional<Usuario> usuarioBuscado =
                usuarioRepositorio.buscarUsuarioPorIdentificacion(identificacion);
        if (usuarioBuscado.isEmpty()) {
            error = new UsuarioError("Usuario el id: " + identificacion + " no existe");
            error.log();
            throw error;
        }

    }
}

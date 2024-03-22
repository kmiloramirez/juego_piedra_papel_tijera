package com.prueba.juego_piedra_papel_tijera.casodeuso.usuario;

import com.prueba.juego_piedra_papel_tijera.adaptador.repositorio.usuario.UsuarioRepositorio;
import com.prueba.juego_piedra_papel_tijera.anotacion.CasoDeUso;
import com.prueba.juego_piedra_papel_tijera.entidad.usuario.Usuario;

import java.util.List;

@CasoDeUso
public class BuscarUsuariosCasoDeUso {
    private UsuarioRepositorio usuarioRepositorio;

    public BuscarUsuariosCasoDeUso(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public List<Usuario> ejecutar() {
        return usuarioRepositorio.buscarUsuarios();
    }
}

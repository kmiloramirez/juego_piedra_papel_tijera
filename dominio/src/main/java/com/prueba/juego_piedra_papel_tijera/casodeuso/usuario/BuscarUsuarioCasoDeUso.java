package com.prueba.juego_piedra_papel_tijera.casodeuso.usuario;

import com.prueba.juego_piedra_papel_tijera.adaptador.repositorio.usuario.UsuarioRepositorio;
import com.prueba.juego_piedra_papel_tijera.anotacion.CasoDeUso;
import com.prueba.juego_piedra_papel_tijera.casodeuso.CasoDeUsoBase;
import com.prueba.juego_piedra_papel_tijera.entidad.usuario.Usuario;
import com.prueba.juego_piedra_papel_tijera.error.UsuarioError;

@CasoDeUso
public class BuscarUsuarioCasoDeUso implements CasoDeUsoBase<String, Usuario> {
    private UsuarioRepositorio usuarioRepositorio;

    public BuscarUsuarioCasoDeUso(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public Usuario ejecutar(String nombre) {
        return usuarioRepositorio.buscarUsuarioPorNombre(nombre).orElseThrow(() -> {
            UsuarioError error = new UsuarioError("Usuario con nombre: " + nombre + " no existe");
            error.log();
            throw error;
        });
    }

}

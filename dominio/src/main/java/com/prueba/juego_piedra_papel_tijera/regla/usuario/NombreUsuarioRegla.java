package com.prueba.juego_piedra_papel_tijera.regla.usuario;

import com.prueba.juego_piedra_papel_tijera.anotacion.ReglaDeNegocio;
import com.prueba.juego_piedra_papel_tijera.entidad.usuario.UsuarioCrear;
import com.prueba.juego_piedra_papel_tijera.error.UsuarioError;
import com.prueba.juego_piedra_papel_tijera.regla.Regla;


@ReglaDeNegocio
public class NombreUsuarioRegla implements Regla<UsuarioCrear> {

    @Override
    public void validar(UsuarioCrear usuario) {
        UsuarioError error;
        String nombreUsuario = usuario.nombre();
        if(null == nombreUsuario|| nombreUsuario.trim().isEmpty() ) {
            error = new UsuarioError("El usuario debe tener un nombre valido");
            error.log();
            throw error;
        }
    }
}

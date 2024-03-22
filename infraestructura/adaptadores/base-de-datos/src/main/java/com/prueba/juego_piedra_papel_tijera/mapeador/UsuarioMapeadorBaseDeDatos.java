package com.prueba.juego_piedra_papel_tijera.mapeador;

import com.prueba.juego_piedra_papel_tijera.entidad.UsuarioEntidad;
import com.prueba.juego_piedra_papel_tijera.entidad.usuario.Usuario;
import com.prueba.juego_piedra_papel_tijera.entidad.usuario.UsuarioCrear;


public class UsuarioMapeadorBaseDeDatos {

    private UsuarioMapeadorBaseDeDatos() {

        throw new IllegalStateException("Clase util");
    }

    public static UsuarioEntidad convertirAEntidad(UsuarioCrear usuario) {
        UsuarioEntidad entidad = new UsuarioEntidad();
        entidad.setNombre(usuario.nombre());
        return entidad;
    }

    public static Usuario convertirAModelo(UsuarioEntidad usuario) {
        return usuario != null ? new Usuario(usuario.getNombre(),
                                             usuario.getIdentificacion().intValue()) : null;
    }
}

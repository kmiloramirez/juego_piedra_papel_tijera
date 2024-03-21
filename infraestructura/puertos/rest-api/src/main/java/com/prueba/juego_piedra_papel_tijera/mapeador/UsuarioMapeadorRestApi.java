package com.prueba.juego_piedra_papel_tijera.mapeador;

import com.prueba.juego_piedra_papel_tijera.dto.UsuarioDto;
import com.prueba.juego_piedra_papel_tijera.entidad.usuario.Usuario;
import com.prueba.juego_piedra_papel_tijera.entidad.usuario.UsuarioCrear;
import com.prueba.juego_piedra_papel_tijera.request.UsuarioCreacionRequest;


public class UsuarioMapeadorRestApi {


    private UsuarioMapeadorRestApi() {

        throw new IllegalStateException("Clase util");
    }

    public static UsuarioDto convertirADto(Usuario usuario) {
        return usuario != null ? new UsuarioDto(usuario.nombre(), usuario.identificacion()) : null;
    }

    public static UsuarioCrear convertirCreacionRequestAModelo(UsuarioCreacionRequest usuario) {
        return new UsuarioCrear(usuario.nombre());
    }

}

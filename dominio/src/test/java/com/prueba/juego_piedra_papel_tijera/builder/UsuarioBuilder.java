package com.prueba.juego_piedra_papel_tijera.builder;

import com.prueba.juego_piedra_papel_tijera.entidad.usuario.Usuario;
import com.prueba.juego_piedra_papel_tijera.entidad.usuario.UsuarioCrear;

public class UsuarioBuilder {
    private String nombre;
    private Integer identificacion;

    public UsuarioBuilder() {
        this.nombre = null;
        this.identificacion = null;
    }

    public UsuarioBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public UsuarioBuilder identificacion(Integer identificacion) {
        this.identificacion = identificacion;
        return this;
    }

    public Usuario build() {
        return new Usuario(nombre, identificacion);
    }
    public UsuarioCrear buildusuarioCrear() {
        return new UsuarioCrear(nombre);
    }

}

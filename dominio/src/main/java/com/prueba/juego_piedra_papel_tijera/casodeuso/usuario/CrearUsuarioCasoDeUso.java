package com.prueba.juego_piedra_papel_tijera.casodeuso.usuario;

import com.prueba.juego_piedra_papel_tijera.adaptador.repositorio.usuario.UsuarioRepositorio;
import com.prueba.juego_piedra_papel_tijera.anotacion.CasoDeUso;
import com.prueba.juego_piedra_papel_tijera.casodeuso.CasoDeUsoBase;
import com.prueba.juego_piedra_papel_tijera.entidad.usuario.Usuario;
import com.prueba.juego_piedra_papel_tijera.entidad.usuario.UsuarioCrear;
import com.prueba.juego_piedra_papel_tijera.regla.Regla;
import com.prueba.juego_piedra_papel_tijera.regla.usuario.NombreUsuarioRegla;
import com.prueba.juego_piedra_papel_tijera.regla.usuario.UsuarioExistenteRegla;

import java.util.ArrayList;
import java.util.List;

@CasoDeUso
public class CrearUsuarioCasoDeUso implements CasoDeUsoBase<UsuarioCrear, Usuario> {


    private UsuarioRepositorio usuarioRepositorio;
    private List<Regla<UsuarioCrear>> validaciones;


    public CrearUsuarioCasoDeUso(UsuarioRepositorio usuarioRepositorio,
                                 NombreUsuarioRegla nombreUsuarioRegla,
                                 UsuarioExistenteRegla usuarioExistenteRegla
                                ) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.validaciones = new ArrayList<>();
        this.validaciones.add(nombreUsuarioRegla);
        this.validaciones.add(usuarioExistenteRegla);
    }

    @Override
    public Usuario ejecutar(UsuarioCrear usuarioCrear) {
        validarUsuario(usuarioCrear);
        return usuarioRepositorio.guardarUsuario(usuarioCrear);
    }

    private void validarUsuario(UsuarioCrear usuarioCrear) {
        validaciones.forEach(validacion ->
                                     validacion.validar(usuarioCrear)
                            );

    }
}

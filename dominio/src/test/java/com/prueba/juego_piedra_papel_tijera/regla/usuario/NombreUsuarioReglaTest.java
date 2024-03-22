package com.prueba.juego_piedra_papel_tijera.regla.usuario;

import com.prueba.juego_piedra_papel_tijera.builder.UsuarioBuilder;
import com.prueba.juego_piedra_papel_tijera.entidad.usuario.UsuarioCrear;
import com.prueba.juego_piedra_papel_tijera.error.UsuarioError;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class NombreUsuarioReglaTest {

    private NombreUsuarioRegla regla;

    @Before
    public void configuracion() {
        regla = new NombreUsuarioRegla();
    }

    @Test
    void validarNombreUsuarioNull() {
        UsuarioCrear usuario = new UsuarioBuilder().nombre(null).buildusuarioCrear();
        Assertions.assertThrows(UsuarioError.class, () -> {
            regla.validar(usuario);
        });
    }

    @Test
    void validarNombreUsuarioEsVacio() {
        UsuarioCrear usuario = new UsuarioBuilder().nombre("").buildusuarioCrear();
        Assertions.assertThrows(UsuarioError.class, () -> {
            regla.validar(usuario);
        });

    }
}

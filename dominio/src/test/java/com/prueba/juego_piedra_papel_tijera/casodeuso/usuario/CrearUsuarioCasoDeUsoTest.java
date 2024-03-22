package com.prueba.juego_piedra_papel_tijera.casodeuso.usuario;

import com.prueba.juego_piedra_papel_tijera.adaptador.repositorio.usuario.UsuarioRepositorio;
import com.prueba.juego_piedra_papel_tijera.builder.UsuarioBuilder;
import com.prueba.juego_piedra_papel_tijera.entidad.usuario.Usuario;
import com.prueba.juego_piedra_papel_tijera.entidad.usuario.UsuarioCrear;
import com.prueba.juego_piedra_papel_tijera.regla.usuario.NombreUsuarioRegla;
import com.prueba.juego_piedra_papel_tijera.regla.usuario.UsuarioExistenteRegla;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class CrearUsuarioCasoDeUsoTest {

    private CrearUsuarioCasoDeUso casoDeUso;

    private UsuarioRepositorio usuarioRepositorio;
    private NombreUsuarioRegla nombreUsuarioRegla;
    private UsuarioExistenteRegla usuarioExistenteRegla;

    @Before
    public void configuracion() {
        usuarioRepositorio = Mockito.mock(UsuarioRepositorio.class);
        nombreUsuarioRegla = Mockito.mock(NombreUsuarioRegla.class);
        usuarioExistenteRegla = Mockito.mock(UsuarioExistenteRegla.class);
        casoDeUso = new CrearUsuarioCasoDeUso(usuarioRepositorio, nombreUsuarioRegla,
                                              usuarioExistenteRegla);
    }


    @Test
    public void ejecutar() {
        UsuarioCrear usuario = new UsuarioBuilder().nombre("Juan").buildusuarioCrear();
        ArgumentCaptor<UsuarioCrear> usuarioCaptor = ArgumentCaptor.forClass(UsuarioCrear.class);
        Usuario usuarioMock = new UsuarioBuilder().nombre("Juan").identificacion(1).build();
        Mockito.when(usuarioRepositorio.guardarUsuario(usuarioCaptor.capture()))
               .thenReturn(usuarioMock);
        Mockito.doNothing().when(nombreUsuarioRegla).validar(usuario);
        Mockito.doNothing().when(usuarioExistenteRegla).validar(usuario);

        Usuario resultadp = casoDeUso.ejecutar(usuario);
        Mockito.verify(usuarioRepositorio, Mockito.times(1)).guardarUsuario(usuario);
        Mockito.verify(nombreUsuarioRegla, Mockito.times(1)).validar(usuario);
        Mockito.verify(usuarioExistenteRegla, Mockito.times(1)).validar(usuario);

        Assertions.assertFalse(usuarioCaptor.getAllValues().isEmpty());
        Assertions.assertEquals(usuario.nombre(), usuarioCaptor.getValue().nombre());
        Assertions.assertEquals(usuarioMock.identificacion(), resultadp.identificacion());


    }
}

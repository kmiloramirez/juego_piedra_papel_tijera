package com.prueba.juego_piedra_papel_tijera.busqueda.usuario;

import com.prueba.juego_piedra_papel_tijera.casodeuso.usuario.BuscarUsuarioCasoDeUso;
import com.prueba.juego_piedra_papel_tijera.casodeuso.usuario.BuscarUsuariosCasoDeUso;
import com.prueba.juego_piedra_papel_tijera.dto.UsuarioDto;
import com.prueba.juego_piedra_papel_tijera.mapeador.UsuarioMapeadorRestApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("usuarioBuscarV1")
@RequestMapping(value = "v1/usuario/")
public class UsuarioBusqueda {
    private BuscarUsuariosCasoDeUso buscarUsuariosCasoDeUso;
    private BuscarUsuarioCasoDeUso buscarUsuarioCasoDeUso;

    public UsuarioBusqueda(BuscarUsuariosCasoDeUso buscarUsuariosCasoDeUso,
                           BuscarUsuarioCasoDeUso buscarUsuarioCasoDeUso) {
        this.buscarUsuariosCasoDeUso = buscarUsuariosCasoDeUso;
        this.buscarUsuarioCasoDeUso = buscarUsuarioCasoDeUso;
    }

    @GetMapping
    public List<UsuarioDto> buscarTodosLosUsuarios() {
        return buscarUsuariosCasoDeUso.ejecutar().stream().map(
                UsuarioMapeadorRestApi::convertirADto).toList();
    }

    @GetMapping("{nombre}")
    public UsuarioDto buscarjuego(@PathVariable String nombre) {
        return UsuarioMapeadorRestApi.convertirADto(buscarUsuarioCasoDeUso.ejecutar(nombre));
    }
}

package com.prueba.juego_piedra_papel_tijera.comando.usuario;

import com.prueba.juego_piedra_papel_tijera.casodeuso.usuario.CrearUsuarioCasoDeUso;
import com.prueba.juego_piedra_papel_tijera.dto.UsuarioDto;
import com.prueba.juego_piedra_papel_tijera.entidad.usuario.UsuarioCrear;
import com.prueba.juego_piedra_papel_tijera.mapeador.UsuarioMapeadorRestApi;
import com.prueba.juego_piedra_papel_tijera.request.UsuarioCreacionRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("usuarioV1")
@RequestMapping(value = "v1/usuario/")
public class UsuarioComando {

    private CrearUsuarioCasoDeUso crearUsuarioCasoDeUso;

    public UsuarioComando(CrearUsuarioCasoDeUso crearUsuarioCasoDeUso) {
        this.crearUsuarioCasoDeUso = crearUsuarioCasoDeUso;
    }

    @PostMapping
    public UsuarioDto crearUsuario(@RequestBody UsuarioCreacionRequest usuarioRequest) {
        UsuarioCrear usuario =
                UsuarioMapeadorRestApi.convertirCreacionRequestAModelo(usuarioRequest);
        return UsuarioMapeadorRestApi.convertirADto(crearUsuarioCasoDeUso.ejecutar(usuario));
    }

}

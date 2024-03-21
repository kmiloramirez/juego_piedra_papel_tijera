package com.prueba.juego_piedra_papel_tijera.busqueda.juego;

import com.prueba.juego_piedra_papel_tijera.casodeuso.juego.BuscarJuegosCasoDeuso;
import com.prueba.juego_piedra_papel_tijera.dto.JuegoDto;
import com.prueba.juego_piedra_papel_tijera.mapeador.JuegoMapeadorRestApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController("juegoBuscarV1")
@RequestMapping(value = "v1/juego/")
public class JuegoBusqueda {

    private BuscarJuegosCasoDeuso buscarJuegosCasoDeuso;

    public JuegoBusqueda(BuscarJuegosCasoDeuso buscarJuegosCasoDeuso) {
        this.buscarJuegosCasoDeuso = buscarJuegosCasoDeuso;
    }

    @GetMapping
    public List<JuegoDto> buscarTodosLosjuegos(){
        return buscarJuegosCasoDeuso.ejecutar().stream().map(JuegoMapeadorRestApi::convertirADto).collect(
                Collectors.toList());
    }
}

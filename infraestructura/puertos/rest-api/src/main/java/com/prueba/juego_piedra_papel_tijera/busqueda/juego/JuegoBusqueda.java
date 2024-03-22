package com.prueba.juego_piedra_papel_tijera.busqueda.juego;

import com.prueba.juego_piedra_papel_tijera.casodeuso.juego.BuscarJuegoCasoDeuso;
import com.prueba.juego_piedra_papel_tijera.casodeuso.juego.BuscarJuegosCasoDeuso;
import com.prueba.juego_piedra_papel_tijera.dto.JuegoDto;
import com.prueba.juego_piedra_papel_tijera.mapeador.JuegoMapeadorRestApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("juegoBuscarV1")
@RequestMapping(value = "v1/juego/")
public class JuegoBusqueda {

    private BuscarJuegosCasoDeuso buscarJuegosCasoDeuso;
    private BuscarJuegoCasoDeuso buscarJuegoCasoDeuso;

    public JuegoBusqueda(BuscarJuegosCasoDeuso buscarJuegosCasoDeuso,
                         BuscarJuegoCasoDeuso buscarJuegoCasoDeuso) {
        this.buscarJuegosCasoDeuso = buscarJuegosCasoDeuso;
        this.buscarJuegoCasoDeuso = buscarJuegoCasoDeuso;
    }

    @GetMapping
    public List<JuegoDto> buscarTodosLosjuegos() {
        return buscarJuegosCasoDeuso.ejecutar().stream().map(JuegoMapeadorRestApi::convertirADto)
                                    .toList();
    }

    @GetMapping("{numeroJuego}")
    public JuegoDto buscarjuego(@PathVariable Integer numeroJuego) {
        return JuegoMapeadorRestApi.convertirADto(buscarJuegoCasoDeuso.ejecutar(numeroJuego));
    }
}

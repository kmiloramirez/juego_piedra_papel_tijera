package com.prueba.juego_piedra_papel_tijera.comando.juego;

import com.prueba.juego_piedra_papel_tijera.casodeuso.juego.CrearJuegoCasoDeUso;
import com.prueba.juego_piedra_papel_tijera.casodeuso.juego.IniciarJuegoCasoDeUso;
import com.prueba.juego_piedra_papel_tijera.casodeuso.juego.MovimeintoDeJuegoCasoDeUso;
import com.prueba.juego_piedra_papel_tijera.dto.JuegoDto;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.JuegoCrear;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.JuegoIniciar;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.TurnoEleccionMano;
import com.prueba.juego_piedra_papel_tijera.mapeador.JuegoMapeadorRestApi;
import com.prueba.juego_piedra_papel_tijera.request.JuegoCrearRequest;
import com.prueba.juego_piedra_papel_tijera.request.TurnoEleccionManoRequest;
import com.prueba.juego_piedra_papel_tijera.request.JuegoIniciarRequest;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("juegoComandoV1")
@RequestMapping(value = "v1/juego/")
public class juegoComando {

    private CrearJuegoCasoDeUso crearJuegoCasoDeUso;
    private IniciarJuegoCasoDeUso iniciarJuegoCasoDeUso;
    private MovimeintoDeJuegoCasoDeUso movimeintoDeJuegoCasoDeUso;


    public juegoComando(CrearJuegoCasoDeUso crearJuegoCasoDeUso,
                        IniciarJuegoCasoDeUso iniciarJuegoCasoDeUso,
                        MovimeintoDeJuegoCasoDeUso movimeintoDeJuegoCasoDeUso) {
        this.crearJuegoCasoDeUso = crearJuegoCasoDeUso;
        this.iniciarJuegoCasoDeUso = iniciarJuegoCasoDeUso;
        this.movimeintoDeJuegoCasoDeUso = movimeintoDeJuegoCasoDeUso;
    }

    @PostMapping
    public JuegoDto crearJuego(@RequestBody JuegoCrearRequest juegoRequest){
        JuegoCrear juego = JuegoMapeadorRestApi.convertirCreacionRequestAModelo(juegoRequest);
        return JuegoMapeadorRestApi.convertirADto(crearJuegoCasoDeUso.ejecutar(juego));
    }

    @PatchMapping("inicia/{numeroJuego}")
    public JuegoDto iniciarJuego(@PathVariable Integer numeroJuego, @RequestBody
                                 JuegoIniciarRequest juegoRequest){
        JuegoIniciar juego = JuegoMapeadorRestApi.convertirIniciarRequestAModelo(numeroJuego,juegoRequest);
        return JuegoMapeadorRestApi.convertirADto(iniciarJuegoCasoDeUso.ejecutar(juego));
    }

    @PatchMapping ("{numeroJuego}/jugador/{identificacionJugador}/eleccion")
    public JuegoDto eleccionJugador(@PathVariable Integer numeroJuego,@PathVariable Integer identificacionJugador, @RequestBody
    TurnoEleccionManoRequest juegoRequest){
        TurnoEleccionMano juego = JuegoMapeadorRestApi.convertirEleccionRequestAModelo(numeroJuego, identificacionJugador, juegoRequest);
        return JuegoMapeadorRestApi.convertirADto(movimeintoDeJuegoCasoDeUso.ejecutar(juego));
    }

}

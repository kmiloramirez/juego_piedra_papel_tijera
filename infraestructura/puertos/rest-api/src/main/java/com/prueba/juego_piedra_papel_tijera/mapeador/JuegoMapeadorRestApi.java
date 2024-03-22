package com.prueba.juego_piedra_papel_tijera.mapeador;

import com.prueba.juego_piedra_papel_tijera.dto.JuegoDto;
import com.prueba.juego_piedra_papel_tijera.dto.TurnoDto;
import com.prueba.juego_piedra_papel_tijera.dto.UsuarioDto;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.Juego;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.JuegoCrear;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.JuegoIniciar;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.TurnoEleccionMano;
import com.prueba.juego_piedra_papel_tijera.request.JuegoCrearRequest;
import com.prueba.juego_piedra_papel_tijera.request.JuegoIniciarRequest;
import com.prueba.juego_piedra_papel_tijera.request.TurnoEleccionManoRequest;

import java.util.List;


public class JuegoMapeadorRestApi {


    private JuegoMapeadorRestApi() {

        throw new IllegalStateException("Clase util");
    }

    public static JuegoDto convertirADto(Juego juego) {
        UsuarioDto jugador1 = UsuarioMapeadorRestApi.convertirADto(juego.jugador1());
        UsuarioDto jugador2 = UsuarioMapeadorRestApi.convertirADto(juego.jugador2());
        List<TurnoDto> turnos =
                juego.turnos().stream().map(TurnoMapeadorRestApi::convertirADto).toList();
        return new JuegoDto(juego.numeroJuego(), jugador1, jugador2, juego.modalidadJuego(),
                            turnos, juego.ganador());
    }

    public static JuegoCrear convertirCreacionRequestAModelo(JuegoCrearRequest juego) {
        return new JuegoCrear(juego.modalidadJuego());
    }

    public static JuegoIniciar convertirIniciarRequestAModelo(Integer numeroJuego,
                                                              JuegoIniciarRequest juego) {
        return new JuegoIniciar(numeroJuego, juego.identificacionJugador1(),
                                juego.identificacionJugador2(), null);
    }

    public static TurnoEleccionMano convertirEleccionRequestAModelo(Integer numeroJuego,
                                                                    Integer identificacionJugador,
                                                                    TurnoEleccionManoRequest juego) {
        return new TurnoEleccionMano(numeroJuego, identificacionJugador, juego.eleccionesDeJuego());
    }

}

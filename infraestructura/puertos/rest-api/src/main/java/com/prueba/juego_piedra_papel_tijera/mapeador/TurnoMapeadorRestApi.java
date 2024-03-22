package com.prueba.juego_piedra_papel_tijera.mapeador;

import com.prueba.juego_piedra_papel_tijera.dto.TurnoDto;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.Turno;
import com.prueba.juego_piedra_papel_tijera.entidad.usuario.UsuarioCrear;
import com.prueba.juego_piedra_papel_tijera.request.UsuarioCreacionRequest;


public class TurnoMapeadorRestApi {


    private TurnoMapeadorRestApi() {

        throw new IllegalStateException("Clase util");
    }

    public static TurnoDto convertirADto(Turno turno) {
        return turno != null ? new TurnoDto(turno.manoJugador1(), turno.manoJugador2(),
                                            turno.ganador(),
                                            turno.turnoNumero()) : null;
    }

    public static UsuarioCrear convertirCreacionRequestAModelo(UsuarioCreacionRequest usuario) {
        return new UsuarioCrear(usuario.nombre());
    }

}

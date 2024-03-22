package com.prueba.juego_piedra_papel_tijera.entidad.juego;

import com.prueba.juego_piedra_papel_tijera.entidad.enums.Ganador;
import com.prueba.juego_piedra_papel_tijera.entidad.enums.ModalidadJuego;
import com.prueba.juego_piedra_papel_tijera.entidad.usuario.Usuario;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public record Juego(
        Integer numeroJuego,
        Usuario jugador1,
        Usuario jugador2,
        ModalidadJuego modalidadJuego,
        List<Turno> turnos,
        Ganador ganador
) {

    public Juego validarGanador() {
        Map<Ganador, Integer> conteoGanadores = new EnumMap<>(Ganador.class);
        List<Turno> turnosJugados =
                this.turnos().stream().filter(trn -> (null != trn.ganador())).toList();
        for (Turno turno : turnosJugados) {
            conteoGanadores.put(turno.ganador(),
                                conteoGanadores.getOrDefault(turno.ganador(), 0) + 1);
        }

        for (Map.Entry<Ganador, Integer> mapa : conteoGanadores.entrySet()) {
            if (mapa.getValue() >= 3 && !mapa.getKey().equals(Ganador.EMPATE)) {
                return new Juego(this.numeroJuego, this.jugador1(), this.jugador2(),
                                 this.modalidadJuego(), this.turnos(), mapa.getKey());
            }
        }
        return this;

    }

    public Juego eliminarGanador() {
        return new Juego(this.numeroJuego, this.jugador1(), this.jugador2(), this.modalidadJuego(),
                         this.turnos(), null);


    }

    public Juego eliminarTurnos() {
        return new Juego(this.numeroJuego, this.jugador1(), this.jugador2(), this.modalidadJuego(),
                         null, this.ganador());


    }

}

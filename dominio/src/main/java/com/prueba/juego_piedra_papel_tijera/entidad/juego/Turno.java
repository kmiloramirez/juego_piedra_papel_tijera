package com.prueba.juego_piedra_papel_tijera.entidad.juego;

import com.prueba.juego_piedra_papel_tijera.entidad.enums.EleccionesDeJuego;
import com.prueba.juego_piedra_papel_tijera.entidad.enums.Ganador;

public record Turno(
        EleccionesDeJuego manoJugador1,
        EleccionesDeJuego manoJugador2,
        Ganador ganador,
        Integer turnoNumero
) {
    public Turno elegirManoJugador1(EleccionesDeJuego eleccion){
        return new Turno(eleccion,this.manoJugador2(),this.ganador(),this.turnoNumero);
    }

    public Turno elegirManoJugador2(EleccionesDeJuego eleccion){
        return new Turno(this.manoJugador1(),eleccion,this.ganador(),this.turnoNumero);
    }
    public Turno validarGanador() {
        if (null == this.manoJugador1() || null == this.manoJugador2()) {
            return new Turno(this.manoJugador1(), this.manoJugador2(), this.ganador(),
                             this.turnoNumero);
        }
        else if  (this.manoJugador1() == this.manoJugador2()) {
            return new Turno(this.manoJugador1(), this.manoJugador2(), Ganador.EMPATE, this.turnoNumero);
        } else if (
                (this.manoJugador1() == EleccionesDeJuego.PIEDRA && this.manoJugador2() == EleccionesDeJuego.TIJERA) ||
                (this.manoJugador1() == EleccionesDeJuego.PAPEL && this.manoJugador2() == EleccionesDeJuego.PIEDRA) ||
                (this.manoJugador1() == EleccionesDeJuego.TIJERA && this.manoJugador2() == EleccionesDeJuego.PAPEL)
        ) {
            return new Turno(this.manoJugador1(), this.manoJugador2(), Ganador.JUGADOR_1, this.turnoNumero);
        } else {
            return new Turno(this.manoJugador1(), this.manoJugador2(), Ganador.JUGADOR_2, this.turnoNumero);
        }
    }


}

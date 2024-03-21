package com.prueba.juego_piedra_papel_tijera.entidad;

import com.prueba.juego_piedra_papel_tijera.entidad.enums.EleccionesDeJuego;
import com.prueba.juego_piedra_papel_tijera.entidad.enums.Ganador;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Turno")
@SequenceGenerator(name = "SECUENCIA_TURNO", initialValue = 1, allocationSize = 1)
public class TurnoEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SECUENCIA_TURNO")
    private Long Id;
    @Enumerated(EnumType.STRING)
    EleccionesDeJuego manoJugador1;
    @Enumerated(EnumType.STRING)
    EleccionesDeJuego manoJugador2;
    @Enumerated(EnumType.STRING)
    Ganador ganador;

    public void setManoJugador1(
            EleccionesDeJuego manoJugador1) {
        this.manoJugador1 = manoJugador1;
    }

    public void setManoJugador2(
            EleccionesDeJuego manoJugador2) {
        this.manoJugador2 = manoJugador2;
    }

    public void setGanador(Ganador ganador) {
        this.ganador = ganador;
    }

    @Column
    Integer turnoNumero;

    public EleccionesDeJuego getManoJugador1() {
        return manoJugador1;
    }

    public EleccionesDeJuego getManoJugador2() {
        return manoJugador2;
    }

    public Ganador getGanador() {
        return ganador;
    }

    public void setTurnoNumero(Integer turnoNumero) {
        this.turnoNumero = turnoNumero;
    }

    public void setJuego(JuegoEntidad juego) {
        this.juego = juego;
    }

    public Integer getTurnoNumero() {
        return turnoNumero;
    }

    public JuegoEntidad getJuego() {
        return juego;
    }

    @ManyToOne
    @JoinColumn(name = "juego_id")
    private JuegoEntidad juego;

}

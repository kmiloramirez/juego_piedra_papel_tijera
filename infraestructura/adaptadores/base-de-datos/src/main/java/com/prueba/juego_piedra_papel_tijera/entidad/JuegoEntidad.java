package com.prueba.juego_piedra_papel_tijera.entidad;

import com.prueba.juego_piedra_papel_tijera.entidad.enums.Ganador;
import com.prueba.juego_piedra_papel_tijera.entidad.enums.ModalidadJuego;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Juego")
@SequenceGenerator(name = "SECUENCIA_JUEGO", initialValue = 1, allocationSize = 1)
public class JuegoEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SECUENCIA_JUEGO")
    private int numeroJuego;

    @ManyToOne
    private UsuarioEntidad jugador1;
    @ManyToOne
    private UsuarioEntidad jugador2;
    @Enumerated(EnumType.STRING)
    private ModalidadJuego modalidadJuego;

    @Enumerated(EnumType.STRING)
    private Ganador ganador;

    @OneToMany(mappedBy = "juego")
    private List<TurnoEntidad> turnos;

    public int getNumeroJuego() {
        return numeroJuego;
    }

    public UsuarioEntidad getJugador1() {
        return jugador1;
    }

    public void setJugador1(UsuarioEntidad jugador1) {
        this.jugador1 = jugador1;
    }

    public UsuarioEntidad getJugador2() {
        return jugador2;
    }

    public void setJugador2(UsuarioEntidad jugador2) {
        this.jugador2 = jugador2;
    }

    public ModalidadJuego getModalidadJuego() {
        return modalidadJuego;
    }

    public void setModalidadJuego(
            ModalidadJuego modalidadJuego) {
        this.modalidadJuego = modalidadJuego;
    }

    public Ganador getGanador() {
        return ganador;
    }

    public void setGanador(Ganador ganador) {
        this.ganador = ganador;
    }

    public List<TurnoEntidad> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<TurnoEntidad> turnos) {
        this.turnos = turnos;
    }

    public void agregarTurno(TurnoEntidad turno) {
        this.turnos.add(turno);
    }
}

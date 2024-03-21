package com.prueba.juego_piedra_papel_tijera.mapeador;

import com.prueba.juego_piedra_papel_tijera.entidad.JuegoEntidad;
import com.prueba.juego_piedra_papel_tijera.entidad.UsuarioEntidad;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.Juego;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.JuegoCrear;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.Turno;
import com.prueba.juego_piedra_papel_tijera.entidad.usuario.Usuario;
import com.prueba.juego_piedra_papel_tijera.entidad.usuario.UsuarioCrear;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class JuegoMapeadorBaseDeDatos {

    private JuegoMapeadorBaseDeDatos() {

        throw new IllegalStateException("Clase util");
    }
    public static JuegoEntidad convertirCrearAEntidad(JuegoCrear juegoCrear){
        JuegoEntidad entidad =new JuegoEntidad();
        entidad.setModalidadJuego(juegoCrear.modalidadJuego());
        entidad.setTurnos(new ArrayList<>());
        return entidad;
    }

    public static Juego convertirAModelo(JuegoEntidad juego){
        Usuario juagador1 = UsuarioMapeadorBaseDeDatos.convertirAModelo(juego.getJugador1());
        Usuario juagador2 = UsuarioMapeadorBaseDeDatos.convertirAModelo(juego.getJugador2());
        List<Turno> turnos =
                juego.getTurnos().stream().map(TurnoMapeadorBaseDeDatos::convertirAModelo)
                     .collect(Collectors.toList());
        return new Juego(juego.getNumeroJuego(), juagador1,juagador2,juego.getModalidadJuego(),turnos, juego.getGanador());
    }
}

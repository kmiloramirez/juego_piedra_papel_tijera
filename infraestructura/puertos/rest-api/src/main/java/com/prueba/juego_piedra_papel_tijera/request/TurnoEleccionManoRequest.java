package com.prueba.juego_piedra_papel_tijera.request;

import com.prueba.juego_piedra_papel_tijera.entidad.enums.EleccionesDeJuego;

public record TurnoEleccionManoRequest(
        EleccionesDeJuego eleccionesDeJuego
) {
}

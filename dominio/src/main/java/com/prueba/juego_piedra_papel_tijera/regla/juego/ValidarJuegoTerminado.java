package com.prueba.juego_piedra_papel_tijera.regla.juego;

import com.prueba.juego_piedra_papel_tijera.anotacion.ReglaDeNegocio;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.Juego;
import com.prueba.juego_piedra_papel_tijera.error.UsuarioError;
import com.prueba.juego_piedra_papel_tijera.regla.Regla;

@ReglaDeNegocio
public class ValidarJuegoTerminado implements Regla<Juego> {
    @Override
    public void validar(Juego juego) {
        UsuarioError error;
        if (null != juego.ganador()) {
            error = new UsuarioError(
                    "EL juego con el numero: " + juego.numeroJuego() + " ya fue ganado por: "
                            + juego.ganador());
            error.log();
            throw error;
        }
    }
}

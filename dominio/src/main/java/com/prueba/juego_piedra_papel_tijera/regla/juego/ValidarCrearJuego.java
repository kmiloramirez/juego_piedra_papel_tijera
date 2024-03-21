package com.prueba.juego_piedra_papel_tijera.regla.juego;

import com.prueba.juego_piedra_papel_tijera.anotacion.ReglaDeNegocio;
import com.prueba.juego_piedra_papel_tijera.entidad.enums.ModalidadJuego;
import com.prueba.juego_piedra_papel_tijera.entidad.juego.JuegoCrear;
import com.prueba.juego_piedra_papel_tijera.error.UsuarioError;
import com.prueba.juego_piedra_papel_tijera.regla.Regla;

@ReglaDeNegocio
public class ValidarCrearJuego implements Regla<JuegoCrear> {
    @Override
    public void validar(JuegoCrear juego) {
        UsuarioError error;
        if(null==juego.modalidadJuego()){
            error = new UsuarioError("Debe seleccionar una modalidad de juego valida");
            error.log();
            throw error;
        }
    }
}

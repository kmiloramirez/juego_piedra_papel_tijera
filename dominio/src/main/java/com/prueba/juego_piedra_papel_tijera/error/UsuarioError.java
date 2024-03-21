package com.prueba.juego_piedra_papel_tijera.error;

public class UsuarioError extends  ErrorDominio{
    public UsuarioError(String mensaje) {
        super(mensaje, 406, UsuarioError.class.getSimpleName());
    }

}

package com.prueba.juego_piedra_papel_tijera.regla;

public interface Regla<T> {
    void validar(T t);
}

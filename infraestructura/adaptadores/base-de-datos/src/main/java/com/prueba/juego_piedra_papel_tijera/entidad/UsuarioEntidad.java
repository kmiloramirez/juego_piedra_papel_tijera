package com.prueba.juego_piedra_papel_tijera.entidad;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuario")
@SequenceGenerator(name = "SECUENCIA_USUARIO", initialValue = 1, allocationSize = 1)
public class UsuarioEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SECUENCIA_USUARIO")
    private Long identificacion;

    @Column
    private String nombre;

    public Long getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

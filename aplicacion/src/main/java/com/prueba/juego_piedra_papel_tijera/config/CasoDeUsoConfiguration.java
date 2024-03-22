package com.prueba.juego_piedra_papel_tijera.config;

import com.prueba.juego_piedra_papel_tijera.anotacion.CasoDeUso;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@ComponentScan(
        basePackages = "com.prueba.juego_piedra_papel_tijera.casodeuso",
        includeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = CasoDeUso.class
        )
)

@Configuration
public class CasoDeUsoConfiguration {
}

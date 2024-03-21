package com.prueba.juego_piedra_papel_tijera.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


import com.prueba.juego_piedra_papel_tijera.anotacion.CasoDeUso;

@ComponentScan(
        basePackages = "com.prueba.juego_piedra_papel_tijera.casodeuso",
        includeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = CasoDeUso.class
        )
)

@Configuration
public class CasoDeUsoConfiguration {}

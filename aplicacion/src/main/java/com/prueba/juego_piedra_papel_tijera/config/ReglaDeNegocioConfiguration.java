package com.prueba.juego_piedra_papel_tijera.config;


import com.prueba.juego_piedra_papel_tijera.anotacion.ReglaDeNegocio;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@ComponentScan(
        basePackages = "com.prueba.juego_piedra_papel_tijera.regla",
        includeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = ReglaDeNegocio.class
        )
)

@Configuration
public class ReglaDeNegocioConfiguration {}

package com.prueba.juego_piedra_papel_tijera.excepcion;

import com.prueba.juego_piedra_papel_tijera.error.ErrorDominio;
import com.prueba.juego_piedra_papel_tijera.excepcion.dto.ErrorResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DominioExcepcion extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ErrorDominio.class)
    public ResponseEntity<ErrorResponse> handleMiExcepcion(ErrorDominio error) {

        return ResponseEntity.status(error.getCodigoError()).body(new ErrorResponse(error.getMensaje(),error.getCodigoError(),error.getTipoError()));

    }

}

package com.prueba.juego_piedra_papel_tijera.error;


import java.util.logging.Logger;

public abstract class ErrorDominio extends RuntimeException {
    private static final Logger LOG = Logger.getLogger(ErrorDominio.class.getName());
    private static final String MENSAJE_ERROR =
            "ErrorDominio{mensaje='%s', codigoError=%d, tipoError='%s'}";

    private static final long serialVersionUID = 1L;
    private final String mensaje;
    private final int codigoError;

    private final String tipoError;

    protected ErrorDominio(String mensaje, int codigoError, String tipoError) {
        this.mensaje = mensaje;
        this.codigoError = codigoError;
        this.tipoError = tipoError;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void log() {
        LOG.severe(() -> String.format(MENSAJE_ERROR, mensaje, codigoError, tipoError));
    }

    public String getTipoError() {
        return tipoError;
    }

    public int getCodigoError() {
        return codigoError;
    }
}

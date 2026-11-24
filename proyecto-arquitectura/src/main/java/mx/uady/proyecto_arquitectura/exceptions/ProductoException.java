package mx.uady.proyecto_arquitectura.exceptions;

import org.springframework.http.HttpStatus;

public class ProductoException extends RuntimeException {

    private final HttpStatus status;

    public ProductoException(String mensaje, HttpStatus status) {
        super(mensaje);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}

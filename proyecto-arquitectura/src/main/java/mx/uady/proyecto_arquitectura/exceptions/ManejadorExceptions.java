package mx.uady.proyecto_arquitectura.exceptions;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice 
public class ManejadorExceptions {
    
    @ExceptionHandler(ProductoException.class)
    public ResponseEntity<?> manejadorProductoException(ProductoException pe){
        return ResponseEntity.status(pe.getStatus()).body(
            Map.of(
                "mensaje", pe.getMessage()
            )
        );
    }
}

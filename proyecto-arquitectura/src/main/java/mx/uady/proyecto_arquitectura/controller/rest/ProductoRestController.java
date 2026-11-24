package mx.uady.proyecto_arquitectura.controller.rest;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.uady.proyecto_arquitectura.model.Producto;
import mx.uady.proyecto_arquitectura.service.ProductoService;

@RestController 
@RequestMapping ("/api/productos")
public class ProductoRestController {

    private final ProductoService servicio;

    public ProductoRestController(ProductoService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public ResponseEntity<?> listarTodos(){
        List<Producto> productos = servicio.obtenerTodos();
        return ResponseEntity.ok(
            Map.of(
                "mensaje", "Productos listados correctamente",
                "productos", productos
            )
        );
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Producto producto) {
        Producto creado = servicio.guardar(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
            Map.of(
                "mensaje", "Producto creado correctamente",
                "producto", creado
            )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Producto producto) {
        Producto actualizado = servicio.guardar(producto);
        return ResponseEntity.ok(
            Map.of(
                "mensaje", "Producto actualizado correctamente",
                "producto", actualizado
            )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        servicio.eliminarProducto(id);
        return ResponseEntity.ok(
            Map.of(
                "mensaje", "Producto eliminado correctamente"
            )
        );
    }
}

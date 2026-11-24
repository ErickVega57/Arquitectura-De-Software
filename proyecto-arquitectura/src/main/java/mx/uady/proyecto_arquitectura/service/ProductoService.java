package mx.uady.proyecto_arquitectura.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.uady.proyecto_arquitectura.model.Producto;
import mx.uady.proyecto_arquitectura.repositorio.ProductoRepository;

@Service 
public class ProductoService {

    private final ProductoRepository repositorio;

    public ProductoService(ProductoRepository repositorio) {
        this.repositorio = repositorio;
    }


    public List<Producto> obtenerTodos(){
        return repositorio.obtenerTodos();
    }

    public Producto guardar(Producto producto){
        producto = validarProducto(producto);

        return repositorio.create(producto);
    }

    public Producto actualizaProducto(Producto producto){
        producto = validarProducto(producto);

        return repositorio.update(producto);
    }

    public int eliminarProducto(Long id){
        //validar que exista
        return repositorio.delete(id);
    }

    private Producto validarProducto(Producto producto){
        /*validar que el producto contenga valores correctos
          stock >= 0
          categoría válida
          si no está registrado en la BD id=null o id=0
          Precio >= 0.50
          nombreImagen no vacio
          atributos no vacios, etc..

          SI LA VALIDACION FALLA LANZAR PRODUCTO EXCEPTION EJ:
          throw new ProductoException("El stock debe ser mayor o igual que 0");
        */ 

        
        return producto;
    }
}

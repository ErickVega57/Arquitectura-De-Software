package mx.uady.proyecto_arquitectura.repositorio;

public interface CRUD<T> {

    T create(T entidad);
    T read(T entidad);
    int delete(Long id);
    T update(T entidad);
}

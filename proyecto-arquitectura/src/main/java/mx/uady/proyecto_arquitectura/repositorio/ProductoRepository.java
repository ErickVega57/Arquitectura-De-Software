package mx.uady.proyecto_arquitectura.repositorio;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import mx.uady.proyecto_arquitectura.model.Producto;

@Repository 
public class ProductoRepository implements CRUD<Producto> {

    private final JdbcTemplate jdbcTemplate;

    private static final RowMapper<Producto> PRODUCTO_ROW_MAPPER = (rs, rowNum) -> new Producto(
        rs.getInt("id"),
        rs.getString("nombre"),
        rs.getBigDecimal("precio"),
        rs.getInt("stock"),
        rs.getString("nombre_imagen"),
        rs.getString("categoria")
    );

    public ProductoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<Producto> obtenerTodos(){
        String sql = "SELECT id, nombre, precio, stock, nombre_imagen, categoria FROM inventario";
        return jdbcTemplate.query(sql, PRODUCTO_ROW_MAPPER);
    }

    @Override
    public Producto create(Producto producto) {
        String sql = "INSERT INTO inventario(id, nombre, precio, stock, nombre_imagen, categoria) values (?,?,?,?,?,?)";
        
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, producto.getNombre());
            ps.setBigDecimal(2, producto.getPrecio());
            ps.setInt(3, producto.getStock());
            ps.setString(4, producto.getNombreImagen());
            ps.setString(5, producto.getCategoria());
            return ps;
        }, keyHolder);

        Number key = keyHolder.getKey();
        Integer idGenerado = key != null ? key.intValue() : null;

        return new Producto(
            idGenerado,
            producto.getNombre(),
            producto.getPrecio(),
            producto.getStock(),
            producto.getNombreImagen(),
            producto.getCategoria()
        );
    }

    @Override
    public Producto read(Producto producto) {
        String sql = "SELECT id, nombre, precio, stock, nombre_imagen, categoria FROM producto WHERE id = ?";
        List<Producto> resultados = jdbcTemplate.query(sql, PRODUCTO_ROW_MAPPER, producto.getId());
        return resultados.getFirst();
    }

    @Override
    public int delete(Long id) {
        String sql = "DELETE FROM producto WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Producto update(Producto producto) {
        String sql = """
            UPDATE producto
            SET nombre = ?, precio = ?, stock = ?, nombre_imagen = ?, categoria = ?
            WHERE id = ?
            """;
        int filasAfectadas = jdbcTemplate.update(
            sql,
            producto.getNombre(),
            producto.getPrecio(),
            producto.getStock(),
            producto.getNombreImagen(),
            producto.getCategoria(),
            producto.getId()
        );
        if(filasAfectadas <= 0){
            // manejar error al actualizar
        }
        return producto;
    }
}

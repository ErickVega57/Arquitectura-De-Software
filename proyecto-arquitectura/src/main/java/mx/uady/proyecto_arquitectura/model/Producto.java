package mx.uady.proyecto_arquitectura.model;

import java.math.BigDecimal;

public class Producto {

    private Integer id;
    private String nombre;
    private BigDecimal precio;
    private Integer stock;
    private String nombreImagen;
    private String categoria;

    public Producto() {
    }

    public Producto(Integer id, String nombre, BigDecimal precio, Integer stock, String nombreImagen, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.nombreImagen = nombreImagen;
        this.categoria = categoria;
    }

    public Producto(String nombre, BigDecimal precio, Integer stock, String nombreImagen, String categoria) {
        this(null, nombre, precio, stock, nombreImagen, categoria);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
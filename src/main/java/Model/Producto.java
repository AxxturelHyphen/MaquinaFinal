package Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Producto {
    private int idProducto;
    private String nombre;
    private BigDecimal precio;
    private int stock;
    private String descripcion;
    private String categoria;
    private LocalDateTime fechaActualizacion;

    // Constructor, getters y setters
    public Producto(int idProducto, String nombre, BigDecimal precio, int stock) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Métodos adicionales
    public boolean hayStock() {
        return stock > 0;
    }

    public void reducirStock(int cantidad) {
        if (cantidad <= stock) {
            stock -= cantidad;
        } else {
            throw new IllegalArgumentException("No hay suficiente stock");
        }
    }

    // Getters y setters completos
    public int getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
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
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }
    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", descripcion='" + descripcion + '\'' +
                ", categoria='" + categoria + '\'' +
                ", fechaActualizacion=" + fechaActualizacion +
                '}';
    }
}

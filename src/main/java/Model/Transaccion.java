package Model;

public class Transaccion {
    private int idTransaccion;
    private int idProducto;
    private String tipoTransaccion; // "compra" o "venta"
    private int cantidad;
    private String fechaTransaccion;

    public Transaccion(int idTransaccion, int idProducto, String tipoTransaccion, int cantidad, String fechaTransaccion) {
        this.idTransaccion = idTransaccion;
        this.idProducto = idProducto;
        this.tipoTransaccion = tipoTransaccion;
        this.cantidad = cantidad;
        this.fechaTransaccion = fechaTransaccion;
    }

    // Getters y setters
    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(String fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }
}

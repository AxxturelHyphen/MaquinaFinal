package Model;

import java.util.ArrayList;
import java.util.List;

public class MaquinaExpendedora {
    private List<Producto> productos;
    private List<Usuario> usuarios;

    public MaquinaExpendedora() {
        this.productos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Otros métodos de gestión según necesidades
    public static void main(String[] args) {
    }
}

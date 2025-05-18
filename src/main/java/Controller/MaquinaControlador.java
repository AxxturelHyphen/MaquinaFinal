package Controller;

import Model.MaquinaExpendedora;
import Model.Producto;
import Model.Usuario;

public class MaquinaControlador {
    private MaquinaExpendedora maquina;

    public MaquinaControlador(MaquinaExpendedora maquina) {
        this.maquina = maquina;
    }

    public void venderProducto(Usuario usuario, Producto producto, int cantidad) {
        if (producto.getStock() >= cantidad) {
            producto.reducirStock(cantidad);
            // Aquí podrías registrar la transacción, etc.
            System.out.println("Venta realizada con éxito.");
        } else {
            System.out.println("No hay suficiente stock.");
        }
    }

    // Otros métodos de negocio según necesidades
}

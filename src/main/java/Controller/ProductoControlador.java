package Controller;

import Model.Producto;
import util.ConexionBD;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoControlador {
    private Connection conexion;

    public ProductoControlador() {
        this.conexion = ConexionBD.getInstancia().getConexion();
    }

    public List<Producto> obtenerTodos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos";

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id_producto");
                String nombre = rs.getString("nombre");
                BigDecimal precio = rs.getBigDecimal("precio");
                int stock = rs.getInt("stock");

                Producto producto = new Producto(id, nombre, precio, stock);
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setCategoria(rs.getString("categoria"));

                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productos;
    }

    public Producto obtenerPorId(int id) {
        String sql = "SELECT * FROM productos WHERE id_producto = ?";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String nombre = rs.getString("nombre");
                    BigDecimal precio = rs.getBigDecimal("precio");
                    int stock = rs.getInt("stock");

                    Producto producto = new Producto(id, nombre, precio, stock);
                    producto.setDescripcion(rs.getString("descripcion"));
                    producto.setCategoria(rs.getString("categoria"));

                    return producto;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean actualizarStock(int idProducto, int nuevoStock) {
        String sql = "UPDATE productos SET stock = ?, fecha_actualizacion = CURRENT_TIMESTAMP WHERE id_producto = ?";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, nuevoStock);
            pstmt.setInt(2, idProducto);

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Métodos adicionales: insertar, actualizar, eliminar...
    public boolean insertarProducto(Producto producto) {
        String sql = "INSERT INTO productos (nombre, precio, stock, descripcion, categoria) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, producto.getNombre());
            pstmt.setBigDecimal(2, producto.getPrecio());
            pstmt.setInt(3, producto.getStock());
            pstmt.setString(4, producto.getDescripcion());
            pstmt.setString(5, producto.getCategoria());

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarProducto(int idProducto) {
        String sql = "DELETE FROM productos WHERE id_producto = ?";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, idProducto);

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarProducto(Producto producto) {
        String sql = "UPDATE productos SET nombre = ?, precio = ?, stock = ?, descripcion = ?, categoria = ? WHERE id_producto = ?";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, producto.getNombre());
            pstmt.setBigDecimal(2, producto.getPrecio());
            pstmt.setInt(3, producto.getStock());
            pstmt.setString(4, producto.getDescripcion());
            pstmt.setString(5, producto.getCategoria());
            pstmt.setInt(6, producto.getIdProducto());

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean existeProducto(int idProducto) {
        String sql = "SELECT COUNT(*) FROM productos WHERE id_producto = ?";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, idProducto);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
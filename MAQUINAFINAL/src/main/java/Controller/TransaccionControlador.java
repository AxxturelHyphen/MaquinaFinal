package Controller;

import Model.Transaccion;
import util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransaccionControlador {
    private Connection conexion;

    public TransaccionControlador() {
        this.conexion = ConexionBD.getInstancia().getConexion();
    }

    public boolean agregarTransaccion(Transaccion transaccion) {
        String sql = "INSERT INTO transacciones (id_producto, tipo_transaccion, cantidad, fecha_transaccion) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, transaccion.getIdProducto());
            pstmt.setString(2, transaccion.getTipoTransaccion());
            pstmt.setInt(3, transaccion.getCantidad());
            pstmt.setString(4, transaccion.getFechaTransaccion());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Transaccion> obtenerTodas() {
        List<Transaccion> lista = new ArrayList<>();
        String sql = "SELECT * FROM transacciones";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Transaccion t = new Transaccion(
                        rs.getInt("id_transaccion"),
                        rs.getInt("id_producto"),
                        rs.getString("tipo_transaccion"),
                        rs.getInt("cantidad"),
                        rs.getString("fecha_transaccion")
                );
                lista.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Transaccion obtenerPorId(int idTransaccion) {
        String sql = "SELECT * FROM transacciones WHERE id_transaccion = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, idTransaccion);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Transaccion(
                            rs.getInt("id_transaccion"),
                            rs.getInt("id_producto"),
                            rs.getString("tipo_transaccion"),
                            rs.getInt("cantidad"),
                            rs.getString("fecha_transaccion")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean eliminarTransaccion(int idTransaccion) {
        String sql = "DELETE FROM transacciones WHERE id_transaccion = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, idTransaccion);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarTransaccion(Transaccion transaccion) {
        String sql = "UPDATE transacciones SET id_producto = ?, tipo_transaccion = ?, cantidad = ?, fecha_transaccion = ? WHERE id_transaccion = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, transaccion.getIdProducto());
            pstmt.setString(2, transaccion.getTipoTransaccion());
            pstmt.setInt(3, transaccion.getCantidad());
            pstmt.setString(4, transaccion.getFechaTransaccion());
            pstmt.setInt(5, transaccion.getIdTransaccion());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
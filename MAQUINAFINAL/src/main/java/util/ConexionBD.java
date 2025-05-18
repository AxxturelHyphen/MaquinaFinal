package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class ConexionBD {
    private static ConexionBD instancia;
    private Connection conexion;

    private ConexionBD() {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("src/main/resources/config.properties"));
            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");
            conexion = DriverManager.getConnection(url, user, password);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

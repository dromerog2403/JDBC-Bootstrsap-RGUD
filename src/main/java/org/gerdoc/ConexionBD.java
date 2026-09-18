package org.gerdoc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private final String url = "jdbc:mysql://127.0.0.1:3306/TEST?user=root&password=Ybr4Ywb6QxLzmL7";

    public Connection ObtenerConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Error en la conexión a la base de datos", e);
        }
    }
}
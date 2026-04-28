package Proyecto.Coexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Conexion {

    private Conexion() {
    }

    public static Connection conectar() throws SQLException {

        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/dinopolis","root","1234");
        } catch (SQLException e) {
            throw new SQLException("Error en la conexión de la base de datos");
        }


    }
}
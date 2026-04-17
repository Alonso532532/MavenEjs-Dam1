package Proyecto.DAO;

import Proyecto.Coexion.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class DUsuarios {
    public static boolean buscarPorNombreYContrasena(String nombre, String contrasena){
        try{
            Connection connection = Conexion.conectar();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from usuarios where nombre = ? and contrasena = ?");

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, contrasena);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

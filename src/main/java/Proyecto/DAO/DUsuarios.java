package Proyecto.DAO;

import Proyecto.Coexion.Conexion;
import Proyecto.Modelo.Clientes;
import Proyecto.Modelo.Usuario;

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
            if (!resultSet.next()) throw new IllegalArgumentException("No existe ningún usuario con esas credenciales");
            return resultSet.getBoolean(3);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean comprobarPorNombre(String nombre){
        try {
            Connection connection = Conexion.conectar();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from usuarios where nombre = ?");

            preparedStatement.setString(1, nombre);

            ResultSet resultSet = preparedStatement.executeQuery();

            // Si ".next" funciona significa que ha encontrado un usuario con ese nombre y devolverá true, sino false
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean anadir(Usuario usuario){
        try {
            Connection connection = Conexion.conectar();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Usuarios () values (?, ?, ?)");

            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getContrasena());
            preparedStatement.setBoolean(3, usuario.isEsAdmin());

            return preparedStatement.executeUpdate()==1;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

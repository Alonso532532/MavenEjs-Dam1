package BBDD.Practica.DAO;

import BBDD.Practica.Util.Conexion;
import BBDD.Practica.Modelo.Autor;

import java.sql.*;
import java.util.ArrayList;

public class DAutor {
    public static boolean anadirAutor(Autor autor) throws SQLException {
        try {
            Connection conexion = Conexion.conectar();
            PreparedStatement preparedStatement = conexion.prepareStatement("insert into autores (nombre, pais) values(?, ?)");

            preparedStatement.setString(1, autor.getNombre());
            preparedStatement.setString(2, autor.getPais());

            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public static ArrayList<Autor> mostrarAutores(){
        try {
            Connection conexion = Conexion.conectar();
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from autores");
            ArrayList<Autor> autores = new ArrayList<>();
            while (resultSet.next()){
                autores.add(new Autor(resultSet.getInt("id"), resultSet.getString("nombre"), resultSet.getString("pais")));
            }
            return autores;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}

package Proyecto.DAO;

import Proyecto.Coexion.Conexion;
import Proyecto.Modelo.Clientes;
import Proyecto.Modelo.Entrada;

import java.sql.*;
import java.util.ArrayList;

public final class DEntrada {
    // Esta función seleccióna todas las entradas
    public static ArrayList<Entrada> seleccionarTodo(){
        try{
            Connection conexion = Conexion.conectar();
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from entrada");
            ArrayList<Entrada> entradas = new ArrayList<>();
            while (resultSet.next()){
                entradas.add(new Entrada(resultSet.getInt("numeroDeEntrada") ,resultSet.getString("tipo"), resultSet.getDouble("precio"), resultSet.getString("DNI")));
            }
            return entradas;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    // Esta añade una entrada mediante un objeto "Entrada"
    public static boolean anadir(Entrada entrada){
        try {
            Connection connection = Conexion.conectar();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into entrada (tipo, precio, DNI) values (?, ?, ?)");

            preparedStatement.setString(1, entrada.getTipo());
            preparedStatement.setDouble(2, entrada.getPrecio());
            preparedStatement.setString(3, entrada.getDni());

            return preparedStatement.executeUpdate()==1;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}

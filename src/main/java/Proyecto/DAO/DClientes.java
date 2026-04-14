package Proyecto.DAO;

import Proyecto.Coexion.Conexion;
import Proyecto.Modelo.Clientes;
import com.sun.xml.bind.api.impl.NameConverter;

import java.sql.*;
import java.util.ArrayList;

public final class DClientes {
    public static ArrayList<Clientes> seleccionarClientes(){
        try{
            Connection conexion = Conexion.conectar();
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Clientes");
            ArrayList<Clientes> clientes = new ArrayList<>();
            while (resultSet.next()){
                clientes.add(new Clientes(resultSet.getString("DNI"), resultSet.getInt("edad"), resultSet.getString("nombre")));
            }
            return clientes;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static boolean anadirCliente(Clientes cliente){
        try {
            Connection connection = Conexion.conectar();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Clientes () values (?, ?, ?)");

            preparedStatement.setString(1, cliente.getDni());
            preparedStatement.setInt(2, cliente.getEdad());
            preparedStatement.setString(3, cliente.getNombre());

            return preparedStatement.executeUpdate()==1;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static Clientes seleccionarPorDni(String DNI){
        try {
            Connection connection = Conexion.conectar();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from clientes where DNI = ?");

            preparedStatement.setString(1, DNI);

            ResultSet resultSet = preparedStatement.executeQuery();
            return new Clientes(resultSet.getString("DNI"), resultSet.getInt("edad"), resultSet.getString("nombre"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

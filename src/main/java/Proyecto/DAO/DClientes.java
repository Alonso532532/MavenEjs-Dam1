package Proyecto.DAO;

import Proyecto.Coexion.Conexion;
import Proyecto.Modelo.Clientes;

import java.sql.*;
import java.util.ArrayList;

public final class DClientes {
    // Esta función seleccióna todos los clientes
    public static ArrayList<Clientes> seleccionarTodo(){
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

    // Esta añade un cliente mediante un objeto "Cliente"
    public static boolean anadir(Clientes cliente){
        if (comprobarPorDni(cliente.getDni())){
            return false;
        }
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

    // Esta se encarga de comprobar si el DNI está en la tabla, lo que es util para comprobaciones
    public static boolean comprobarPorDni(String DNI){
        try {
            Connection connection = Conexion.conectar();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from clientes where DNI = ?");

            preparedStatement.setString(1, DNI);

            ResultSet resultSet = preparedStatement.executeQuery();

            // Si ".next" funciona significa que ha encontrado un cliente con ese DNI y devolverá true, sino false
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Esta elimina un cliente según su DNI
    public static boolean eliminarPorDni(String DNI){
        try {
            Connection connection = Conexion.conectar();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from Clientes where DNI = ?");

            preparedStatement.setString(1, DNI);

            return preparedStatement.executeUpdate()==1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Estas dos modifican el nombre y la edad según el DNI
    public static boolean cambiarEdad(String DNI, int edad){
        try {
            Connection connection = Conexion.conectar();
            PreparedStatement preparedStatement = connection.prepareStatement("update Clientes set edad = ? where DNI = ?");

            preparedStatement.setInt(1, edad);
            preparedStatement.setString(2, DNI);

            return preparedStatement.executeUpdate()==1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean cambiarNombre(String DNI, String nombre){
        try {
            Connection connection = Conexion.conectar();
            PreparedStatement preparedStatement = connection.prepareStatement("update Clientes set nombre = ? where DNI = ?");

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, DNI);

            return preparedStatement.executeUpdate()==1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

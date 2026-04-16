package Proyecto.DAO;

import Proyecto.Coexion.Conexion;
import Proyecto.Modelo.Visita;

import java.sql.*;
import java.util.ArrayList;

import static Proyecto.DAO.DClientes.comprobarPorDni;

public final class DVisita {
    // Esta función seleccióna todas las visitas
    public static ArrayList<Visita> seleccionarTodo(){
        try{
            Connection conexion = Conexion.conectar();
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Visita");
            ArrayList<Visita> visitas = new ArrayList<>();
            while (resultSet.next()){
                visitas.add(new Visita(resultSet.getString("DNI"), resultSet.getInt("numeroDeZona"), false));
            }
            return visitas;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    // Esta añade una visita mediante un objeto "Visita"
    public static boolean anadir(Visita visita){
        try {
            Connection connection = Conexion.conectar();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Visita () values (?, ?)");

            preparedStatement.setString(1, visita.getDni());
            preparedStatement.setInt(2, visita.getNumeroDeZona());

            return preparedStatement.executeUpdate()==1;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Esta elimina una visita mediante un objeto "Visita"
    public static boolean eliminarPorDniYNumeroDeZona(Visita visita){
        try {
            Connection connection = Conexion.conectar();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from Clientes where DNI = ? and numeroDeZona = ?");

            preparedStatement.setString(1, visita.getDni());
            preparedStatement.setInt(2, visita.getNumeroDeZona());

            return preparedStatement.executeUpdate()==1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // En estas modifico todos los atributos
    public static boolean cambiarNumeroDeZona(Visita visita, int numeroDeZonaNuevo){
        try {
            Connection connection = Conexion.conectar();
            PreparedStatement preparedStatement = connection.prepareStatement("update Entrada set numeroDeZona = ? where numeroDeZona = ? and dni = ?");

            preparedStatement.setInt(1, numeroDeZonaNuevo);
            preparedStatement.setInt(2, visita.getNumeroDeZona());
            preparedStatement.setString(3, visita.getDni());

            return preparedStatement.executeUpdate()==1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean cambiarDni(Visita visita, String dniNuevo){
        try {
            Connection connection = Conexion.conectar();
            PreparedStatement preparedStatement = connection.prepareStatement("update Entrada set dni = ? where numeroDeZona = ? and dni = ?");

            preparedStatement.setString(1, dniNuevo);
            preparedStatement.setInt(2, visita.getNumeroDeZona());
            preparedStatement.setString(3, visita.getDni());

            return preparedStatement.executeUpdate()==1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

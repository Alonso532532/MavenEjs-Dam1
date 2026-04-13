package Proyecto.DAO;

import Proyecto.Coexion.Conexion;
import Proyecto.Modelo.Clientes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
}

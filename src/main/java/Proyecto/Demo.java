package Proyecto;

import Proyecto.Coexión.Conexion;
import Proyecto.Modelo.Clientes;
import Serializacion.NOHAYINTERNET.Persona;

import java.sql.SQLException;

public class Demo {
    public static void main(String[] args) {
        try{
            Conexion.conectar();
            System.out.println("Conexión exitosa");
        }catch (SQLException e){
            e.printStackTrace();
        }
        try{
            Clientes hecproll = new Clientes("1232123S", 20, "Hecproll");
            System.out.println(hecproll);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

}

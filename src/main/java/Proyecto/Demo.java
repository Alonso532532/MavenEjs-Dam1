package Proyecto;

import Proyecto.Coexion.Conexion;
import Proyecto.DAO.DEntrada;
import Proyecto.Modelo.*;

import java.sql.SQLException;

public class Demo {
    public static void main(String[] args) {
        try{
            Conexion.conectar();
            System.out.println("Conexión exitosa");
        }catch (SQLException e) {
            e.printStackTrace();
        }

//        System.out.println("Clientes");
//        try{
//            Clientes hecproll = new Clientes("12321232S", 20, "Hecproll Villanueva");
//            System.out.println(hecproll);
//        } catch (IllegalArgumentException e){
//            System.out.println(e.getMessage());
//        }

        DEntrada.seleccionarTodo().forEach(System.out::println);
        if (DEntrada.cambiarDni(10, "29232320G")){
            System.out.println("BIEN");
        } else {
            System.out.println("MAL");
        }
        DEntrada.seleccionarTodo().forEach(System.out::println);

    }

}

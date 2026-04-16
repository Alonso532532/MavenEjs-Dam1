package Proyecto;

import Proyecto.Coexion.Conexion;
import Proyecto.Controlador.CClientes;
import Proyecto.Controlador.CZonas;
import Proyecto.DAO.DClientes;
import Proyecto.DAO.DZonas;
import Proyecto.Modelo.*;

import java.sql.SQLException;
import java.sql.SQLOutput;

public class Demo {
    public static void main(String[] args) {
        try{
            Conexion.conectar();
            System.out.println("Conexión exitosa");
        }catch (SQLException e) {
            e.printStackTrace();
        }

//        System.out.println("Zonas");
//        DZonas.seleccionarTodo().forEach(System.out::println);
//        System.out.println("Clientes");
//        DClientes.seleccionarTodo().forEach(System.out::println);
//        try{
//            Visita visita = new Visita("17352120H", 6);
//            System.out.println(visita);
//        } catch (IllegalArgumentException e){
//            System.out.println(e.getMessage());
//        }

//        DClientes.seleccionarTodo().forEach(System.out::println);
//        if (DClientes.cambiarDni("87878787S", "87878787H")){
//            System.out.println("BIEN");
//        } else {
//            System.out.println("MAL");
//        }
//        DClientes.seleccionarTodo().forEach(System.out::println);

        CZonas.seleccionarTodo().forEach(System.out::println);
        System.out.println(CZonas.eliminarPorNumeroDeZona(2));
        CZonas.seleccionarTodo().forEach(System.out::println);
    }

}

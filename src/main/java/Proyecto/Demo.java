package Proyecto;

import Proyecto.Coexion.Conexion;
import Proyecto.DAO.DClientes;
import Proyecto.Modelo.*;

import java.sql.SQLException;

public class Demo {
    public static void main(String[] args) {
        try{
            Conexion.conectar();
            System.out.println("Conexión exitosa");
        }catch (SQLException e){
            e.printStackTrace();
        }

        System.out.println("Clientes");
        try{
            Clientes hecproll = new Clientes("12321232S", 20, "Hecproll Villanueva");
            System.out.println(hecproll);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Visita");
        try{
            Visita hecproll = new Visita("1232123S", 3);
            System.out.println(hecproll);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Entrada");
        try{
            Entrada hecproll = new Entrada("Normal", 0, "1232123S");
            System.out.println(hecproll);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Atracciones");
        try{
            Atracciones hecproll = new Atracciones( "hola", 2);
            System.out.println(hecproll);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Zonas");
        try{
            Zonas hecproll = new Zonas("HECPROOLL asda");
            System.out.println(hecproll);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        DClientes.seleccionarClientes().forEach(System.out::println);

    }

}

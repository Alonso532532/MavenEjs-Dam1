package BBDD.Practica;

import BBDD.Practica.Controlador.CAutor;
import BBDD.Practica.DAO.DAutor;
import BBDD.Practica.Util.Conexion;

import java.sql.SQLException;

public class AlonsoPractica {
    public static void main(String[] args) throws SQLException {

        // Conexión
        try {

            Conexion.conectar();
            System.out.println("Conexión exitosa");

        }catch (SQLException e){

            e.printStackTrace();

        }

        DAutor.mostrarAutores().forEach(System.out::println);


    }

}

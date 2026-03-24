package BBDD.Practica;

import BBDD.Practica.Controlador.CAutor;
import BBDD.Practica.Controlador.CLibro;
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

        System.out.println(DAutor.idMax());

        CLibro.eliminarLibrosDeAutor();

    }

}

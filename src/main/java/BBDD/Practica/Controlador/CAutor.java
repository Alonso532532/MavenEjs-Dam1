package BBDD.Practica.Controlador;

import BBDD.Practica.DAO.DAutor;
import BBDD.Practica.Modelo.Autor;

import java.sql.SQLException;
import java.util.Scanner;

public class CAutor {
    public static void insertarAutores() throws SQLException {

        Scanner sc = new Scanner(System.in);
        System.out.println("-- Insertar autores --");
        String repetir = "s";
        while (repetir.equalsIgnoreCase("s")){

            System.out.print("Nombre del autor: ");
            String nombre= sc.nextLine();

            System.out.print("Pais del autor: ");
            String pais= sc.nextLine();

            if (DAutor.anadirAutor(new Autor(nombre, pais))){
                System.out.println("Autor creado con exito");
            } else {
                System.out.println("Operación fallida");
            }

            System.out.println("¿Quieres introducir otro autor? s/n");
            repetir = sc.nextLine();
        }
        System.out.println("-- Autores --");
        DAutor.mostrarAutores().forEach(System.out::println);
    }


}

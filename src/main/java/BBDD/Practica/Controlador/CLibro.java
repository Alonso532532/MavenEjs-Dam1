package BBDD.Practica.Controlador;

import BBDD.Practica.DAO.DLibro;

import java.sql.SQLException;
import java.util.Scanner;

public class CLibro {
    public static void mostrarLibrosConAutores(){
        System.out.println("-- Libros con sus autores --");
        DLibro.selectLibrosConAutor().forEach(System.out::println);
    }

    public static void subirPrecios(){
        if (DLibro.subirPrecios()){
            System.out.println("Precios subidos con éxito");
        }else {
            System.out.println("Error al subir los precios");
        }
    }

    public static void mostrarLibros(){
        System.out.println("-- Libros --");
        DLibro.selectLibros().forEach(System.out::println);
    }

    public static void eliminarLibrosDeAutor() throws SQLException {

        Scanner sc = new Scanner(System.in);
        System.out.println("-- Eliminar los libros de un autor --");
        String repetir = "s";
        while (repetir.equalsIgnoreCase("s")){

            System.out.print("Id del autor: ");
            String id= sc.nextLine();

            if (DLibro.eliminarLibrosDeAutor(id)){
                System.out.println("Libros eliminados con exito");
            } else {
                System.out.println("Operación fallida");
            }

            System.out.print("¿Quieres repetir esta acción? s/n: ");
            repetir = sc.nextLine();
        }
        mostrarLibros();
    }
}

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
        mostrarAutores();
    }

    public static void mostrarAutores(){
        System.out.println("-- Autores --");
        DAutor.selectAutores().forEach(System.out::println);
    }

    public static void cambiarPais(){
        System.out.println("-- Cambiar pais --");
        Scanner sc = new Scanner(System.in);
        String repetir = "s";
        int idMax = DAutor.idMax();
        while (repetir.equalsIgnoreCase("s")){
            int id;
            while (true) {
                System.out.print("ID de autor: ");
                try {
                    id = Integer.parseInt(sc.nextLine());
                    if (id > idMax || id < 1){
                        System.out.println("El id no existe");
                    } else break;
                }catch (IllegalArgumentException e){
                    System.out.println("Formato inválido");
                }
            }

            System.out.print("Pais: ");
            String pais = sc.nextLine();

            if (DAutor.cambiarPais(id, pais)){
                System.out.println("Pais del autor cambiado con éxito");
            } else {
                System.out.println("Fallo al cambiar el pais del autor");
            }

            System.out.println("¿Quieres cambiar otro pais? s/n");
            repetir = sc.nextLine();
        }
        mostrarAutores();
    }


}

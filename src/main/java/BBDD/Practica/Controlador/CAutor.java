package BBDD.Practica.Controlador;

import BBDD.Practica.DAO.DAutor;
import BBDD.Practica.DAO.DLibro;
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
        if (!DAutor.selectAutores().isEmpty()) {
            System.out.println("-- Autores --");
            DAutor.selectAutores().forEach(System.out::println);
        } else {
            System.out.println("No hay autores en la tabla autroes");
        }
    }

    public static void cambiarPais(){
        System.out.println("-- Cambiar pais --");
        Scanner sc = new Scanner(System.in);
        String repetir = "s";
        while (repetir.equalsIgnoreCase("s")){
            if (!DAutor.selectAutores().isEmpty()) {
                int id;
                while (true) {
                    System.out.print("ID de autor: ");
                    try {
                        id = Integer.parseInt(sc.nextLine());
                        int finalId = id;
                        if (DAutor.selectAutores().stream().filter(a->a.getId()== finalId).count()!=1){
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
            } else {
                System.out.println("No hay autores en la tabla autroes");
                break;
            }
        }
        mostrarAutores();
    }

    public static void eliminarAutor(){
        System.out.println("-- Eliminar autor --");
        Scanner sc = new Scanner(System.in);
        String repetir = "s";
        while (repetir.equalsIgnoreCase("s")){
            if (!DAutor.selectAutores().isEmpty()) {
                int id;
                while (true) {
                    System.out.print("ID de autor: ");
                    try {
                        id = Integer.parseInt(sc.nextLine());
                        int finalId = id;
                        if (DAutor.selectAutores().stream().filter(a -> a.getId() == finalId).count() != 1) {
                            System.out.println("El id no existe");
                        } else break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Formato inválido");
                    }
                }
                int cantLibros = DLibro.selectLibrosDeAutor(String.valueOf(id)).size();
                boolean tiene = false;
                if (cantLibros > 0) {
                    tiene = true;
                    System.out.print("El autor tiene " + cantLibros + " libros, ¿quieres eliminarlos? s/n: ");
                    String op = sc.nextLine();
                    if (op.equalsIgnoreCase("s")) {
                        if (DLibro.eliminarLibrosDeAutor(String.valueOf(id))) {
                            System.out.println("Libros del autor " + id + " eliminados con éxito");
                            tiene = false;
                        } else {
                            System.out.println("No se han podido eliminar los libros");
                        }
                    }
                }
                if (!tiene) {
                    if (DAutor.eliminarAutor(String.valueOf(id))) {
                        System.out.println("Autor eliminado con éxito");
                    } else {
                        System.out.println("No se ha podido eliminar el autor");
                    }
                }
                System.out.print("¿Quieres repetir esta acción? s/n:");
                repetir = sc.nextLine();
            } else {
                System.out.println("No hay autores en la tabla autroes");
                break;
            }
        }
        mostrarAutores();
    }
}

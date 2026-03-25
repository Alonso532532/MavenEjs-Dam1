package BBDD.Practica.Controlador;

import BBDD.Practica.DAO.DAutor;
import BBDD.Practica.DAO.DLibro;
import BBDD.Practica.Modelo.Libro;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class CLibro {
    public static void anadirLibro(){
        Scanner sc = new Scanner(System.in);
        System.out.println("-- Insertar libros --");
        String repetir = "s";
        while (repetir.equalsIgnoreCase("s")){

            System.out.print("Nombre del autor: ");
            String titulo= sc.nextLine();

            Double precio;
            while (true) {
                System.out.print("Precio: ");
                try {
                    precio = Double.parseDouble(sc.nextLine());
                    break;
                }catch (IllegalArgumentException e){
                    System.out.println("Formato inválido");
                }
            }

            int id_autor;
            while (true) {
                System.out.print("ID del autor: ");
                try {
                    id_autor = Integer.parseInt(sc.nextLine());
                    int finalId = id_autor;
                    if (DAutor.selectAutores().stream().filter(a->a.getId()== finalId).count()!=1){
                        System.out.println("El id de autor no existe");
                    } else break;
                }catch (IllegalArgumentException e){
                    System.out.println("Formato inválido");
                }
            }

            if (DLibro.anadirLibro(new Libro(titulo, precio, id_autor))){
                System.out.println("Libro creado con exito");
            } else {
                System.out.println("Operación fallida");
            }

            System.out.println("¿Quieres introducir otro libro? s/n");
            repetir = sc.nextLine();
            mostrarLibros();
        }

    }

    public static void mostrarLibrosConAutores(){
        if (!DLibro.selectLibros().isEmpty()) {
            System.out.println("-- Libros con sus autores --");
            DLibro.selectLibrosConAutor().forEach(System.out::println);
        } else {
            System.out.println("No hay libros en la tabla libros");
        }
    }

    public static void subirPrecios(){
        if (!DLibro.selectLibros().isEmpty()) {
            if (DLibro.subirPrecios()){
                System.out.println("Precios subidos con éxito");
            }else {
                System.out.println("Error al subir los precios");
            }
            mostrarLibros();
        } else {
            System.out.println("No hay libros en la tabla libros");
        }
    }

    public static void mostrarLibros(){
        if (!DLibro.selectLibros().isEmpty()) {
            System.out.println("-- Libros --");
            DLibro.selectLibros().forEach(System.out::println);
        } else {
            System.out.println("No hay libros en la tabla libros");
        }
    }

    public static void eliminarLibrosDeAutor() throws SQLException {

        Scanner sc = new Scanner(System.in);
        System.out.println("-- Eliminar los libros de un autor --");
        String repetir = "s";
        while (repetir.equalsIgnoreCase("s")){
            if (!DLibro.selectLibros().isEmpty()) {
                System.out.print("Id del autor: ");
                String id= sc.nextLine();

                if (DLibro.eliminarLibrosDeAutor(id)){
                    System.out.println("Libros eliminados con exito");
                } else {
                    System.out.println("Operación fallida");
                }

                System.out.print("¿Quieres repetir esta acción? s/n: ");
                repetir = sc.nextLine();
                mostrarLibros();
            } else {
                System.out.println("No hay libros en la tabla libros");
            }
        }

    }

    public static void librosConPrecioMenorA(){
        Scanner sc = new Scanner(System.in);
        System.out.println("-- Libros hasta un precio especifico --");
        String repetir = "s";
        while (repetir.equalsIgnoreCase("s")){
            if (!DLibro.selectLibros().isEmpty()) {
                int pmax;
                while (true) {
                    System.out.print("Precio maximo: ");
                    try {
                        pmax = Integer.parseInt(sc.nextLine());
                        break;
                    }catch (IllegalArgumentException e){
                        System.out.println("Formato inválido");
                    }
                }

                int finalPmax = pmax;
                ArrayList<Libro> resul = new ArrayList<>(DLibro.selectLibros().stream().filter(a->a.getPrecio()<=finalPmax).toList());

                if (!resul.isEmpty()){
                    System.out.println("-- Resultados --");
                    resul.forEach(System.out::println);
                } else {
                    System.out.println("No se han encontrado resultados");
                }

                System.out.print("¿Quieres repetir esta acción? s/n: ");
                repetir = sc.nextLine();
            } else {
                System.out.println("No hay libros en la tabla libros");
            }
        }
    }

    public static void cantLibros(){
        if (!DLibro.selectLibros().isEmpty()) {
            System.out.println("Hay "+DLibro.selectLibros().size()+" libros en total");
        } else {
            System.out.println("No hay libros en la tabla libros");
        }
    }

    public static void promedioLibros(){
        if (!DLibro.selectLibros().isEmpty()) {
            System.out.println("El precio promedio de los libros es de: "+DLibro.selectLibros().stream().mapToDouble(Libro::getPrecio).average());
        } else {
            System.out.println("No hay libros en la tabla libros");
        }
    }

    public static void eliminarLibro(){
        System.out.println("-- Eliminar libros --");
        Scanner sc = new Scanner(System.in);
        String repetir = "s";
        while (repetir.equalsIgnoreCase("s")){
            if (!DLibro.selectLibros().isEmpty()) {
                int id;
                while (true) {
                    System.out.print("Id de libro: ");
                    try {
                        id = Integer.parseInt(sc.nextLine());
                        int finalId = id;
                        if (DLibro.selectLibros().stream().filter(a->a.getId()==finalId).count()==1) {
                            break;
                        }else {
                            System.out.println("El libro no existe");
                        }
                    }catch (IllegalArgumentException e){
                        System.out.println("Formato inválido");
                    }
                }

                if (DLibro.eliminarLibro(id)){
                    System.out.println("Libro eliminado con exito");
                } else {
                    System.out.println("Operación fallida");
                }

                System.out.print("¿Quieres repetir esta acción? s/n: ");
                repetir = sc.nextLine();
            } else {
                System.out.println("No hay libros en la tabla libros");
            }
        }
    }

    public static void cambiarPrecio(){
        System.out.println("-- Cambiar precios de libros --");
        Scanner sc = new Scanner(System.in);
        String repetir = "s";
        while (repetir.equalsIgnoreCase("s")){
            if (!DLibro.selectLibros().isEmpty()) {
                int id;
                while (true) {
                    System.out.print("Id de libro: ");
                    try {
                        id = Integer.parseInt(sc.nextLine());
                        int finalId = id;
                        if (DLibro.selectLibros().stream().filter(a->a.getId()==finalId).count()==1) {
                            break;
                        }else {
                            System.out.println("El libro no existe");
                        }
                    }catch (IllegalArgumentException e){
                        System.out.println("Formato inválido");
                    }
                }

                Double precio;
                while (true) {
                    System.out.print("Precio: ");
                    try {
                        precio = Double.parseDouble(sc.nextLine());
                        break;
                    }catch (IllegalArgumentException e){
                        System.out.println("Formato inválido");
                    }
                }

                if (DLibro.cambiarPrecio(id, precio)){
                    System.out.println("Precio cambiado con exito");
                } else {
                    System.out.println("Operación fallida");
                }

                System.out.print("¿Quieres repetir esta acción? s/n: ");
                repetir = sc.nextLine();
            } else {
                System.out.println("No hay libros en la tabla libros");
            }
        }
    }
}

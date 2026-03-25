package BBDD.Practica;


import BBDD.Practica.Controlador.CLibro;

import java.sql.SQLException;
import java.util.Scanner;

public class AlonsoPractica {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("""
                    ┌ ¿Que quieres hacer?
                    │ 1 - Ver libros
                    │ 2 - Insertar libro
                    │ 3 - Actualizar precio
                    │ 4 - Eliminar libro
                    │ 5 - Salir
                    └> """);
            String op = sc.nextLine();
            switch (op){
                case "1":
                    CLibro.mostrarLibros();
                    break;
                case "2":
                    CLibro.anadirLibro();
                    break;
                case "3":
                    CLibro.cambiarPrecio();
                    break;
                case "4":
                    CLibro.eliminarLibro();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

}

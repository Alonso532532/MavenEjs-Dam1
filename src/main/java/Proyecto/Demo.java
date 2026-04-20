package Proyecto;

import Proyecto.Coexion.Conexion;
import Proyecto.DAO.DClientes;
import Proyecto.DAO.DUsuarios;
import Proyecto.Modelo.Usuario;
import Proyecto.Vista.Inicio;
import Proyecto.Vista.VAnadir;
import Proyecto.Vista.VVisitas;

import java.sql.SQLException;

public class Demo {
    public static void main(String[] args) {
        try{
            Conexion.conectar();
            System.out.println("Conexión exitosa");
        }catch (SQLException e) {
            e.printStackTrace();
        }

//        DClientes.seleccionarTodo().forEach(System.out::println);
//        if (DClientes.cambiarDni("87878787S", "87878787H")){
//            System.out.println("BIEN");
//        } else {
//            System.out.println("MAL");
//        }
//        DClientes.seleccionarTodo().forEach(System.out::println);

//        CZonas.seleccionarTodo().forEach(System.out::println);
//        System.out.println(CZonas.eliminarPorNumeroDeZona(2));
//        CZonas.seleccionarTodo().forEach(System.out::println);

//        System.out.println(CVisita.anadir("29232320G", 1, "2026-04-11 18:52:33"));
//        CVisita.seleccionarTodo().forEach(System.out::println);

//        Usuario hola = new Usuario("Admin", "Sor2425$", true);
//        System.out.println(hola);
//        if (DUsuarios.buscarPorNombreYContrasena("Admin", "Sor2425$")) System.out.println("Correcto");
        Inicio.ejecutar();
        String[] campos = {"hola", "Pascual", "Y HECPROOLLL"};
        VAnadir.ejecutar(campos, 1);

    }
}

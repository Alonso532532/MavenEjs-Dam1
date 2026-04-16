package Proyecto.Controlador;

import Proyecto.DAO.DClientes;
import Proyecto.Modelo.Clientes;

import java.util.ArrayList;

public final class CClientes {
    public static ArrayList<Clientes> seleccionarTodo(){
        return DClientes.seleccionarTodo();
    }

    // Mediante los datos necesarios para hacer un cliente añado el cliente comprobando los posibles fallos
    public static String anadir(String dni, int edad, String nombre){
        try {

                Clientes cliente = new Clientes(dni, edad, nombre, true);
                DClientes.anadir(cliente);
                return "Cliente introducido con éxito";

        }catch (IllegalArgumentException e){
            // Fallos producidos al intentar insertar datos incorrectos
            // Cuento la cantidad de fallos
            int errores = e.getMessage().split("\n").length;
            if (errores==1){
                return "Ha ocurrido un error con los datos del cliente, causa:\n"+e.getMessage();
            } else {
                return "Han ocurrido "+errores+" errores con los datos del cliente, causas:\n"+e.getMessage();
            }

        }catch (RuntimeException e){
            // Fallos de SQL
            return "Ha ocurrido un error en la introducción del cliente, causa:\n"+e.getMessage();
        }
    }

    // Mediante el DNI elimino un cliente comprobando los posibles fallos
    public static String eliminarPorDni(String dni){
        try {

            if (DClientes.eliminarPorDni(dni)) {
                return "Cliente eliminado con éxito";
            } else {
                return "Ha ocurrido un error con los datos del cliente, causa:\nEl dni no existe\n";
            }

        }catch (RuntimeException e){
            // Fallos de SQL
            return "Ha ocurrido un error en la introducción del cliente, causa:\n"+e.getMessage();
        }
    }
}

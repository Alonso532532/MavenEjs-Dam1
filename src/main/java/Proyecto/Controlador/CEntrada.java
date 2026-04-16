package Proyecto.Controlador;

import Proyecto.DAO.DAtracciones;
import Proyecto.DAO.DEntrada;
import Proyecto.Modelo.Atracciones;
import Proyecto.Modelo.Entrada;

import java.util.ArrayList;

public final class CEntrada {
    public static ArrayList<Entrada> seleccionarTodo(){
        return DEntrada.seleccionarTodo();
    }

    // Mediante los datos necesarios para hacer una entrada añado la entrada comprobando los posibles fallos
    public static String anadir(String tipo, double precio, String dni){
        try {

            Entrada entrada = new Entrada(tipo, precio, dni);
            DEntrada.anadir(entrada);
            return "Entrada introducida con éxito";

        }catch (IllegalArgumentException e){
            // Fallos producidos al intentar insertar datos incorrectos
            // Cuento la cantidad de fallos
            int errores = e.getMessage().split("\n").length;
            if (errores==1){
                return "Ha ocurrido un error con los datos de la entrada, causa:\n"+e.getMessage();
            } else {
                return "Han ocurrido "+errores+" errores con los datos de la entrada, causas:\n"+e.getMessage();
            }

        }catch (RuntimeException e){
            // Fallos de SQL
            return "Ha ocurrido un error en la introducción de la entrada, causa:\n"+e.getMessage();
        }
    }

    // Mediante el número de entrada elimino una entrada comprobando los posibles fallos
    public static String eliminarPorNumeroDeEntrada(int numeroDeEntrada){
        try {

            if (DEntrada.eliminarPorNumero(numeroDeEntrada)) {
                return "Entrada eliminada con éxito";
            } else {
                return "Ha ocurrido un error con los datos de la entrada, causa:\nEl numero de entrada no existe\n";
            }

        }catch (RuntimeException e){
            // Fallos de SQL
            return "Ha ocurrido un error en la introducción de la entrada, causa:\n"+e.getMessage();
        }
    }
}

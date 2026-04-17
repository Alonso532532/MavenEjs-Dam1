package Proyecto.Controlador;

import Proyecto.DAO.DVisita;
import Proyecto.Modelo.Visita;

import java.util.ArrayList;

public final class CVisita {

    public static ArrayList<Visita> seleccionarTodo(){
        return DVisita.seleccionarTodo();
    }

    // Mediante los datos necesarios para hacer una visita añado la visita comprobando los posibles fallos
    public static String anadir(String dni, int numeroDeZona, String fecha){
        try {

            Visita visita = new Visita(dni, numeroDeZona, fecha, true);
            DVisita.anadir(visita);
            return "Visita introducida con éxito";

        }catch (IllegalArgumentException e){
            // Fallos producidos al intentar insertar datos incorrectos
            // Cuento la cantidad de fallos
            int errores = e.getMessage().split("\n").length;
            if (errores==1){
                return "Ha ocurrido un error con los datos de la visita, causa:\n"+e.getMessage();
            } else {
                return "Han ocurrido "+errores+" errores con los datos de la visita, causas:\n"+e.getMessage();
            }

        }catch (RuntimeException e){
            // Fallos de SQL
            e.printStackTrace();
            return "Ha ocurrido un error en la introducción de la visita, causa:\n"+e.getMessage();
        }
    }

    // Mediante el conjunto de dni y número de zona elimino una visita comprobando los posibles fallos
    public static String eliminarPorClave(String dni, int numeroDeZona, String fecha){
        try {

            if (DVisita.eliminarPorClave(dni, numeroDeZona, fecha)) {
                return "Visita eliminada con éxito";
            } else {
                return "Ha ocurrido un error con los datos de la visita, causa:\nEl conjunto de dni y número de zona no existen\n";
            }

        }catch (RuntimeException e){
            // Fallos de SQL
            return "Ha ocurrido un error en la introducción de la visita, causa:\n"+e.getMessage();
        }
    }
}

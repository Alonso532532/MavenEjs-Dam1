package Proyecto.Controlador;

import Proyecto.Coexion.Conexion;
import Proyecto.DAO.DAtracciones;
import Proyecto.DAO.DVisita;
import Proyecto.Modelo.Atracciones;
import Proyecto.Modelo.Visita;


import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public final class CAtracciones {
    public static ArrayList<Atracciones> seleccionarTodo(){
        return DAtracciones.seleccionarTodo();
    }

    public static ArrayList<Atracciones> seleccionarPorNumeroDeZona(int numeroDeZona){
        return DAtracciones.seleccionarPorNumeroDeZona(numeroDeZona);
    }

    // Mediante los datos necesarios para hacer una atracción añado la atracción comprobando los posibles fallos
    public static String anadir(Atracciones atraccion){
        try {

            DAtracciones.anadir(atraccion);
            return "Atracción introducida con éxito";

        }catch (IllegalArgumentException e){
            // Fallos producidos al intentar insertar datos incorrectos
            // Cuento la cantidad de fallos
            int errores = e.getMessage().split("\n").length;
            if (errores==1){
                return "Ha ocurrido un error con los datos de la atracción, causa:\n"+e.getMessage();
            } else {
                return "Han ocurrido "+errores+" errores con los datos de la atracción, causas:\n"+e.getMessage();
            }

        }catch (RuntimeException e){
            // Fallos de SQL
            return "Ha ocurrido un error en la introducción de la atracción, causa:\n"+e.getMessage();
        }
    }



    // Mediante el número de atracción elimino una atracción comprobando los posibles fallos
    public static String eliminarPorNumeroDeAtraccion(int numeroDeAtraccion){
        try {

            if (DAtracciones.eliminarPorNumero(numeroDeAtraccion)) {
                return "Atracción eliminada con éxito";
            } else {
                return "Ha ocurrido un error con los datos de la atracción, causa:\nEl numero de atracción no existe\n";
            }

        }catch (RuntimeException e){
            // Fallos de SQL
            return "Ha ocurrido un error en la introducción de la atracción, causa:\n"+e.getMessage();
        }
    }

    // Mediante el número de zona elimino las atracciones relacionadas comprobando los posibles fallos
    public static String eliminarPorNumeroDeZona(int numeroDeZona){
        try {

            if (DAtracciones.eliminarPorNumeroDeZona(numeroDeZona)) {
                return "Atracciones eliminadas con éxito";
            } else {
                return "Ha ocurrido un error con los datos de la atraccion, causa:\nEl numero de zona no existe\n";
            }

        }catch (RuntimeException e){
            // Fallos de SQL
            return "Ha ocurrido un error en la introducción de la atraccion, causa:\n"+e.getMessage();
        }
    }

    // Modifico los valores mediante la clave
    public static String modificar(int numeroDeAtraccion, Atracciones atraccion, Atracciones atraccionNueva){

        if (!atraccion.getNombre().equals(atraccionNueva.getNombre())){
            DAtracciones.cambiarNombre(numeroDeAtraccion, atraccionNueva.getNombre());
        }
        if (!(atraccion.getNumeroDeZona()==atraccionNueva.getNumeroDeZona())){
            DAtracciones.cambiarNumeroDeZona(numeroDeAtraccion, atraccionNueva.getNumeroDeZona());
        }
        return "Nombre y numero de zona modificados con éxito";

    }
}

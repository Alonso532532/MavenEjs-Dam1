package Proyecto.Controlador;

import Proyecto.DAO.DEntrada;
import Proyecto.DAO.DUsuarios;
import Proyecto.Modelo.Entrada;
import Proyecto.Modelo.Usuario;

public final class CUsuarios {
    public static boolean comprobarInicioDeSesion(Usuario usuario){
        return DUsuarios.buscarPorNombreYContrasena(usuario.getNombre(), usuario.getContrasena());
    }

    public static String anadir(String nombre, String contrasena, boolean admin){
        try {

            Usuario usuario = new Usuario(nombre, contrasena, admin, true);
            DUsuarios.anadir(usuario);
            return "Usuario introducido con éxito";

        }catch (IllegalArgumentException e){
            // Fallos producidos al intentar insertar datos incorrectos
            return "Han ocurrido errores con los datos de la entrada, causa:\n"+e.getMessage();

        }catch (RuntimeException e){
            // Fallos de SQL
            return "Ha ocurrido un error en la introducción de la entrada, causa:\n"+e.getMessage();
        }
    }
}

package Proyecto.Controlador;

import Proyecto.DAO.DUsuarios;
import Proyecto.Modelo.Usuario;

public final class CUsuarios {
    public static boolean comprobarInicioDeSesion(Usuario usuario){
        return DUsuarios.buscarPorNombreYContrasena(usuario.getNombre(), usuario.getContrasena());
    }
}

package Proyecto.Modelo;

import Proyecto.DAO.DClientes;
import Proyecto.DAO.DZonas;

public class Visita {
    private String dni;
    private int numeroDeZona;

    public Visita(String dni, int numeroDeZona, boolean comprobarConcurrencia) {
        String error = "";
        // Para evitar el problema de claves primarias duplicadas permito que al llamar al constructor tenga la opción de comprobar o no,
        // porque si compruebo siempre no puedo crear un objeto al seleccionar datos de la tabla, ya que siempre que seleccione una fila
        // esa clave primaria ya va a existir impidiéndome crear un objeto a raíz de esos datos
        if (comprobarConcurrencia){
            if (DClientes.comprobarPorDni(dni) && DZonas.comprobarNumeroDeZona(numeroDeZona)) error+="La visita ya existe\n";
        }
        if (!setDni(dni)) error+="El DNI es inexistente\n";
        if (!setNumeroDeZona(numeroDeZona)) error+="El numero de zona es inexistente\n";
        if (!error.isEmpty()) throw new IllegalArgumentException(error);
    }

    public String getDni() {
        return dni;
    }

    public boolean setDni(String dni) {
        if (DClientes.comprobarPorDni(dni)){
            this.dni = dni;
            return true;
        }
        return false;
    }

    public int getNumeroDeZona() {
        return numeroDeZona;
    }

    public boolean setNumeroDeZona(int numeroDeZona) {
        if (DZonas.comprobarNumeroDeZona(numeroDeZona)) {
            this.numeroDeZona = numeroDeZona;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Visita{" +
                "dni='" + dni + '\'' +
                ", numeroDeZona=" + numeroDeZona +
                '}';
    }
}

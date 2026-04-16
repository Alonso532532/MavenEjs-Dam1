package Proyecto.Modelo;

import Proyecto.DAO.DZonas;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Atracciones {
    private int numeroDeAtraccion;
    private String nombre;
    private int numeroDeZona;

    public Atracciones(int numeroDeAtraccion, String nombre, int numeroDeZona) {
        this.numeroDeAtraccion = numeroDeAtraccion;
        this.nombre = nombre;
        this.numeroDeZona = numeroDeZona;
    }

    public Atracciones(String nombre, int numeroDeZona) {
        String error = "";
        if (!setNombre(nombre)) error+="Nombre invalido\n";
        if (!setNumeroDeZona(numeroDeZona)) error+="Numero de zona inexistente\n";
        if (!error.isEmpty()) throw new IllegalArgumentException(error);
    }

    public int getNumeroDeAtraccion() {
        return numeroDeAtraccion;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean setNombre(String nombre) {
        Matcher matcher = Pattern.compile("[\\w ]{1,50}").matcher(nombre);
        if (matcher.matches()){
            this.nombre = nombre;
            return true;
        }
        return false;
    }

    public int getNumeroDeZona() {
        return numeroDeZona;
    }

    public boolean setNumeroDeZona(int numeroDeZona) {
        if (DZonas.comprobarNumeroDeZona(numeroDeZona)){
            this.numeroDeZona = numeroDeZona;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Atracciones{" +
                "numeroDeAtraccion=" + numeroDeAtraccion +
                ", nombre='" + nombre + '\'' +
                ", numeroDeZona=" + numeroDeZona +
                '}';
    }
}

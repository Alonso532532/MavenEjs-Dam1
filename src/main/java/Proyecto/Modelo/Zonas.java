package Proyecto.Modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zonas {
    private int numeroDeZona;
    private String nombre;

    public Zonas(int numeroDeZona, String nombre) {
        String error = "";
        this.numeroDeZona = numeroDeZona;
        if (setNombre(nombre)) error = "Nombre invalido";
        if (!error.isEmpty()) throw new IllegalArgumentException(error);
    }

    public Zonas(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroDeZona() {
        return numeroDeZona;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean setNombre(String nombre) {
        Matcher matcher = Pattern.compile("\\w{1,50}").matcher(nombre);
        if (matcher.matches()){
            this.nombre = nombre;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Zonas{" +
                "numeroDeZona=" + numeroDeZona +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

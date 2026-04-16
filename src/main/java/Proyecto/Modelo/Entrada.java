package Proyecto.Modelo;

import Proyecto.DAO.DClientes;
import Proyecto.DAO.DEntrada;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Entrada {
    private int numeroDeEntrada;
    private String tipo;
    private double precio = 0;
    private String dni;

    public Entrada(int numeroDeEntrada, String tipo, double precio, String dni) {
        this.numeroDeEntrada = numeroDeEntrada;
        this.tipo = tipo;
        this.precio = precio;
        this.dni = dni;
    }

    public Entrada(String tipo, double precio, String dni) {
        String error = "";
        if (!setTipo(tipo)) error+="Tipo de entrada incorrecto\n";
        if (!setPrecio(precio)) error+="Precio incorrecto\n";
        if (!setDni(dni)) error+="DNI incorrecto\n";
        if (!error.isEmpty()) throw new IllegalArgumentException(error);
    }

    public int getNumeroDeEntrada() {
        return numeroDeEntrada;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean setTipo(String tipo) {
        Matcher matcher = Pattern.compile("Oferta|Normal|Familia numerosa").matcher(tipo);
        if (matcher.matches()){
            this.tipo = tipo;
            return true;
        }
        return false;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean setPrecio(double precio) {
        if (precio>=0){
            this.precio = precio;
            return true;
        }
        return false;
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

    @Override
    public String toString() {
        return "Entrada{" +
                "numeroDeEntrada=" + numeroDeEntrada +
                ", tipo='" + tipo + '\'' +
                ", precio=" + precio +
                ", dni='" + dni + '\'' +
                '}';
    }
}

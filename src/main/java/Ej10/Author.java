package Ej10;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;

public class Author {
    private String nombre;
    private ArrayList<Libro> librosEscritos;

    public Author(String nombre, ArrayList<Libro> librosEscritos) {
        this.nombre = nombre;
        this.librosEscritos = librosEscritos;
    }

    public Author() {
        librosEscritos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    @JsonIgnore
    public ArrayList<Libro> getLibrosEscritos() {
        return librosEscritos;
    }

    public void setLibrosEscritos(ArrayList<Libro> librosEscritos) {
        this.librosEscritos = librosEscritos;
    }

    @Override
    public String toString() {
        return "Author{" +
                "nombre='" + nombre + "\'}";

    }
}

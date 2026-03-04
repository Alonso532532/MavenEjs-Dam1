package Ej7y8;

import Ej1.Book;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "Autor")
public class Author {
    private String nombre;
    private ArrayList<Book> librosEscritos;

    public Author(String nombre, ArrayList<Book> librosEscritos) {
        this.nombre = nombre;
        this.librosEscritos = librosEscritos;
    }

    public Author() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement(name = "LibrosEscritos")
    public ArrayList<Book> getLibrosEscritos() {
        return librosEscritos;
    }

    public void setLibrosEscritos(ArrayList<Book> librosEscritos) {
        this.librosEscritos = librosEscritos;
    }
}

package Ej7;

import Ej1.Book;

import java.util.ArrayList;
import java.util.Arrays;

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

    public ArrayList<Book> getLibrosEscritos() {
        return librosEscritos;
    }

    public void setLibrosEscritos(ArrayList<Book> librosEscritos) {
        this.librosEscritos = librosEscritos;
    }
}

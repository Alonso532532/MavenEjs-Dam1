package Ej3;

import Ej1.Book;

import java.util.ArrayList;

public class Library {
    ArrayList<Book> libros;

    public Library(ArrayList<Book> libros) {
        this.libros = libros;
    }

    public Library() {
        libros = new ArrayList<>();
    }

    public ArrayList<Book> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Book> libros) {
        this.libros = libros;
    }
}

package Ej7y8;

import Ej1.Book;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "TiendaLibros")
public class TiendaLibros {
    private ArrayList<Author> autores;
    private ArrayList<Book> libros;

    public TiendaLibros() {
        autores = new ArrayList<>();
        libros = new ArrayList<>();
    }

    public TiendaLibros(ArrayList<Author> autores, ArrayList<Book> libros) {
        this.autores = autores;
        this.libros = libros;
    }

    @XmlElement(name = "Autor")
    public ArrayList<Author> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Author> autores) {
        this.autores = autores;
    }

    @XmlElement(name = "LibroTienda")
    public ArrayList<Book> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Book> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "TiendaLibros{" +
                "autores=" + autores +
                ", libros=" + libros +
                '}';
    }
}

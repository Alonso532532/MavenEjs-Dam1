package xml5y6;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "Biblioteca")
public class Biblioteca {
    ArrayList<Libro> biblioteca;

    public Biblioteca() {
        biblioteca = new ArrayList<>();
    }

    public Biblioteca(ArrayList<Libro> biblioteca) {
        this.biblioteca = biblioteca;
    }

    public ArrayList<Libro> getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(ArrayList<Libro> biblioteca) {
        this.biblioteca = biblioteca;
    }
}

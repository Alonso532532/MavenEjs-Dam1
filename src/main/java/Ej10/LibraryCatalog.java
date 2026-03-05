package Ej10;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement(name = "Catálogo")
public class LibraryCatalog {
    private HashMap<Author, Libro> catalogo;

    public LibraryCatalog() {
        catalogo = new HashMap<>();
    }

    public LibraryCatalog(HashMap<Author, Libro> catalogo) {
        this.catalogo = catalogo;
    }

    public Map<Author, Libro> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(HashMap<Author, Libro> catalogo) {
        this.catalogo = catalogo;
    }
}
package Ej10;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement(name = "Catalogos")
public class LibraryCatalog {
    private HashMap<Author, Libro> catalogo;

    public LibraryCatalog() {
        catalogo = new HashMap<>();
    }

    public LibraryCatalog(HashMap<Author, Libro> catalogo) {
        this.catalogo = catalogo;
    }

    @XmlElement
    public Map<Author, Libro> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(HashMap<Author, Libro> catalogo) {
        this.catalogo = catalogo;
    }

    @Override
    public String toString() {
        return "LibraryCatalog{" +
                "catalogo=" + catalogo +
                '}';
    }
}
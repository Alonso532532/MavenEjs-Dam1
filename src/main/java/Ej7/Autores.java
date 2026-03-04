package Ej7;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "Autores")
public class Autores {
    private ArrayList autores;

    public Autores() {
        autores = new ArrayList<>();
    }

    public Autores(ArrayList autores) {
        this.autores = autores;
    }

    @XmlElement(name = "Autor")
    public ArrayList getAutores() {
        return autores;
    }

    public void setAutores(ArrayList autores) {
        this.autores = autores;
    }
}

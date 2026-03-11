package Breva;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedHashMap;

@XmlRootElement
public class Serializar {
    private LinkedHashMap<Integer, Estudiante> mapa;

    public Serializar() {
        mapa = new LinkedHashMap<>();
    }

    public Serializar(LinkedHashMap<Integer, Estudiante> mapa) {
        this.mapa = mapa;
    }

    public LinkedHashMap<Integer, Estudiante> getMapa() {
        return mapa;
    }

    public void setMapa(LinkedHashMap<Integer, Estudiante> mapa) {
        this.mapa = mapa;
    }
}

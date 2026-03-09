package Dados;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "Exito")
public class Exitos {
    private ArrayList<ArrayList<Jugador>> jugadores;
    public Exitos() {
        jugadores = new ArrayList<>();
    }

    public Exitos(ArrayList<ArrayList<Jugador>> jugadores) {
        this.jugadores = jugadores;
    }
    @XmlElement
    public ArrayList<ArrayList<Jugador>> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<ArrayList<Jugador>> jugadores) {
        this.jugadores = jugadores;
    }

    @Override
    public String toString() {
        return "Exitos{" +
                "jugadores=" + jugadores +
                '}';
    }
}

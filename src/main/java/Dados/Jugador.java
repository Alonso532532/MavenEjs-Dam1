package Dados;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Jugador {
    private String nombre;
    private int valor;
    private int tiradas = 0;
    private int turno;
    static int tirada = 0;

    public Jugador() {
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public int getTiradas() {
        return tiradas;
    }

    public int getTurno() {
        return turno;
    }

    void tirarDado(){
        valor = (int) (Math.random()*6+1);
        tiradas++;
        turno=++tirada;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", valor=" + valor +
                ", tiradas=" + tiradas +
                ", turno=" + turno +
                '}';
    }
}

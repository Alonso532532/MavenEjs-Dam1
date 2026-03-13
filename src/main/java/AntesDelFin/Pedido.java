package AntesDelFin;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Pedido {
    private ArrayList<String> cosas;
    private int precio;
    private String comprador;

    public Pedido() {
        cosas = new ArrayList<>();
    }

    public Pedido(ArrayList<String> cosas, int precio, String comprador) {
        this.cosas = cosas;
        this.precio = precio;
        this.comprador = comprador;
    }

    public ArrayList<String> getCosas() {
        return cosas;
    }

    public void setCosas(ArrayList<String> cosas) {
        this.cosas = cosas;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "cosas=" + cosas +
                ", precio=" + precio +
                ", comprador='" + comprador + '\'' +
                '}';
    }
}

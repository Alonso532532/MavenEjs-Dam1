package xml;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Libro {
    String titulo;
    double precio;
    int existencias;

    public Libro() {
    }

    public Libro(String titulo, double precio, int existencias) {
        this.titulo = titulo;
        this.precio = precio;
        this.existencias = existencias;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }
}

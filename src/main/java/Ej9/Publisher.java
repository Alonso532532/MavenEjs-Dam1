package Ej9;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "Publisher")
public class Publisher {
    private String nombre;
    private String direccion;
    private ArrayList<Libro> libros;

    public Publisher() {
    }

    public Publisher(String nombre, String direccion, ArrayList<Libro> libros) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.libros = libros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @XmlElement(name = "Libro")
    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", libros=" + libros +
                '}';
    }
}

package Breva;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Estudiante {
    private int id;
    private String nombre;
    private int edad;
    private String contraseña;

    public Estudiante() {
    }

    public Estudiante(int id, String nombre, int edad, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.contraseña = contraseña;
    }

    public Estudiante(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @JsonIgnore
    @XmlTransient
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }
}


package NOHAYINTERNET;

public class Persona {
    private String nombre;
    private int id;
    private static int idinc=0;

    public Persona() {
        idinc++;
    }

    public Persona(String nombre) {
        this();
        this.nombre = nombre;
        this.id = idinc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                '}';
    }
}

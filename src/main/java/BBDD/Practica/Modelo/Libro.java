package BBDD.Practica.Modelo;

public class Libro {
    private int id;
    private String titulo;
    private Double precio;
    private int id_autor;

    public Libro(String titulo, Double precio, int id_autor) {
        this.titulo = titulo;
        this.precio = precio;
        this.id_autor = id_autor;
    }

    public Libro(int id, String titulo, Double precio, int id_autor) {
        this.id = id;
        this.titulo = titulo;
        this.precio = precio;
        this.id_autor = id_autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", precio=" + precio +
                ", id_autor=" + id_autor +
                '}';
    }
}

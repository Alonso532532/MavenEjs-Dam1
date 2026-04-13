package Proyecto.Modelo;

public class Visita {
    private String dni;
    private int numeroDeZona;

    public Visita(String dni, int numeroDeZona) {
        this.dni = dni;
        this.numeroDeZona = numeroDeZona;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getNumeroDeZona() {
        return numeroDeZona;
    }

    public void setNumeroDeZona(int numeroDeZona) {
        this.numeroDeZona = numeroDeZona;
    }

    @Override
    public String toString() {
        return "Visita{" +
                "dni='" + dni + '\'' +
                ", numeroDeZona=" + numeroDeZona +
                '}';
    }
}

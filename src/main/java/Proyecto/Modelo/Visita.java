package Proyecto.Modelo;

public class Visita {
    private int dni;
    private int numeroDeZona;

    public Visita(int dni, int numeroDeZona) {
        this.dni = dni;
        this.numeroDeZona = numeroDeZona;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
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
                "dni=" + dni +
                ", numeroDeZona=" + numeroDeZona +
                '}';
    }
}

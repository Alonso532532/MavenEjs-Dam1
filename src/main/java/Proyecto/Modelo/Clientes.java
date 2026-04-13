package Proyecto.Modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Clientes {
    private String dni;
    private int edad;
    private String nombre;

    public Clientes(String dni, int edad, String nombre) {
        String error = "";
        if (!setDni(dni)) error="El dni es incorrecto\n";
        if (!setEdad(edad)) error=error+"La edad es incorrecta\n";
        if (!setNombre(nombre)) error=error+"El nombre es demasiado largo o contiene carácteres no permitidos\n";
        if (!error.isEmpty()) throw new IllegalArgumentException(error);
    }

    public String getDni() {
        return dni;
    }

    public boolean setDni(String dni) {
        Matcher matcher = Pattern.compile("\\d{8}\\w").matcher(dni);
        if (matcher.matches()){
            this.dni = dni;
            return true;
        }
        return false;
    }

    public int getEdad() {
        return edad;
    }

    public boolean setEdad(int edad) {
        if (edad<=130 && edad > 0){
            this.edad = edad;
            return true;
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean setNombre(String nombre) {
        Matcher matcher = Pattern.compile("[A-Za-zñáéíóúÁÉÍÓÚ ]{1,50}").matcher(nombre);
        if (matcher.matches()){
            this.nombre = nombre;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "dni='" + dni + '\'' +
                ", edad=" + edad +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

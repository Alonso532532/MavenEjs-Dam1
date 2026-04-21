package Proyecto.Modelo;

import Proyecto.DAO.DClientes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Clientes {
    private String dni;
    private int edad;
    private String nombre;

    public Clientes(String dni, int edad, String nombre, boolean comprobarConcurrencia) {
        String error = "";
        // Para evitar el problema de claves primarias duplicadas permito que al llamar al constructor tenga la opción de comprobar o no,
        // porque si compruebo siempre no puedo crear un objeto al seleccionar datos de la tabla, ya que siempre que seleccione una fila
        // esa clave primaria ya va a existir impidiéndome crear un objeto a raíz de esos datos
        if (comprobarConcurrencia){
            if (DClientes.comprobarPorDni(dni)) error+="El dni ya existe\n";
        }
        if (!setDni(dni)) error+="El dni es incorrecto\n";
        if (!setEdad(edad)) error+="La edad es incorrecta\n";
        if (!setNombre(nombre)) error+="El nombre es demasiado largo/corto o contiene carácteres no permitidos\n";
        if (!error.isEmpty()) throw new IllegalArgumentException(error);
    }

    public String getDni() {
        return dni;
    }

    public boolean setDni(String dni) {
        Matcher matcher = Pattern.compile("\\d{8}[A-Za-zñ]").matcher(dni);
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

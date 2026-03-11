package NOHAYINTERNET;

import java.util.ArrayList;

public class Personas {
    private ArrayList<Persona> personas;

    public Personas() {
        personas = new ArrayList<>();
    }

    public Personas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }
}

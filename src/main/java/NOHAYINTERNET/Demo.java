package NOHAYINTERNET;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {

        Personas personas = new Personas();
        Scanner sc = new Scanner(System.in);
        int op = 1;
        while (op != 0){
            while (true) {
                try {
                    System.out.print(personas.getPersonas()+"\n|¿Que quieres hacer?\n|0-Salir\n|1-Añadir\n|2-Cargar\n|3-Guardar\n> ");
                    op = Integer.parseInt(sc.nextLine());
                    if (op > 3 || op < 0) {
                        System.out.println("Opción incorrecta");
                    } else {
                        break;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Opción incorrecta");
                }
            }
            ObjectMapper objectMapper = new ObjectMapper();
            switch (op){
                case 1:
                    System.out.print("Nombre: ");
                    String resp = sc.nextLine();
                    personas.getPersonas().add(new Persona(resp));
                    break;
                case 2:
                    try {
                        personas = objectMapper.readValue(new File("src/main/java/NOHAYINTERNET/Ser1.json"), Personas.class);
                    } catch (JsonMappingException e) {
                        throw new RuntimeException(e);
                    } catch (JsonParseException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:

                    try {
                        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/java/NOHAYINTERNET/Ser1.json"), personas);
                    } catch (JsonMappingException e) {
                        throw new RuntimeException(e);
                    } catch (JsonGenerationException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }
        }
    }
}

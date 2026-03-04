package Ej7;

import Ej1.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        Autores autores = new Autores(new ArrayList(Arrays.asList(new Author("Pascual", new ArrayList<>(Arrays.asList(new Book("Ya vale", "Pascual", 2007), new Book("IKEEER", "Pascual", 2008)))), new Author("Juanma", new ArrayList<>(Arrays.asList(new Book("Packet tracer", "Juanma", 2004), new Book("Grajes y pulpos", "Juanma", 2009)))))));
        //Para json
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("src/main/java/Ej7/Autores.json"), autores);
            // DES
            Autores resultado = objectMapper.readValue(new File("src/main/java/Ej7/Autores.json"), Autores.class);
            resultado.getAutores().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Para xml
    }
}

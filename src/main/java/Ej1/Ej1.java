package Ej1;

import Ej3.Library;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Ej1 {
    public static void main(String[] args) {
        Book pascuals = new Book("Pascuals", "Pascual", 2007);
        Book juanma = new Book("Grajes y pulpos", "Juanmanuel", 2005);
        Library biblioteca = new Library(new ArrayList<>(Arrays.asList(pascuals, juanma)));


        ObjectMapper objectMapper = new ObjectMapper();
        try {

            objectMapper.writeValue(new File("src/main/java/Ej1/Resultado.json"), biblioteca);

        } catch (IOException e){

            e.printStackTrace();

        }
    }
}

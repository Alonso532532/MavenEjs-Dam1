package Ej2;

import Ej1.Book;
import Ej3.Library;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Ej2 {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try  {

            Library biblioteca = objectMapper.readValue(new File("src/main/java/Ej1/Resultado.json"), Library.class);
            biblioteca.getLibros().forEach(System.out::println);

        } catch (IOException e){

            e.printStackTrace();

        }
    }
}

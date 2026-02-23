package Ej2;

import Ej1.Book;
import Ej3.Library;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ej2 {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        Library biblioteca = new Library();

        try (BufferedReader leer = new BufferedReader( new FileReader("src/main/java/Ej1/Resultado.json"))) {

            String linea;
            while ((linea = leer.readLine()) != null){
                Book libro = objectMapper.readValue(linea, Book.class);
                System.out.println(libro.getTitle());
            }

        } catch (Exception e){

            e.printStackTrace();

        }
    }
}

package Ej4;

import Ej1.Book;
import Ej3.Library;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ej4 {
    public static void main(String[] args) {
        try (BufferedReader leer = new BufferedReader(new FileReader("src/main/java/Ej3/Resultado.json"))) {

            ObjectMapper objectMapper = new ObjectMapper();
            String linea;
            while ((linea = leer.readLine()) != null){
                Library biblioteca = objectMapper.readValue(linea, Library.class);
                for (Book i: biblioteca.getLibros()){
                    System.out.println(i.getTitle());
                }
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

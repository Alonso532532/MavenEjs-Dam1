package Ej3;

import Ej1.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Ej3 {
    public static void main(String[] args) {
        Book libro1 = new Book("Hec", "proll", 1992);
        Book libro2 = new Book("La breva", "Juanma", 1982);
        Book libro3 = new Book("El gran VALE", "Pascual", 1292);
        Book libro4 = new Book("La caida del CPD", "Juanma", 2003);
        Library biblioteca = new Library(new  ArrayList<>(Arrays.asList(libro1, libro2)));
        Library biblioteca2 = new Library(new  ArrayList<>(Arrays.asList(libro3, libro4)));
        try (BufferedWriter escribir = new BufferedWriter(new FileWriter("src/main/java/Ej3/Resultado.json"))) {
            ObjectMapper objectMapper = new ObjectMapper();
            String resp = objectMapper.writeValueAsString(biblioteca);
            String resp2 = objectMapper.writeValueAsString(biblioteca2);
            System.out.println(resp);
            System.out.println(resp2);
            escribir.write(resp);
            escribir.newLine();
            escribir.write(resp2);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

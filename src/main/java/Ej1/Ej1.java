package Ej1;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ej1 {
    public static void main(String[] args) {
        Book pascuals = new Book("Pascuals", "Pascual", 2007);
        Book juanma = new Book("Grajes y pulpos", "Juanmanuel", 2005);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String resp1 = objectMapper.writeValueAsString(pascuals) + "\n";
            String resp2 = objectMapper.writeValueAsString(juanma) + "\n";
            System.out.print(resp1);
            System.out.print(resp2);

            try (BufferedWriter escribir = new BufferedWriter( new FileWriter("src/main/java/Ej1/Resultado.json"))){
                escribir.write(resp1);
                escribir.write(resp2);
            } catch (IOException e){
                e.printStackTrace();
            }

        } catch (Exception e){

            e.printStackTrace();

        }
    }
}

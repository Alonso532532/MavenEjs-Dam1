package xml;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class pruebaBasico {
    public static void main(String[] args) {
        Libro libro1 = new Libro("cuento1", 20.3, 4);
        Libro libro2 = new Libro("cuento2", 26, 2);
        Libro libro3 = new Libro("cuento3", 21.3, 16);
        ArrayList<Libro> libros = new ArrayList<>(Arrays.asList(libro1, libro2, libro3));
        Biblioteca biblioteca = new Biblioteca(libros);
        // Serializo en xml
        try {
            JAXBContext context = JAXBContext.newInstance(Biblioteca.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(biblioteca, new File("src/main/java/xml/Registros.xml"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Serializado en json
        try (BufferedWriter escribir = new BufferedWriter(new FileWriter("src/main/java/xml/Registro.json"))){
            ObjectMapper objectMapper = new ObjectMapper();
            for (Libro i: biblioteca.getBiblioteca()){
                escribir.write(objectMapper.writeValueAsString(i)+"\n");
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        try (BufferedReader leer = new BufferedReader(new FileReader("src/main/java/xml/Registro.json"))) {
            String linea;
            while ((linea = leer.readLine()) != null) {
                ObjectMapper objectMapper = new ObjectMapper();
                Libro libro = objectMapper.readValue(linea, Libro.class);
                System.out.println(libro);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        // Deserializado en xml
        try {
            JAXBContext context = JAXBContext.newInstance(Biblioteca.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            Biblioteca result = (Biblioteca) unmarshaller.unmarshal(new File("src/main/java/xml/Registros.xml"));
            System.out.println(result.getBiblioteca().get(0).getTitulo());

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}

package xml5y6;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
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

        // Serializo en xml y deserializo


        try {

            JAXBContext context = JAXBContext.newInstance(Biblioteca.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal( biblioteca, new File("src/main/java/xml5y6/Registros.xml"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {

            JAXBContext context = JAXBContext.newInstance(Biblioteca.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Biblioteca resul = (Biblioteca) unmarshaller.unmarshal(new File("src/main/java/xml5y6/Registros.xml"));
            System.out.println(resul);

        } catch (Exception e){
            e.printStackTrace();
        }

        // Serializado en json y deserializo
        ObjectMapper objectMapper = new ObjectMapper();

        try {

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/java/xml5y6/Registro.json"), biblioteca);

        } catch (IOException e){
            e.printStackTrace();
        }

        try {

            Biblioteca resul = objectMapper.readValue(new File("src/main/java/xml5y6/Registro.json"), biblioteca.getClass());
            System.out.println(resul);

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

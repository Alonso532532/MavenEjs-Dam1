package Ej7y8;

import Ej1.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import xml5y6.Biblioteca;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        TiendaLibros tienda = new TiendaLibros(new ArrayList(Arrays.asList(new Author("Pascual", new ArrayList<>(Arrays.asList(new Book("Ya vale", "Pascual", 2007), new Book("IKEEER", "Pascual", 2008)))), new Author("Juanma", new ArrayList<>(Arrays.asList(new Book("Packet tracer", "Juanma", 2004), new Book("Grajes y pulpos", "Juanma", 2009)))))), new ArrayList<>(Arrays.asList(new Book("Grajes y pulpos", "Juanma", 2009), new Book("Packet tracer", "Juanma", 2004), new Book("Ya vale", "Pascual", 2007), new Book("IKEEER", "Pascual", 2008))));

        //Para json
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Serializo
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/java/Ej7y8/Autores.json"), tienda);
            // Des serializo
            TiendaLibros resultado = objectMapper.readValue(new File("src/main/java/Ej7y8/Autores.json"), TiendaLibros.class);
            resultado.getAutores().stream().map(Author::getNombre).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Para xml
        try {

            // Serializo
            JAXBContext context = JAXBContext.newInstance(TiendaLibros.class);
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(tienda, new File("src/main/java/Ej7y8/TiendaLibros.xml"));

            // Deserializo
            Unmarshaller unmarshaller = context.createUnmarshaller();

            TiendaLibros resultado = (TiendaLibros) unmarshaller.unmarshal(new File("src/main/java/Ej7y8/TiendaLibros.xml"));
            ArrayList<Author> autores = new ArrayList<>(resultado.getAutores());
            autores.stream().map(Author::getNombre).forEach(System.out::println);

        } catch (Exception e){
            e.printStackTrace();
        }





    }
}

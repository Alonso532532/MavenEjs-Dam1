package Ej10;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Demo {
    public static void main(String[] args) {
        HashMap<Author, Libro> mapa = new HashMap<>();
        mapa.put(new Author("Juanma", new ArrayList<>(Arrays.asList(new Libro("breva", "Juanma", 2007)))), new Libro("Breva", "Juanma", 2007));
        mapa.put(new Author("Pablo", new ArrayList<>(Arrays.asList(new Libro("Shortcut", "Pablo", 2009)))), new Libro("Shortcut", "Pablo", 2009));
        mapa.put(new Author("Hecproll", new ArrayList<>(Arrays.asList(new Libro("Java", "Hecproll", 2004)))), new Libro("Java", "Hecproll", 2004));
        LibraryCatalog catalog = new LibraryCatalog(mapa);

        //Json
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/java/Ej10/Res.json"), catalog);
            //DES

        } catch (IOException e){
            e.printStackTrace();
        }

        //XML
        try {
            JAXBContext context = JAXBContext.newInstance(catalog.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(catalog, new File("src/main/java/Ej10/Res.xml"));

            //DES

            Unmarshaller unmarshaller = context.createUnmarshaller();
            LibraryCatalog resp = (LibraryCatalog) unmarshaller.unmarshal(new File("src/main/java/Ej10/Res.xml"));
            System.out.println(resp);

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}

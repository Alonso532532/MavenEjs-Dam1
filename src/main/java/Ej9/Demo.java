package Ej9;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        Libro libro1 = new Libro("Libro1", "Pasc", 2007);
        Libro libro2 = new Libro("Libro2", "Rem", 2008);
        Libro libro3 = new Libro("Libro3", "Hec", 2009);
        Publisher publisher = new Publisher("Brevas", "Brevintong street nº67", new ArrayList<>(Arrays.asList(libro1, libro2, libro3)));

        //Json
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/java/Ej9/Res.json"), publisher);
            // DES
            Publisher resul = objectMapper.readValue(new File("src/main/java/Ej9/Res.json"), publisher.getClass());
            System.out.println(resul);
        } catch (Exception e){
            e.printStackTrace();
        }

        Publisher publisher2 = new Publisher("Brevas", "Brevintong street nº67", new ArrayList<>(Arrays.asList(libro1, libro3, libro3)));
        //XML

        try {
            JAXBContext context = JAXBContext.newInstance(publisher2.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(publisher2, new File("src/main/java/Ej9/Res.xml"));

            //DES
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Publisher resp = (Publisher) unmarshaller.unmarshal(new File("src/main/java/Ej9/Res.xml"));
            System.out.println(resp);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

package Transformar;

import Ej7y8.TiendaLibros;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;

public class xml {
    public static void main(String[] args) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            TiendaLibros res = objectMapper.readValue(new File("src/main/java/Ej7y8/Autores.json"), TiendaLibros.class);

            JAXBContext context = JAXBContext.newInstance(TiendaLibros.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(res,new File("src/main/java/Transformar/des.xml"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

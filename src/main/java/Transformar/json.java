package Transformar;

import Ej7y8.TiendaLibros;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class json {
    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(TiendaLibros.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            TiendaLibros resp = (TiendaLibros) unmarshaller.unmarshal(new File("src/main/java/Ej7y8/TiendaLibros.xml"));

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/java/Transformar/des.json"), resp);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

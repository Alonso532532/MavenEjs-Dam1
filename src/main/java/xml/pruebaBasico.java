package xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class pruebaBasico {
    public static void main(String[] args) {
        Libro libro1 = new Libro("cuento", 20.3, 4);
        try {
            JAXBContext context = JAXBContext.newInstance(Libro.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(libro1, System.out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

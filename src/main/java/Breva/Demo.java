package Breva;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("\\[ID: (\\d+)\\] Nombre: ([\\w\\s]+), Edad: (\\d+), Password: (\\S+)");
        HashMap<Integer, Estudiante> estudiantes = new HashMap<>();

        try (BufferedReader leer = new BufferedReader(new FileReader("src/main/java/Breva/Estudiantes.txt"))){
            String linea;
            while ((linea = leer.readLine()) != null){
                Matcher matcher = pattern.matcher(linea);
                while (matcher.find()){
                    estudiantes.put(Integer.parseInt(matcher.group(1)), new Estudiante(Integer.parseInt(matcher.group(1)), matcher.group(2), Integer.parseInt(matcher.group(3)), matcher.group(4)));
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }



//        estudiantes.entrySet().stream().filter(a -> a.getValue().getEdad()>20).sorted(Map.Entry.<Integer, Estudiante> comparingByValue(Comparator.comparingInt(Estudiante::getEdad).reversed())).forEach(a->{mapaOrdenado.put(a.getKey(), a.getValue());});
        ArrayList<Map.Entry<Integer, Estudiante>> filtrado = new ArrayList<>(estudiantes.entrySet());
        filtrado = new ArrayList<>(filtrado.stream().filter(a->a.getValue().getEdad()>20).sorted(Map.Entry.comparingByValue(Comparator.comparingInt(Estudiante::getEdad).reversed())).toList());
        LinkedHashMap<Integer, Estudiante> mapaOrdenado = new LinkedHashMap<>();
        for (Map.Entry<Integer, Estudiante> a : filtrado){
            mapaOrdenado.put(a.getKey(), a.getValue());
        }
        System.out.println(mapaOrdenado.entrySet());

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/java/Breva/Resultado.json"), mapaOrdenado);
        } catch (IOException e){
            e.printStackTrace();
        }

        try {
            JAXBContext context = JAXBContext.newInstance(Serializar.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            Serializar serializar = new Serializar(mapaOrdenado);
            marshaller.marshal(serializar, new File("src/main/java/Breva/Resultado.xml"));

            //DES

            Unmarshaller unmarshaller = context.createUnmarshaller();

            LinkedHashMap<Integer, Estudiante> resp = ((Serializar) unmarshaller.unmarshal(new File("src/main/java/Breva/Resultado.xml"))).getMapa();
            System.out.println(resp.entrySet());

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }



    }
}

package AntesDelFin;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.*;
import java.util.regex.Matcher;

public class Demo {
    public static void main(String[] args) {
        HashMap<Integer, Pedido> pedidos = new HashMap<>();
        pedidos.put(1, new Pedido(new ArrayList<>(Arrays.asList("MC.Pollo", "Patatas", "MC.Flurry M")), 12, "Eker"));
        pedidos.put(2, new Pedido(new ArrayList<>(Arrays.asList("MC.Extreme", "Patatas deluxe", "MC.Flurry L")), 14, "Alons"));
        pedidos.put(3, new Pedido(new ArrayList<>(Arrays.asList("MC.Aitana", "Patatas XL", "MC.Flurry XL")), 16, "Hecproll"));

//        ArrayList<Map.Entry<Integer, Pedido>> lista = new ArrayList<>(pedidos.entrySet());
//
//        lista.stream().filter(a-> a.getValue().getComprador().contains("e")).forEach(System.out::println);
//        lista.stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(Pedido::getPrecio).reversed())).forEach(System.out::println);

        Pedidos hashpedidos = new Pedidos(pedidos);

        try{

            JAXBContext context = JAXBContext.newInstance(Pedidos.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(hashpedidos, new File("src/main/java/AntesDelFin/Res.xml"));

            Unmarshaller unmarshaller = context.createUnmarshaller();

            Pedidos resp = (Pedidos) unmarshaller.unmarshal(new File("src/main/java/AntesDelFin/Res.xml"));
            System.out.println(resp.getPedidos().entrySet());

            ObjectMapper objectMapper = new ObjectMapper();

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/java/AntesDelFin/Res.json"), hashpedidos);

            resp = objectMapper.readValue(new File("src/main/java/AntesDelFin/Res.json"), Pedidos.class);
            System.out.println(resp.getPedidos().entrySet());

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

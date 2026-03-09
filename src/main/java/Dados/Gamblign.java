package Dados;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Gamblign {
    public static void main(String[] args) {
        Jugador j1 = new Jugador("Eker");
        Jugador j2 = new Jugador("Hecproll");
        Jugador j3 = new Jugador("Lozzan");
        ArrayList<Jugador> jugadores = new ArrayList<>(Arrays.asList(j1,j2,j3));

        while (true){
            jugadores.forEach(Jugador::tirarDado);

            if (jugadores.stream().filter(a->a.getValor()>3).count()>2){
                ArrayList<Jugador> resultado = new ArrayList<>(jugadores.stream().filter(a->a.getValor()>3).toList());
                for (Jugador i : resultado){
                    System.out.println(i.getNombre()+"-"+i.getValor());
                }
                System.out.println("Se han tirado "+resultado.getFirst().getTiradas()+" veces");



//                try {
//                    JAXBContext context = JAXBContext.newInstance(Exitos.class);
//
//                    Marshaller marshaller = context.createMarshaller();
//                    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//                    Unmarshaller unmarshaller = context.createUnmarshaller();
//
//                    Exitos todos = new Exitos();
//                    try {
//                        todos = (Exitos) unmarshaller.unmarshal(new File("src/main/java/Dados/Resultado.xml"));
//                    } catch (Exception e){
//
//                    }
//                    todos.getJugadores().add(resultado);
//                    marshaller.marshal(todos, new File("src/main/java/Dados/Resultado.xml"));
//
//                } catch (Exception e){
//                    e.printStackTrace();
//                }
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    Exitos todos = new Exitos();
                    try {
                        todos = objectMapper.readValue(new File("src/main/java/Dados/Resultado.json"), Exitos.class);
                    } catch (Exception e){

                    }
                    todos.getJugadores().add(resultado);
                    objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/java/Dados/Resultado.json"), todos);
                } catch (IOException e){
                    e.printStackTrace();
                }
                return;
            }
        }


    }
}

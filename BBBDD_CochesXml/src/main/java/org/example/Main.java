package org.example;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            /* //Marshalling
            JAXBContext contexto = JAXBContext.newInstance(Coche.class);
            Coche coche = new Coche("1111AAA" , "Seat", "Leon");
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(coche, new File("nuevoCoche.xml"));


            //Unmarshalling
            Unmarshaller unmarshaller = contexto.createUnmarshaller();
            Coche cocheUnmarshaller =(Coche) unmarshaller.unmarshal(new File("nuevoCoche.xml"));
            System.out.println("Matricula" + cocheUnmarshaller.getMatricula());
            System.out.println("Marca" + cocheUnmarshaller.getMarca());
            System.out.println("Modelo" + cocheUnmarshaller.getModelo());
             */

            JAXBContext contexto = JAXBContext.newInstance(BBDDCoches.class);
            Coche coche = new Coche("1111AAA" , "Seat", "Leon");
            Coche coche2 = new Coche("2222bbbb" , "Toyota", "CH - R");
            BBDDCoches bbddCoches = new BBDDCoches();

            List<Coche> listaCoches = new ArrayList<Coche>();
            listaCoches.add(coche);
            listaCoches.add(coche2);
            bbddCoches.setCoches(listaCoches);

            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(bbddCoches, new File("nuevoCoche.xml"));

        } catch (JAXBException e) {
            System.out.println("Error E/S: "+e.getMessage());;
        }
    }
}


package org.example;

import org.json.JSONObject;
import org.json.XML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(juegos.class);

            //Creacion Context Mashaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //Creacion objeto juegos
            juegos juegos = new juegos();
            juegos.setNombre("FIFA 14");
            juegos.setTipo("Pc");
            juegos.setGenero("DEPORTES");
            juegos.setProceso("fifa14");
            juegos.setEdad("3+");
            juegos.setDescripcion("Simulador de fútbol multijugador.");

            // Generacion del Xml
            jaxbMarshaller.marshal(juegos, new File("Newjuegos.xml"));

            //Conversion a Json
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            juegos juegos1 = (juegos) jaxbUnmarshaller.unmarshal(new File("Newjuegos.xml"));
            JSONObject jsonObject = new JSONObject(juegos1);
            String jsonString = jsonObject.toString(5);
            System.out.println(jsonString); // Te mostrara todo el contenido obtenido por consola
            File jsonFile = new File("Newjuegos.json"); // Creacion del archivo json
            FileOutputStream fs = new FileOutputStream(jsonFile);

            // Escritura del JSON en el archivo
            byte[] buffer = jsonString.getBytes();
            fs.write(buffer);

        } catch (JAXBException e) {
            System.out.println("Error JAXBException: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Error FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error IOException: " + e.getMessage());
        }
    }
}
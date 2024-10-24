package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (FileWriter wr = new FileWriter("Library.txt")) {
            JAXBContext contexto = JAXBContext.newInstance(BBDD_Librarys.class);
            BBDD_Librarys bbdd_library = new BBDD_Librarys();

            Unmarshaller unmarshaller = contexto.createUnmarshaller();
            BBDD_Librarys bbddLibrarys = (BBDD_Librarys) unmarshaller.unmarshal(new File("books.xml"));

            for (Book book : bbddLibrarys.getBooks()) {
                wr.write("IdBook: " + book.getIdBook() + "\n");
                wr.write("Author: " + book.getAuthor()+ "\n");
                wr.write("Tilte: " + book.getTitle()+ "\n");
                wr.write("Genre: " + book.getGenre()+ "\n");
                wr.write("Price: " + book.getPrice()+ "\n");
                wr.write("PublishDate: " + book.getPublicationDate()+ "\n");
                wr.write("Description: " + book.getDescription()+ "\n");
                wr.write("\n");
            }
        } catch (JAXBException | IOException e) {
            System.out.println("Error E/S: " + e.getMessage());
        }
    }
}
package org.example;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Catalog")
public class BBDD_Librarys {

    private List<Book> books;

    public BBDD_Librarys() {

    }

    @XmlElement(name = "Book")
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}

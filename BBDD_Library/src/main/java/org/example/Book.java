package org.example;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Book")
public class Book {
    private String idBook;
    private String author;
    private String title;
    private String genre;
    private double price;
    private String publicationDate;
    private String description;

    public Book() {
    }

    public Book(String idBook, String author, String title, String genre, double price, String publicationDate, String description) {
        this.idBook = idBook;
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.publicationDate = publicationDate;
        this.description = description;
    }

    @XmlAttribute(name = "id")
    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    @XmlElement(name = "Author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    @XmlElement(name = "Title")
    public String getTitle() {
        return title ;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @XmlElement(name = "Genre")
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    @XmlElement(name = "Price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    @XmlElement(name = "PublishDate")
    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }
    @XmlElement(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

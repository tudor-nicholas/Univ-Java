package Algorithms.lab2;

public class Book {
    private int idBook;
    private String title;
    private String author;
    private String domain;

    public Book(int idBook, String title, String author, String domain) {
        this.idBook = idBook;
        this.title = title;
        this.author = author;
        this.domain = domain;
    }

    public int getIdBook() {
        return idBook;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDomain() {
        return domain;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String toString() {
        return "--------------------------\n" + idBook + ",\n " + title + ",\n " + author + ",\n " + domain
                + "---------";
    }

    public String toString2() {
        return "(" + idBook + ", " + title + ", " + author + ", " + domain + ")";
    }
}

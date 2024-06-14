package org.cenfotec.mvcpractice.model;

public class BookModel {
    private int id;
    private String title;
    private String author;
    private int publicationYear;
    private int booksAvailables;

    public BookModel (){

    }

    //Constructor//
    public BookModel (String title, String author, int publicationYear, int booksAvailables){
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.booksAvailables = booksAvailables;

    }
    //get//
    public int getId() {return id;}

    public String getTitle() {return title;}

    public String getAuthor() {return author;}

    public int getPublicationYear() {return publicationYear;}

    public int getBooksAvailables() {return booksAvailables;}

    //set//
    public void setId(int id) {this.id = id;}

    public void setTitle(String title) {this.title = title;}

    public void setAuthor(String author) {this.author = author;}

    public void setPublicationYear(int publicationYear) {this.publicationYear = publicationYear;}

    public void setBooksAvailables(int booksAvailables) {this.booksAvailables = booksAvailables;}

    //toString//
    @Override
    public String toString() {
        return "BookModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                ", booksAvailables=" + booksAvailables +
                '}';
    }
}

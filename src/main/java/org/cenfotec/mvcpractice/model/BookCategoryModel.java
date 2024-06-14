package org.cenfotec.mvcpractice.model;

public class BookCategoryModel {
    private int id;
    private int idBook;
    private int idCategory;

    public BookCategoryModel(){

    }

    public BookCategoryModel(int idBook, int idCategory) {
        this.idBook = idBook;
        this.idCategory = idCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    @Override
    public String toString() {
        return "BookCategoryModel{" +
                "id=" + id +
                ", idBook=" + idBook +
                ", idCategory=" + idCategory +
                '}';
    }
}

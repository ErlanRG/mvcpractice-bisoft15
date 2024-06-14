package org.cenfotec.mvcpractice.model;

public class CategoryModel {
    private int id;
    private String name;


    public CategoryModel(){

    }

    public CategoryModel(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

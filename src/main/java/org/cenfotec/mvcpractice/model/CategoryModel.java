package org.cenfotec.mvcpractice.model;

public class CategoryModel {
    private int id;
    private String name;
    private String description;


    public CategoryModel(){

    }
    public CategoryModel(String name, String description) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CategoryModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

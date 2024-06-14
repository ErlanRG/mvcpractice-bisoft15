package org.cenfotec.mvcpractice.model;

public class LibraryModel {
    private int id;
    private String name;
    private String adress;

    public LibraryModel(){

    }
    //Constructor//
    public LibraryModel(String name, String adress) {
        this.name = name;
        this.adress = adress;
    }

    //get and set//

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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "LibraryModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
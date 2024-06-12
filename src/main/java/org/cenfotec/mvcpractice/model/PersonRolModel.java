package org.cenfotec.mvcpractice.model;

public class PersonRolModel {
    private int id;
    private int idPerson;
    private int idRol;


    public PersonRolModel() {
    }

    public PersonRolModel(int idPerson, int idRol) {
        this.idPerson = idPerson;
        this.idRol = idRol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    @Override
    public String toString() {
        return "PersonRolModel{" +
                "id=" + id +
                ", idPerson=" + idPerson +
                ", idRol=" + idRol +
                '}';
    }
}

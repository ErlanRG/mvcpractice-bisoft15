package org.cenfotec.mvcpractice.model;

import java.util.Date;

public class LoanModel {
    private int id;
    private int idBook;
    private int idPerson;
    private Date dateLoan;
    private Date dateDevolution;

    public LoanModel(){
    }

    //Constructor//
    public LoanModel(int idBook, int idPerson, Date dateLoan, Date dateDevolution) {
        this.idBook = idBook;
        this.idPerson = idPerson;
        this.dateLoan = dateLoan;
        this.dateDevolution = dateDevolution;
    }

    //Get and Set//

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

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public Date getDateLoan() {
        return dateLoan;
    }

    public void setDateLoan(Date dateLoan) {
        this.dateLoan = dateLoan;
    }

    public Date getDateDevolution() {
        return dateDevolution;
    }

    public void setDateDevolution(Date dateDevolution) {
        this.dateDevolution = dateDevolution;
    }

    @Override
    public String toString() {
        return "LoanModel{" +
                "id=" + id +
                ", idBook=" + idBook +
                ", idPerson=" + idPerson +
                ", dateLoan=" + dateLoan +
                ", dateDevolution=" + dateDevolution +
                '}';
    }
}

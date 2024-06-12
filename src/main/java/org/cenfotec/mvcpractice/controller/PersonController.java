package org.cenfotec.mvcpractice.controller;

import org.cenfotec.mvcpractice.dao.PersonDAO;
import org.cenfotec.mvcpractice.model.ConnectionModel;
import org.cenfotec.mvcpractice.model.PersonModel;
import org.cenfotec.mvcpractice.view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;

public class PersonController {
    private ConsoleView consoleView;
    private PersonDAO personDAO;

    public PersonController(ConsoleView consoleView) {
        this.consoleView = consoleView;
        Connection connection = ConnectionModel.getConnection();
        this.personDAO = new PersonDAO(connection);
    }

    public void addPerson(String name, String lastName, String email, String phone) {
        PersonModel person = new PersonModel(name, lastName, email, phone);

        try {
            personDAO.addPerson(person);
            consoleView.showMessage("Persona agregada correctamente");
        } catch (SQLException e) {
            consoleView.errorMessage("Error al agregar persona: " + e.getMessage());
        }
    }
}

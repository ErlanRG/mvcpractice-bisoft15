package org.cenfotec.mvcpractice.controller;

import org.cenfotec.mvcpractice.dao.PersonDAO;
import org.cenfotec.mvcpractice.dao.PersonRolDAO;
import org.cenfotec.mvcpractice.model.ConnectionModel;
import org.cenfotec.mvcpractice.model.PersonModel;
import org.cenfotec.mvcpractice.view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonController {
    private ConsoleView consoleView;
    private PersonDAO personDAO;
    private PersonRolDAO personRolDAO;

    public PersonController(ConsoleView consoleView) {
        this.consoleView = consoleView;
        Connection connection = ConnectionModel.getConnection();
        this.personDAO = new PersonDAO(connection);
        this.personRolDAO = new PersonRolDAO(connection);
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

    public List<PersonModel> getAllPersons() {
        List<PersonModel> persons = new ArrayList<>();
        try {
            persons = personDAO.findAll();
        } catch (SQLException e) {
            consoleView.errorMessage("Error al consultar personas: " + e.getMessage());
        }
        return persons;
    }

    public PersonModel getPersonByEmail(String email) {
        PersonModel person = null;

        try {
            person = personDAO.findPersonByEmail(email);
        } catch (SQLException e) {
            consoleView.errorMessage("Error al obtener persona: " + e.getMessage());
        }

        return person;
    }

    public void updatePerson(PersonModel person) {
        try {
            personDAO.updatePerson(person);
            consoleView.showMessage("Persona actualizada correctamente");
        } catch (SQLException e) {
            consoleView.errorMessage("Error al actualizar persona: " + e.getMessage());
        }
    }

    public void deletePerson(PersonModel person) {
        try {
            personRolDAO.deletePersonRoles(person);
            personDAO.deletePerson(person);
            consoleView.showMessage("Persona eliminada correctamente");
        } catch (SQLException e) {
            consoleView.errorMessage("Error al eliminar persona: " + e.getMessage());
        }
    }
}

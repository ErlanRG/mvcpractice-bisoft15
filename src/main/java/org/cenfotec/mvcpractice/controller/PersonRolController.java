package org.cenfotec.mvcpractice.controller;

import org.cenfotec.mvcpractice.dao.PersonRolDAO;
import org.cenfotec.mvcpractice.model.ConnectionModel;
import org.cenfotec.mvcpractice.model.PersonRolModel;
import org.cenfotec.mvcpractice.view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;

public class PersonRolController {
    private ConsoleView consoleView;
    private PersonRolDAO personRolDAO;

    public PersonRolController(ConsoleView consoleView) {
        this.consoleView = consoleView;
        Connection connection = ConnectionModel.getConnection();
        this.personRolDAO = new PersonRolDAO(connection);
    }

    public void addPersonRolRelation(int personId, int rolId) {
        PersonRolModel personRolRelation = new PersonRolModel(personId, rolId);

        try {
            personRolDAO.addPersonRol(personRolRelation);
            consoleView.showMessage("Rol ID: " + personRolRelation.getIdRol() + " fue agregado correctamente al Persona ID: " + personRolRelation.getIdPerson());
        } catch (SQLException e) {
            consoleView.errorMessage("Error al agregar la relación: " + e.getMessage());
        }
    }
}

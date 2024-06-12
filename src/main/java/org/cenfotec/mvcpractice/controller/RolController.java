package org.cenfotec.mvcpractice.controller;

import org.cenfotec.mvcpractice.dao.RolDAO;
import org.cenfotec.mvcpractice.model.ConnectionModel;
import org.cenfotec.mvcpractice.model.RolModel;
import org.cenfotec.mvcpractice.view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;

public class RolController {
    private ConsoleView consoleView;
    private RolDAO rolDao;

    public RolController(ConsoleView consoleView) {
        this.consoleView = consoleView;
        Connection connection = ConnectionModel.getConnection();
        this.rolDao = new RolDAO(connection);
    }

    public void addRol(String name, String description) {
        RolModel rol = new RolModel(name, description);

        try {
            rolDao.addRol(rol);
            consoleView.showMessage("Rol agregado con éxito");
        } catch (SQLException e) {
            consoleView.errorMessage("Error al agregar rol: " + e.getMessage());
        }
    }
}

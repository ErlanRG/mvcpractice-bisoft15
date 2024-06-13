package org.cenfotec.mvcpractice.controller;

import org.cenfotec.mvcpractice.dao.PersonRolDAO;
import org.cenfotec.mvcpractice.dao.RolDAO;
import org.cenfotec.mvcpractice.model.ConnectionModel;
import org.cenfotec.mvcpractice.model.RolModel;
import org.cenfotec.mvcpractice.view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RolController {
    private ConsoleView consoleView;
    private RolDAO rolDao;
    private PersonRolDAO personRolDAO;

    public RolController(ConsoleView consoleView) {
        this.consoleView = consoleView;
        Connection connection = ConnectionModel.getConnection();
        this.rolDao = new RolDAO(connection);
        this.personRolDAO = new PersonRolDAO(connection);
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

    public List<RolModel> getAllRoles() {
        List<RolModel> roles = new ArrayList<>();
        try {
            roles = rolDao.findAll();
        } catch (SQLException e) {
            consoleView.errorMessage("Error al consultar roles: " + e.getMessage());
        }
        return roles;
    }

    public RolModel getRolById(int id) {
        RolModel rol = null;
        try {
            rol = rolDao.findById(id);
        } catch (SQLException e) {
            consoleView.errorMessage("Error al consultar rol: " + e.getMessage());
        }
        return rol;
    }

    public void updateRole(RolModel rol) {
        try {
            rolDao.updateRole(rol);
            consoleView.showMessage("Rol actualizado correctamente.");
        } catch (SQLException e) {
            consoleView.errorMessage("Error al actualizar rol: " + e.getMessage());
        }
    }

    public void deleteRole(RolModel rol) {
        try {
            personRolDAO.deleteRol(rol);
            rolDao.deleteRole(rol);
            consoleView.showMessage("Rol eliminado correctamente.");
        } catch (SQLException e) {
            consoleView.errorMessage("Error al eliminar rol: " + e.getMessage());
        }
    }
}

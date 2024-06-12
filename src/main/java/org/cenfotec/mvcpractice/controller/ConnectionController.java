package org.cenfotec.mvcpractice.controller;

import org.cenfotec.mvcpractice.model.Connection;
import org.cenfotec.mvcpractice.view.ConsoleView;

import java.sql.SQLException;

public class ConnectionController {

    //vista en el cual muestre los datos
    private ConsoleView viewConsole;

    public ConnectionController(ConsoleView viewConsole) {
        this.viewConsole = viewConsole;
    }

    public void openConnection() {
        java.sql.Connection connection = Connection.getConnection();
        if (connection != null) {
            try {
                connection.close();
                viewConsole.showMessage("Conexion Establecida");
            } catch (SQLException e) {
                viewConsole.errorMessage("Error al conectar" + e.getMessage());
            }
        }
    }

}

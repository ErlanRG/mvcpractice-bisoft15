package org.cenfotec.mvcpractice.model;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionModel {

    private static final String URL = "jdbc:mysql://45.88.196.5:3306/u484426513_diseno224";
    private static final String USER = "u484426513_diseno224";
    private static final String PASSWORD = "#7cYr646u@*Rp.P";

    public static java.sql.Connection getConnection() {
        java.sql.Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado al servidor remoto");
        } catch (SQLException e) {
            System.err.println("Falló connectionModel" + e.getMessage());
        }
        return connection;
    }
}

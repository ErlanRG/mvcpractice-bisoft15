package controller;

import model.Connection;
import model.CourseDAO;
import model.CourseModel;
import view.ConsoleView;

import java.sql.SQLException;

public class CourseController {

    private ConsoleView viewConsole;

    private CourseDAO courseDAO;

    public CourseController(ConsoleView viewConsole) {
        this.viewConsole = viewConsole;
        java.sql.Connection connection = Connection.getConnection();
        this.courseDAO = new CourseDAO(connection);
    }

    public void agregarCurso(String nombre, int estado) {
        CourseModel datos = new CourseModel(nombre, estado);

        try {
            courseDAO.agregarCurso(datos);
            viewConsole.showMessage("Insercion de datos correcta");
        } catch (SQLException e) {
            viewConsole.errorMessage("Error al insertar datos: " + e.getMessage());
        }
    }

}




























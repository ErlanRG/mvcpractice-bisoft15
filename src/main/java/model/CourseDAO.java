package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CourseDAO {
    private Connection connection;

    public CourseDAO(Connection connection) {
        this.connection = connection;
    }

    public void agregarCurso(CourseModel objeto) throws SQLException {
        String query = "INSERT INTO `curso`( `nombre`, `estado`) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, objeto.getNombre());
            stmt.setInt(2, objeto.getEstado());
            stmt.executeUpdate();
        }
    }
}

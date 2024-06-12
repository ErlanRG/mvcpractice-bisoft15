package org.cenfotec.mvcpractice.dao;

import org.cenfotec.mvcpractice.model.PersonModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonDAO {
    private Connection connection;

    public PersonDAO(Connection connection) {
        this.connection = connection;
    }

    public void addPerson(PersonModel person) throws SQLException {
        String query = "INSERT INTO `RAN_NAR_Persona` (`nombre`, `apellido`, `email`, `telefono`) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, person.getName());
            stmt.setString(2, person.getLastName());
            stmt.setString(3, person.getEmail());
            stmt.setString(4, person.getPhone());
            stmt.execute();
        } catch (SQLException e) {
            throw e;
        }
    }
}

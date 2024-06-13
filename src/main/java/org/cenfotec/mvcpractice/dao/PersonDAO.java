package org.cenfotec.mvcpractice.dao;

import org.cenfotec.mvcpractice.model.PersonModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<PersonModel> findAll() throws SQLException {
        List<PersonModel> persons = new ArrayList<>();
        String query = "SELECT * FROM RAN_NAR_Persona";

        try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                PersonModel person = new PersonModel();
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("nombre"));
                person.setLastName(rs.getString("apellido"));
                person.setEmail(rs.getString("email"));
                person.setPhone(rs.getString("telefono"));
                persons.add(person);
            }
        } catch (SQLException e) {
            throw e;
        }
        return persons;
    }

    public PersonModel findPersonByEmail(String email) throws SQLException {
        PersonModel person = null;
        String query = "SELECT * FROM `RAN_NAR_Persona` WHERE email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    person = new PersonModel();
                    person.setId(rs.getInt("id"));
                    person.setName(rs.getString("nombre"));
                    person.setLastName(rs.getString("apellido"));
                    person.setEmail(rs.getString("email"));
                    person.setPhone(rs.getString("telefono"));
                }
            }
        }
        return person;
    }

    public void updatePerson(PersonModel person) throws SQLException {
        String query = "UPDATE `RAN_NAR_Persona` SET `nombre` = ?, `apellido` = ?, `email` = ?, `telefono` = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, person.getName());
            stmt.setString(2, person.getLastName());
            stmt.setString(3, person.getEmail());
            stmt.setString(4, person.getPhone());
            stmt.setInt(5, person.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    public void deletePerson(PersonModel person) throws SQLException {
        String query = "DELETE FROM `RAN_NAR_Persona` WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, person.getId());
            stmt.execute();
        } catch (SQLException e) {
            throw e;
        }
    }
}
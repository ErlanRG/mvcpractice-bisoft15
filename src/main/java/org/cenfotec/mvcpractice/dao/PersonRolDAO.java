package org.cenfotec.mvcpractice.dao;

import org.cenfotec.mvcpractice.model.PersonModel;
import org.cenfotec.mvcpractice.model.PersonRolModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonRolDAO {
    private Connection connection;

    public PersonRolDAO(Connection connection) {
        this.connection = connection;
    }

    public void addPersonRol(PersonRolModel personRolRelation) throws SQLException {
        String sql = "INSERT INTO `RAN_NAR_PersonaRol` (`idPersona`, `idRol`) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, personRolRelation.getIdPerson());
            stmt.setInt(2, personRolRelation.getIdRol());
            stmt.execute();
        } catch (SQLException e) {
            throw e;
        }
    }

    public void deletePersonRoles(PersonModel person) throws SQLException {
        String query = "DELETE FROM `RAN_NAR_PersonaRol` WHERE idPersona = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, person.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }
}

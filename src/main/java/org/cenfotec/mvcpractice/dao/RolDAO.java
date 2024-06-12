package org.cenfotec.mvcpractice.dao;

import org.cenfotec.mvcpractice.model.RolModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RolDAO {
    private Connection connection;

    public RolDAO(Connection connection) {
        this.connection = connection;
    }

    public void addRol(RolModel rol) throws SQLException {
        String query = "INSERT INTO `RAN_NAR_Rol` (`nombre`, `descripcion`) VALUES(?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, rol.getName());
            stmt.setString(2, rol.getDescription());
            stmt.execute();
        } catch (SQLException e) {
            throw e;
        }
    }
}

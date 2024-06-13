package org.cenfotec.mvcpractice.dao;

import org.cenfotec.mvcpractice.model.RolModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<RolModel> findAll() throws SQLException {
        List<RolModel> roles = new ArrayList<>();
        String query = "SELECT * FROM RAN_NAR_Rol";
        try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                RolModel role = new RolModel();
                role.setId(rs.getInt("id"));
                role.setName(rs.getString("nombre"));
                role.setDescription(rs.getString("descripcion"));
                roles.add(role);
            }
        } catch (SQLException e) {
            throw e;
        }
        return roles;
    }

    public RolModel findById(int id) throws SQLException {
        RolModel role = null;
        String query = "SELECT * FROM RAN_NAR_Rol WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    role = new RolModel();
                    role.setId(rs.getInt("id"));
                    role.setName(rs.getString("nombre"));
                    role.setDescription(rs.getString("descripcion"));
                }
            }
        }
        return role;
    }

    public void updateRole(RolModel rol) throws SQLException {
        String query = "UPDATE `RAN_NAR_Rol` SET `nombre` = ?, `descripcion` = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, rol.getName());
            stmt.setString(2, rol.getDescription());
            stmt.setInt(3, rol.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    public void deleteRole(RolModel rol) throws SQLException {
        String query = "DELETE FROM `RAN_NAR_Rol` WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, rol.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }
}

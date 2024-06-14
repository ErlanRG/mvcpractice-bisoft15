package org.cenfotec.mvcpractice.dao;

import org.cenfotec.mvcpractice.model.LibraryModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class LibraryDAO {
    private Connection connection;

    public LibraryDAO(Connection connection) {
        this.connection = connection;
    }

    //Añadir//
    public void addLibrary(LibraryModel library) throws SQLException {
        String query = "INSERT INTO 'RAN_NAR_Library' ('nombre', 'direccion') VALUES (?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, library.getName());
            stmt.setString(2, library.getAdress());
            stmt.execute();
        } catch (SQLException e) {
            throw e;
        }
    }

    //Mostrar//
    public List<LibraryModel> findAll() throws SQLException {
        List<LibraryModel> libraries = new ArrayList<>();
        String query = "SELECT * FROM RAN_NAR_Library";
        try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                LibraryModel library = new LibraryModel();
                library.setId(rs.getInt("id"));
                library.setName(rs.getString("nombre"));
                library.setAdress(rs.getString("direccion"));
                libraries.add(library);
            }
        } catch (SQLException e) {
            throw e;
        }
        return libraries;
    }

    //Encontrar por Id//
    public LibraryModel findById(int id) throws SQLException {
        LibraryModel library = null;
        String query = "SELECT * FROM RAN_NAR_Library WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    library = new LibraryModel();
                    library.setId(rs.getInt("id"));
                    library.setName(rs.getString("nombre"));
                    library.setAdress(rs.getString("direccion"));
                }
            }
        }
        return library;
    }

    //Actualizar//
    public void updateLibrary(LibraryModel library) throws SQLException {
        String query = "UPDATE `RAN_NAR_Library` SET `nombre` = ?, `direccion` = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, library.getName());
            stmt.setString(2, library.getAdress());
            stmt.setInt(3, library.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    //Eliminar//
    public void deleteLibrary(LibraryModel library) throws SQLException {
        String query = "DELETE FROM `RAN_NAR_Library` WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, library.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }

    }
}

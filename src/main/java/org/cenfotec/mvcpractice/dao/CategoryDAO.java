package org.cenfotec.mvcpractice.dao;

import org.cenfotec.mvcpractice.model.CategoryModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class CategoryDAO {
    private Connection connection;

    public CategoryDAO(Connection connection) {this.connection = connection; }

    //Añadir//
    public void addCategory(CategoryModel category) throws SQLException{
        String query = "INSERT INTO 'RAN_NAR_Category'('nombre', 'descripcion') VALUES (?, ?) ";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, category.getName());
            stmt.setString(2, category.getDescription());
            stmt.execute();
        }catch (SQLException e) {
            throw e;
        }
    }

    //Mostrar//
    public List<CategoryModel> findAll() throws SQLException{
        List<CategoryModel> categories = new ArrayList<>();
        String query = "SELECT * FROM RAN_NAR_Category";
        try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery();) {
            while(rs.next()){
                CategoryModel category = new CategoryModel();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("nombre"));
                category.setDescription(rs.getString("descripcion"));
                categories.add(category);
            }
        }catch (SQLException e) {
            throw e;
        }
        return categories;
    }

    //Encontrar por Id//
    public CategoryModel findById(int id) throws SQLException {
        CategoryModel category = null;
        String query = "SELECT * FROM RAN_NAR_Category WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    category = new CategoryModel();
                    category.setId(rs.getInt("id"));
                    category.setName(rs.getString("nombre"));
                    category.setDescription(rs.getString("descripcion"));
                }
            }
        }
        return category;
    }

    //Actualizar//
    public void updateCategory(CategoryModel category) throws SQLException {
        String query = "UPDATE `RAN_NAR_Category` SET `nombre` = ?, `descripcion` = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, category.getName());
            stmt.setString(2, category.getDescription());
            stmt.setInt(3, category.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    //Eliminar//
    public void deleteCategory(CategoryModel category) throws SQLException {
        String query = "DELETE FROM `RAN_NAR_Rol` WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, category.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }
}

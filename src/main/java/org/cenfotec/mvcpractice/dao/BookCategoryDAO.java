package org.cenfotec.mvcpractice.dao;

import org.cenfotec.mvcpractice.model.BookCategoryModel;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class BookCategoryDAO {
    private Connection connection;

    public BookCategoryDAO(Connection connection) {this.connection = connection;}

    //Añadir libro a categoría//
    public void addBookCategory (BookCategoryModel bookCategory) throws SQLException{
        String query = "INSERT INTO `RAN_NAR_BookCategory` (`id_libro`, `id_categoria`) VALUES ( ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, bookCategory.getIdBook());
            stmt.setInt(2, bookCategory.getIdCategory());
        }catch (SQLException e) {
            throw e;
        }
    }

    //Mostrar todos los datos//
    public List<BookCategoryModel> findAll() throws SQLException{
        List<BookCategoryModel> bookCategories = new ArrayList<>();
        String query = "SELECT * FROM RAN_NAR_BookCategory";

        try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery();) {
            while (rs.next()){
                BookCategoryModel bookCategory = new BookCategoryModel();
                bookCategory.setId(rs.getInt("id"));
                bookCategory.setIdBook(rs.getInt("id_libro"));
                bookCategory.setIdCategory(rs.getInt("id_categorias"));
                bookCategories.add(bookCategory);
            }
        }catch (SQLException e) {
            throw e;
        }
        return bookCategories;
    }

    //Actualizar//
    public void updateBookCategory(BookCategoryModel bookCategory) throws SQLException {
        String query = "UPDATE `RAN_NAR_BookCategory` SET `id_libro` = ?, `id_categoria` = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, bookCategory.getIdBook());
            stmt.setInt(3, bookCategory.getIdCategory());
            stmt.setInt(3, bookCategory.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }
    //Eliminar//
    public void deleteBookCategory(BookCategoryModel bookCategory) throws SQLException {
        String query = "DELETE FROM `RAN_NAR_BookCategory` WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, bookCategory.getId());
            stmt.execute();
        } catch (SQLException e) {
            throw e;
        }
    }
}
